package net.toilgoat.ultvanillaexp.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.entity.Entities;

public class BiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_RUBY_ORE_SMALL = registerKey("add_ruby_ore_small");
    public static final ResourceKey<BiomeModifier> ADD_RUBY_ORE_MID = registerKey("add_ruby_ore_mid");
    public static final ResourceKey<BiomeModifier> ADD_RUBY_ORE_BIG = registerKey("add_ruby_ore_big");
    public static final ResourceKey<BiomeModifier> ADD_PALM_TREE = registerKey("add_palm_tree");
    public static final ResourceKey<BiomeModifier> ADD_DESERT_DUNGEON = registerKey("add_desert_dungeon");
    public static final ResourceKey<BiomeModifier> ADD_PAEONIA = registerKey("add_paeonia");
    public static final ResourceKey<BiomeModifier> ADD_HIBISCUS = registerKey("add_hibiscus");
    public static final ResourceKey<BiomeModifier> SPAWN_DUCK_RIVER = registerKey("spawn_duck_river");
    public static final ResourceKey<BiomeModifier> SPAWN_DUCK_SWAMP = registerKey("spawn_duck_swamp");
    public static final ResourceKey<BiomeModifier> SPAWN_DUCK_PLAINS = registerKey("spawn_duck_plains");
    public static final ResourceKey<BiomeModifier> SPAWN_GRIZZLY_BEAR_FOREST = registerKey("spawn_grizzly_bear_forest");
    public static final ResourceKey<BiomeModifier> SPAWN_GRIZZLY_BEAR_BIRCH_FOREST = registerKey("spawn_grizzly_bear_birch_forest");
    public static final ResourceKey<BiomeModifier> SPAWN_SCORCHED = registerKey("spawn_scorched");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_RUBY_ORE_SMALL, new net.neoforged.neoforge.common.world.BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_MOUNTAIN),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.RUBY_ORE_SMALL_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_RUBY_ORE_MID, new net.neoforged.neoforge.common.world.BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.RUBY_ORE_MID_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_RUBY_ORE_BIG, new net.neoforged.neoforge.common.world.BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.RUBY_ORE_BIG_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(ADD_PALM_TREE, new net.neoforged.neoforge.common.world.BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BEACH)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.PALM_TREE_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_DESERT_DUNGEON, new net.neoforged.neoforge.common.world.BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.DESERT)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.DESERT_DUNGEON_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_STRUCTURES));
        context.register(ADD_PAEONIA, new net.neoforged.neoforge.common.world.BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.PAEONIA_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
        context.register(ADD_HIBISCUS, new net.neoforged.neoforge.common.world.BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(PlacedFeatures.HIBISCUS_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(SPAWN_DUCK_RIVER,
                new net.neoforged.neoforge.common.world.BiomeModifiers.AddSpawnsBiomeModifier(
                        HolderSet.direct(biomes.getOrThrow(Biomes.RIVER)),
                        WeightedList.<MobSpawnSettings.SpawnerData>builder()
                                .add(new MobSpawnSettings.SpawnerData(Entities.DUCK.get(), 2, 8), 12)
                                .build()));

        context.register(SPAWN_DUCK_SWAMP,
                new net.neoforged.neoforge.common.world.BiomeModifiers.AddSpawnsBiomeModifier(
                        HolderSet.direct(biomes.getOrThrow(Biomes.SWAMP), biomes.getOrThrow(Biomes.MANGROVE_SWAMP)),
                        WeightedList.<MobSpawnSettings.SpawnerData>builder()
                                .add(new MobSpawnSettings.SpawnerData(Entities.DUCK.get(), 2, 8), 15)
                                .build()));

        context.register(SPAWN_DUCK_PLAINS,
                new net.neoforged.neoforge.common.world.BiomeModifiers.AddSpawnsBiomeModifier(
                        HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS)),
                        WeightedList.<MobSpawnSettings.SpawnerData>builder()
                                .add(new MobSpawnSettings.SpawnerData(Entities.DUCK.get(), 2, 6), 5)
                                .build()));

        context.register(SPAWN_GRIZZLY_BEAR_FOREST,
                new net.neoforged.neoforge.common.world.BiomeModifiers.AddSpawnsBiomeModifier(
                        HolderSet.direct(biomes.getOrThrow(Biomes.FOREST)),
                        WeightedList.<MobSpawnSettings.SpawnerData>builder()
                                .add(new MobSpawnSettings.SpawnerData(Entities.GRIZZLY_BEAR.get(), 2, 6), 5)
                                .build()));

        context.register(SPAWN_GRIZZLY_BEAR_BIRCH_FOREST,
                new net.neoforged.neoforge.common.world.BiomeModifiers.AddSpawnsBiomeModifier(
                        HolderSet.direct(biomes.getOrThrow(Biomes.BIRCH_FOREST), biomes.getOrThrow(Biomes.OLD_GROWTH_BIRCH_FOREST)),
                        WeightedList.<MobSpawnSettings.SpawnerData>builder()
                                .add(new MobSpawnSettings.SpawnerData(Entities.GRIZZLY_BEAR.get(), 2, 6), 10)
                                .build()));

        context.register(SPAWN_SCORCHED,
                new net.neoforged.neoforge.common.world.BiomeModifiers.AddSpawnsBiomeModifier(
                        HolderSet.direct(biomes.getOrThrow(Biomes.DESERT)),
                        WeightedList.<MobSpawnSettings.SpawnerData>builder()
                                .add(new MobSpawnSettings.SpawnerData(Entities.SCORCHED.get(), 4, 4), 80)
                                .build()
                ));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID, name));
    }
}
