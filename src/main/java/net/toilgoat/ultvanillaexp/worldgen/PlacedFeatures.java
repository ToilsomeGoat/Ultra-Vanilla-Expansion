package net.toilgoat.ultvanillaexp.worldgen;

import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.toilgoat.ultvanillaexp.block.Blocks;

import java.util.List;

public class PlacedFeatures {

    public static final ResourceKey<PlacedFeature> RUBY_ORE_SMALL_PLACED_KEY = registerKey("ruby_ore_small_placed");
    public static final ResourceKey<PlacedFeature> RUBY_ORE_MID_PLACED_KEY = registerKey("ruby_ore_mid_placed");
    public static final ResourceKey<PlacedFeature> RUBY_ORE_BIG_PLACED_KEY = registerKey("ruby_ore_big_placed");
    public static final ResourceKey<PlacedFeature> PALM_TREE_PLACED_KEY = registerKey("palm_tree_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, RUBY_ORE_SMALL_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.RUBY_ORE_SMALL_KEY),
                OrePlacements.commonOrePlacement(60, HeightRangePlacement.uniform(VerticalAnchor.absolute(70), VerticalAnchor.absolute(256))));
        register(context, RUBY_ORE_MID_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.RUBY_ORE_MID_KEY),
                OrePlacements.commonOrePlacement(20, HeightRangePlacement.uniform(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(40))));
        register(context, RUBY_ORE_BIG_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.RUBY_ORE_BIG_KEY),
                OrePlacements.commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.absolute(-65), VerticalAnchor.absolute(-40))));

        register(context, PALM_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ConfiguredFeatures.PALM_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 1),
                        Blocks.PALM_SAPLING.get()));

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}