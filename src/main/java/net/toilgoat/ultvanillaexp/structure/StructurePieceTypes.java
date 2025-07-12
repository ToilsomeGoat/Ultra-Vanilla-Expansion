package net.toilgoat.ultvanillaexp.structure;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.toilgoat.ultvanillaexp.UltVanillaExp;

public class StructurePieceTypes {
    public static final DeferredRegister<StructurePieceType> STRUCTURE_PIECE_TYPES =
            DeferredRegister.create(Registries.STRUCTURE_PIECE, UltVanillaExp.MODID);

    public static void register(net.neoforged.bus.api.IEventBus eventBus) {
        STRUCTURE_PIECE_TYPES.register(eventBus);
    }
}
