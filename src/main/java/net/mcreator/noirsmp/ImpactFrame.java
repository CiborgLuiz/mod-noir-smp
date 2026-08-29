package net.mcreator.noirsmp;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.Matrix4f;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ImpactFrame {

    private static int framesLeft = 0;
    public static boolean isActive = false;
    
    private static boolean pendingTrigger = false;
    private static double targetX, targetY, targetZ;
    private static String targetDimension = "";

    private static final ResourceLocation SHADER_ID = ResourceLocation.fromNamespaceAndPath("minecraft", "shaders/post/desaturate.json");
    private static final ResourceLocation SOUND_RES = ResourceLocation.fromNamespaceAndPath("noir_smp", "impact");
    
    private static final ResourceLocation[] FRAMES = new ResourceLocation[]{
        ResourceLocation.fromNamespaceAndPath("noir_smp", "textures/screens/frame_0.png"),
        ResourceLocation.fromNamespaceAndPath("noir_smp", "textures/screens/frame_1.png"),
        ResourceLocation.fromNamespaceAndPath("noir_smp", "textures/screens/frame_2.png"),
        ResourceLocation.fromNamespaceAndPath("noir_smp", "textures/screens/frame_3.png"),
        ResourceLocation.fromNamespaceAndPath("noir_smp", "textures/screens/frame_4.png")
    };

    public static void trigger(double x, double y, double z, String dimension) {
        targetX = x;
        targetY = y;
        targetZ = z;
        targetDimension = dimension;
        pendingTrigger = true;
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Minecraft mc = Minecraft.getInstance();
            
            if (pendingTrigger) {
                pendingTrigger = false;
                
                if (mc.player != null && mc.level != null) {
                    
                    String currentDim = mc.level.dimension().location().toString();
                    if (currentDim.equals(targetDimension)) {
                        
                        if (mc.player.distanceToSqr(targetX, targetY, targetZ) <= 2500) {
                            
                            Vec3 look = mc.player.getLookAngle();
                            Vec3 toImpact = new Vec3(targetX - mc.player.getX(), targetY - mc.player.getEyeY(), targetZ - mc.player.getZ()).normalize();
                            
                            if (look.dot(toImpact) > 0.3) {
                                if (!isActive && mc.gameRenderer != null) {
                                    mc.gameRenderer.loadEffect(SHADER_ID);
                                    SoundEvent soundEvent = SoundEvent.createVariableRangeEvent(SOUND_RES);
                                    mc.getSoundManager().play(SimpleSoundInstance.forUI(soundEvent, 1.0F));
                                }
                                isActive = true;
                                framesLeft = 5; 
                            }
                        }
                    }
                }
            }

            if (isActive) {
                if (framesLeft > 0) {
                    framesLeft--;
                    if (framesLeft <= 0) {
                        isActive = false;
                        if (mc.gameRenderer != null) {
                            mc.gameRenderer.shutdownEffect(); 
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onRenderGuiPre(RenderGuiEvent.Pre event) {
        if (isActive) {
            event.setCanceled(true);

            Minecraft mc = Minecraft.getInstance();
            int width = mc.getWindow().getGuiScaledWidth();
            int height = mc.getWindow().getGuiScaledHeight();

            int frameIndex = 5 - framesLeft;
            if (frameIndex < 0) frameIndex = 0;
            if (frameIndex > 4) frameIndex = 4;

            RenderSystem.disableDepthTest();
            RenderSystem.enableBlend();
            
            RenderSystem.blendFuncSeparate(
                GlStateManager.SourceFactor.ONE_MINUS_DST_COLOR, 
                GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR, 
                GlStateManager.SourceFactor.ONE, 
                GlStateManager.DestFactor.ZERO
            );

            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F); 
            RenderSystem.setShaderTexture(0, FRAMES[frameIndex]); 

            Tesselator tesselator = Tesselator.getInstance();
            BufferBuilder builder = tesselator.getBuilder();
            Matrix4f matrix = event.getGuiGraphics().pose().last().pose();

            builder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
            builder.vertex(matrix, 0, height, 0).uv(0.0f, 1.0f).endVertex();
            builder.vertex(matrix, width, height, 0).uv(1.0f, 1.0f).endVertex();
            builder.vertex(matrix, width, 0, 0).uv(1.0f, 0.0f).endVertex();
            builder.vertex(matrix, 0, 0, 0).uv(0.0f, 0.0f).endVertex();
            tesselator.end();

            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            RenderSystem.enableDepthTest();
        }
    }
}