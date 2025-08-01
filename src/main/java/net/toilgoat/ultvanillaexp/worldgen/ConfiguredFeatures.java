package net.toilgoat.ultvanillaexp.worldgen;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.toilgoat.ultvanillaexp.block.Blocks;
import net.toilgoat.ultvanillaexp.structure.Features;
import net.toilgoat.ultvanillaexp.worldgen.tree.PalmFoliagePlacer;
import net.toilgoat.ultvanillaexp.worldgen.tree.TiltTrunkPlacer;

import java.util.List;

public class ConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_SMALL_KEY = registerKey("ruby_ore_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_MID_KEY = registerKey("ruby_ore_mid");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBY_ORE_BIG_KEY = registerKey("ruby_ore_big");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_KEY = registerKey("palm");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_ROSE_KEY = registerKey("blue_rose");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PAEONIA_KEY = registerKey("paeonia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIBISCUS_KEY = registerKey("hibiscus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DESERT_DUNGEON_KEY = registerKey("desert_dungeon");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FROZEN_DUNGEON_KEY = registerKey("frozen_dungeon");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DESERTED_TRADER_KEY = registerKey("deserted_trader");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> rubySmallOres = List.of(
                OreConfiguration.target(stoneReplaceables, Blocks.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, Blocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> rubyMidOres = List.of(
                OreConfiguration.target(stoneReplaceables, Blocks.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, Blocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> rubyBigOres = List.of(
                OreConfiguration.target(stoneReplaceables, Blocks.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, Blocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));

        register(context, RUBY_ORE_SMALL_KEY, Feature.ORE, new OreConfiguration(rubySmallOres, 3));
        register(context, RUBY_ORE_MID_KEY, Feature.ORE, new OreConfiguration(rubyMidOres, 7));
        register(context, RUBY_ORE_BIG_KEY, Feature.ORE, new OreConfiguration(rubyBigOres, 12));

        register(context, PALM_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(Blocks.PALM_LOG.get()),
                new TiltTrunkPlacer(6, 3, 0),

                BlockStateProvider.simple(Blocks.PALM_LEAVES.get()),
                new PalmFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),

                new TwoLayersFeatureSize(1, 0, 1)).dirt(BlockStateProvider.simple(net.minecraft.world.level.block.Blocks.SAND)).build());

        register(context, DESERT_DUNGEON_KEY, Features.DESERT_DUNGEON.get(), NoneFeatureConfiguration.NONE);

        register(context, FROZEN_DUNGEON_KEY, Features.FROZEN_DUNGEON.get(), NoneFeatureConfiguration.NONE);

        register(context, DESERTED_TRADER_KEY, Features.DESERTED_TRADER.get(), NoneFeatureConfiguration.NONE);

        register(context, HIBISCUS_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.HIBISCUS.get())),
                        List.of(net.minecraft.world.level.block.Blocks.GRASS_BLOCK)
                )
        );
        register(context, PAEONIA_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.PAEONIA.get())),
                        List.of(net.minecraft.world.level.block.Blocks.GRASS_BLOCK)
                )
        );

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}