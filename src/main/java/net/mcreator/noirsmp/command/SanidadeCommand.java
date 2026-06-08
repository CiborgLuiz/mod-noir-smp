package net.mcreator.noirsmp.command;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.Commands;
import com.mojang.brigadier.arguments.DoubleArgumentType;

import net.mcreator.noirsmp.procedures.SanidadeCommandProcedure;

@Mod.EventBusSubscriber
public class SanidadeCommand {
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("sanidade")
            .requires(s -> s.hasPermission(2)) 
            .then(Commands.argument("valor", DoubleArgumentType.doubleArg(0, 100))
                .executes(arguments -> {
                    Entity entity = arguments.getSource().getEntity();
                    
                    double valor = DoubleArgumentType.getDouble(arguments, "valor");
                    
                    SanidadeCommandProcedure.execute(entity, valor);
                    return 1;
                })
            )
        );
    }
}