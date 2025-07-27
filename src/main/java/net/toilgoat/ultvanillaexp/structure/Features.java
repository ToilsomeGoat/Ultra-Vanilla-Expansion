package net.toilgoat.ultvanillaexp.structure;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.toilgoat.ultvanillaexp.UltVanillaExp;

public class Features {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, UltVanillaExp.MODID);

    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> DESERT_DUNGEON =
            FEATURES.register("desert_dungeon",
            () -> new DesertDungeonFeature(NoneFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> FROZEN_DUNGEON =
            FEATURES.register("frozen_dungeon",
                    () -> new FrozenDungeonFeature(NoneFeatureConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> DESERTED_TRADER =
            FEATURES.register("deserted_trader",
                    () -> new DesertedTraderFeature(NoneFeatureConfiguration.CODEC));

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}
