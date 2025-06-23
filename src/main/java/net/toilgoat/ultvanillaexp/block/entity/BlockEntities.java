package net.toilgoat.ultvanillaexp.block.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.block.Blocks;

import java.util.Set;
import java.util.function.Supplier;

public class BlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, UltVanillaExp.MODID);

    public static final Supplier<BlockEntityType<FrosterBlockEntity>> FROSTER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("froster_block_entity", () -> new BlockEntityType<>(
                    FrosterBlockEntity::new, Blocks.FROSTER.get()));

    public static final Supplier<BlockEntityType<SignBlockEntities>> SIGNS =
            BLOCK_ENTITIES.register("signs", () -> new BlockEntityType<>(
                    SignBlockEntities::new,
                    Set.of(
                            Blocks.PALM_SIGN.get(),
                            Blocks.PALM_WALL_SIGN.get()
                    )));

    public static final Supplier<BlockEntityType<HangingSignBlockEntities>> HANGING_SIGNS =
            BLOCK_ENTITIES.register("hanging_signs", () -> new BlockEntityType<>(
                    HangingSignBlockEntities::new,
                    Set.of(
                            Blocks.PALM_HANGING_SIGN.get(),
                            Blocks.PALM_WALL_HANGING_SIGN.get()
                    )));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
