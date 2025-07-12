package net.toilgoat.ultvanillaexp.structure.processors;


import com.mojang.serialization.Codec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.toilgoat.ultvanillaexp.UltVanillaExp;

import java.util.function.Supplier;

public class Processors {
    public static final DeferredRegister<StructureProcessorType<?>> PROCESSORS =
            DeferredRegister.create(BuiltInRegistries.STRUCTURE_PROCESSOR, UltVanillaExp.MODID);

    public static final Supplier<StructureProcessorType<DesertedTraderWithCamelsProcessor>> DESERTED_TRADER_CAMELS =
            PROCESSORS.register("spawn_deserted_trader_with_camels", () -> () -> DesertedTraderWithCamelsProcessor.CODEC);

    public static void register(IEventBus eventBus) {
        PROCESSORS.register(eventBus);
    }
}
