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
public class EvolucaoMKIIProcedure {

    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {

        ItemStack stack = event.getItemStack();

        if (stack.getItem() != NoirSmpModItems.LAMINA_DE_CONTENCAO_MKII.get())
            return;

        List<Component> tooltip = event.getToolTip();

        double kills = stack.getOrCreateTag().getDouble("kills");
        double hits = stack.getOrCreateTag().getDouble("hits");
        double hitscrit = stack.getOrCreateTag().getDouble("hitscrit");
        double andada = stack.getOrCreateTag().getDouble("andada");
        double dano = stack.getOrCreateTag().getDouble("dano");

        int nivelDano = calcularNivel(
            kills,
            new double[] {
                2000,
                5000,
                10000,
                20000,
                35000,
                55000,
                80000,
                110000,
                150000,
                200000
            }
        );

        int nivelAttack = calcularNivel(
            hitscrit,
            new double[] {
                1000,
                2500,
                5000,
                10000,
                20000,
                35000,
                55000,
                80000,
                110000,
                150000
            }
        );

        int nivelSpeed = calcularNivel(
            andada,
            new double[] {
                5000,
                10000,
                20000,
                35000,
                55000,
                80000,
                110000,
                140000,
                170000,
                200000
            }
        );

        int nivelArmor = calcularNivel(
            dano,
            new double[] {
                25000,
                75000,
                150000,
                300000,
                500000,
                750000,
                1000000,
                1250000,
                1600000,
                2000000
            }
        );

        int nivelLifesteal = calcularNivel(
            dano,
            new double[] {
                50000,
                125000,
                250000,
                500000,
                1000000,
                2000000,
                4000000,
                7000000,
                12000000,
                20000000
            }
        );

        int nivelLuck = calcularNivel(
            kills,
            new double[] {
                5000,
                15000,
                30000,
                60000,
                100000,
                150000,
                225000,
                300000,
                400000,
                500000
            }
        );

        int nivelCritChance = calcularNivel(
            hitscrit,
            new double[] {
                1000,
                3000,
                7500,
                15000,
                30000,
                50000,
                75000,
                110000,
                150000,
                200000
            }
        );

        double bonusDano = calcularBonus(
            nivelDano,
            new double[] {
                1.5,
                3.0,
                4.5,
                6.0,
                7.5,
                9.0,
                10.5,
                12.0,
                13.5,
                15.0
            }
        );

        double bonusAttackSpeed = nivelAttack * 0.10;

        double bonusSpeed = nivelSpeed * 0.75;

        double bonusArmor = nivelArmor * 1.5;

        double bonusLifesteal = nivelLifesteal * 0.5;

        double bonusLuck = nivelLuck;

        double bonusCritChance = nivelCritChance * 0.75;

        int level = calcularNivelGeral(
            nivelDano,
            nivelAttack,
            nivelSpeed,
            nivelArmor,
            nivelLifesteal,
            nivelLuck,
            nivelCritChance
        );

        tooltip.add(
            Component.literal("")
        );

        tooltip.add(
            Component.literal("[ MK-II ]  CONTAINMENT BLADE")
                .withStyle(
                    ChatFormatting.RED,
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
                "⚔ Attack Speed       +" + formatar(bonusAttackSpeed)
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
            Component.literal(
                "♥ Lifesteal           +" + formatar(bonusLifesteal) + "%"
            ).withStyle(ChatFormatting.DARK_RED)
        );

        tooltip.add(
            Component.literal(
                criarBarra(nivelLifesteal, 10)
                + "  " + formatarNivel(nivelLifesteal)
            ).withStyle(ChatFormatting.RED)
        );

        tooltip.add(
            Component.literal(
                "♣ Luck                +" + formatar(bonusLuck)
            ).withStyle(ChatFormatting.GREEN)
        );

        tooltip.add(
            Component.literal(
                criarBarra(nivelLuck, 10)
                + "  " + formatarNivel(nivelLuck)
            ).withStyle(ChatFormatting.DARK_GREEN)
        );

        tooltip.add(
            Component.literal(
                "✧ Critical Chance     +" + formatar(bonusCritChance) + "%"
            ).withStyle(ChatFormatting.LIGHT_PURPLE)
        );

        tooltip.add(
            Component.literal(
                criarBarra(nivelCritChance, 10)
                + "  " + formatarNivel(nivelCritChance)
            ).withStyle(ChatFormatting.DARK_PURPLE)
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

    private static String criarBarra(
        int nivel,
        int maximo
    ) {

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

    private static int calcularNivel(
        double valor,
        double[] requisitos
    ) {

        int nivel = 0;

        for (double requisito : requisitos) {

            if (valor >= requisito) {
                nivel++;
            } else {
                break;
            }
        }

        return Math.min(
            10,
            nivel
        );
    }

    private static double calcularBonus(
        int nivel,
        double[] valores
    ) {

        if (nivel <= 0)
            return 0;

        return valores[nivel - 1];
    }

    private static int calcularNivelGeral(
        int dano,
        int attack,
        int speed,
        int armor,
        int lifesteal,
        int luck,
        int critChance
    ) {

        return Math.min(
            10,
            (
                dano
                + attack
                + speed
                + armor
                + lifesteal
                + luck
                + critChance
            ) / 7
        );
    }

    private static String formatarNivel(
        int nivel
    ) {

        return String.format(
            Locale.US,
            "%02d/10",
            nivel
        );
    }

    private static String formatar(
        double valor
    ) {

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

    private static String formatarInteiro(
        double valor
    ) {

        return String.format(
            Locale.US,
            "%,d",
            (int) valor
        );
    }

    private static String formatarDistancia(
        double blocos
    ) {

        double km = blocos / 1000.0;

        return String.format(
            Locale.US,
            "%.1f km",
            km
        );
    }
}