package net.mcreator.noirsmp.init;

import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import net.mcreator.noirsmp.client.renderer.OculosDaVerdadeCuriosRenderer;

public class NoirSmpModCuriosRenderers {
	public static void registerRenderers(FMLClientSetupEvent event) {
		CuriosRendererRegistry.register(NoirSmpModItems.OCULOS_DA_VERDADE.get(), OculosDaVerdadeCuriosRenderer::new);
	}
}