package net.toilgoat.ultvanillaexp.worldgen.tree;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.toilgoat.ultvanillaexp.UltVanillaExp;


public class PlacerTypes {

    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPES =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, UltVanillaExp.MODID);

    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, UltVanillaExp.MODID);

    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<PalmFoliagePlacer>> PALM_FOLIAGE_PLACER =
            FOLIAGE_PLACER_TYPES.register("palm_foliage_placer", () -> new FoliagePlacerType<>(PalmFoliagePlacer.CODEC));

    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<TiltTrunkPlacer>> TILT_TRUNK_PLACER =
            TRUNK_PLACER_TYPES.register("tilt_trunk_placer", () -> new TrunkPlacerType<>(TiltTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACER_TYPES.register(eventBus);
        TRUNK_PLACER_TYPES.register(eventBus);
    }
}