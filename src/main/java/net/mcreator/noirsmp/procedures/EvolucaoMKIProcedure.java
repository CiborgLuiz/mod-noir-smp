package net.mcreator.noirsmp.procedures;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

import net.mcreator.noirsmp.init.NoirSmpModItems;

import java.util.List;
import java.util.Locale;

@Mod.EventBusSubscriber(
    modid = "noir_smp",
    value = Dist.CLIENT,
    bus = Mod.EventBusSubscriber.Bus.FORGE
)
public class EvolucaoMKIProcedure {

    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {

        ItemStack stack = event.getItemStack();

        if (stack.getItem() != NoirSmpModItems.LAMINA_DE_CONTENCAO_MKI.get())
            return;

        List<Component> tooltip = event.getToolTip();

        double kills = stack.getOrCreateTag().getDouble("kills");
        double hits = stack.getOrCreateTag().getDouble("hits");
        double hitscrit = stack.getOrCreateTag().getDouble("hitscrit");
        double andada = stack.getOrCreateTag().getDouble("andada");
        double dano = stack.getOrCreateTag().getDouble("dano");

        int nivelDano = Math.min(
            10,
            (int) (kills / 1000)
        );

        int nivelAttack = Math.min(
            10,
            (int) (hitscrit / 500)
        );

        int nivelSpeed = Math.min(
            10,
            (int) (andada / 2000)
        );

        int nivelArmor = Math.min(
            10,
            (int) (dano / 10000)
        );

        double bonusDano = nivelDano;

        double bonusAttackSpeed = nivelAttack * 0.05;

        double bonusSpeed = nivelSpeed * 0.5;

        double bonusArmor = nivelArmor;

        int level = calcularNivelGeral(
            nivelDano,
            nivelAttack,
            nivelSpeed,
            nivelArmor
        );

        tooltip.add(
            Component.literal("")
        );

        tooltip.add(
            Component.literal("[ MK-I ]  CONTAINMENT BLADE")
                .withStyle(
                    ChatFormatting.GOLD,
                    ChatFormatting.BOLD
                )
        );

        tooltip.add(
            Component.literal(
                "✖ Damage             +" + formatar(bonusDano)
            ).withStyle(ChatFormatting.RED)
        );

        tooltip.add(
            Component.literal(
                criarBarra(nivelDano, 10)
                + "  " + formatarNivel(nivelDano)
            ).withStyle(ChatFormatting.DARK_RED)
        );

        tooltip.add(
            Component.literal(
                "⚔ Attack Speed      +" + formatar(bonusAttackSpeed)
            ).withStyle(ChatFormatting.WHITE)
        );

        tooltip.add(
            Component.literal(
                criarBarra(nivelAttack, 10)
                + "  " + formatarNivel(nivelAttack)
            ).withStyle(ChatFormatting.YELLOW)
        );

        tooltip.add(
            Component.literal(
                "◆ Movement Speed     +" + formatar(bonusSpeed) + "%"
            ).withStyle(ChatFormatting.AQUA)
        );

        tooltip.add(
            Component.literal(
                criarBarra(nivelSpeed, 10)
                + "  " + formatarNivel(nivelSpeed)
            ).withStyle(ChatFormatting.DARK_AQUA)
        );

        tooltip.add(
            Component.literal(
                "✦ Armor Penetration  +" + formatar(bonusArmor) + "%"
            ).withStyle(ChatFormatting.GOLD)
        );

        tooltip.add(
            Component.literal(
                criarBarra(nivelArmor, 10)
                + "  " + formatarNivel(nivelArmor)
            ).withStyle(ChatFormatting.GOLD)
        );

        tooltip.add(
            Component.literal("")
        );

        tooltip.add(
            Component.literal(
                "LEVEL " + formatarNivel(level)
            ).withStyle(
                ChatFormatting.LIGHT_PURPLE,
                ChatFormatting.BOLD
            )
        );

        tooltip.add(
            Component.literal(
                criarBarra(level, 10)
            ).withStyle(ChatFormatting.LIGHT_PURPLE)
        );

        tooltip.add(
            Component.literal("")
        );

        tooltip.add(
            Component.literal("[ USAGE ]")
                .withStyle(
                    ChatFormatting.GRAY,
                    ChatFormatting.BOLD
                )
        );

        tooltip.add(
            Component.literal(
                "Kills       " + formatarInteiro(kills)
            ).withStyle(ChatFormatting.WHITE)
        );

        tooltip.add(
            Component.literal(
                "Criticals   " + formatarInteiro(hitscrit)
            ).withStyle(ChatFormatting.WHITE)
        );

        tooltip.add(
            Component.literal(
                "Hits        " + formatarInteiro(hits)
            ).withStyle(ChatFormatting.WHITE)
        );

        tooltip.add(
            Component.literal(
                "Distance    " + formatarDistancia(andada)
            ).withStyle(ChatFormatting.WHITE)
        );

        tooltip.add(
            Component.literal(
                "Damage      " + formatarInteiro(dano)
            ).withStyle(ChatFormatting.WHITE)
        );
    }

    private static String criarBarra(int nivel, int maximo) {

        StringBuilder barra = new StringBuilder();

        for (int i = 0; i < maximo; i++) {

            if (i < nivel) {
                barra.append("█");
            } else {
                barra.append("░");
            }
        }

        return barra.toString();
    }

    private static String formatarNivel(int nivel) {

        return String.format(
            Locale.US,
            "%02d/10",
            nivel
        );
    }

    private static int calcularNivelGeral(
        int dano,
        int attack,
        int speed,
        int armor
    ) {

        return Math.min(
            10,
            (dano + attack + speed + armor) / 4
        );
    }

    private static String formatar(double valor) {

        if (valor == (int) valor) {

            return String.valueOf(
                (int) valor
            );
        }

        return String.format(
            Locale.US,
            "%.2f",
            valor
        );
    }

    private static String formatarInteiro(double valor) {

        return String.format(
            Locale.US,
            "%,d",
            (int) valor
        );
    }

    private static String formatarDistancia(double blocos) {

        double km = blocos / 1000.0;

        return String.format(
            Locale.US,
            "%.1f km",
            km
        );
    }
}