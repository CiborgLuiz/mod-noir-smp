package net.mcreator.noirsmp;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.resources.ResourceLocation;
import net.mcreator.noirsmp.init.NoirSmpModTabs;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class NoirTabStyler {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            try {
                CreativeModeTab tab = NoirSmpModTabs.NOIR_SMP.get();
                
                Field backgroundField;
                try {
                    backgroundField = CreativeModeTab.class.getDeclaredField("backgroundLocation");
                } catch (NoSuchFieldException e) {
                    backgroundField = CreativeModeTab.class.getDeclaredField("f_244569_");
                }
                backgroundField.setAccessible(true);
                backgroundField.set(tab, new ResourceLocation("noir_smp", "textures/screens/tab_noir.png"));

                Field tabsImageField;
                try {
                    tabsImageField = CreativeModeTab.class.getDeclaredField("tabsImage");
                } catch (NoSuchFieldException e) {
                    tabsImageField = CreativeModeTab.class.getDeclaredField("f_244301_");
                }
                tabsImageField.setAccessible(true);
                tabsImageField.set(tab, new ResourceLocation("noir_smp", "textures/screens/tab_icon_noir.png"));

            } catch (Exception e) {
                System.out.println("Noir SMP Error: Falha ao aplicar texturas customizadas nas abas.");
                e.printStackTrace();
            }
        });
    }
}