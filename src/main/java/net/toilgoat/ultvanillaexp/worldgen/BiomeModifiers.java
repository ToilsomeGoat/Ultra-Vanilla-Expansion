package net.toilgoat.ultvanillaexp.worldgen;

import net.minecraft.core.HolderSet;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.toilgoat.ultvanillaexp.entity.Entities;

import java.util.List;

public class BiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_RUBY_ORE_SMALL = registerKey("add_ruby_ore_small");
    public static final ResourceKey<BiomeModifier> ADD_RUBY_ORE_MID = registerKey("add_ruby_ore_mid");
    public static final ResourceKey<BiomeModifier> ADD_RUBY_ORE_BIG = registerKey("add_ruby_ore_big");
    public static final ResourceKey<BiomeModifier> ADD_PALM_TREE = registerKey("add_palm_tree");
    public static final ResourceKey<BiomeModifier> SPAWN_DUCK_RIVER = registerKey("spawn_duck_river");
    public static final ResourceKey<BiomeModifier> SPAWN_DUCK_SWAMP = registerKey("spawn_duck_swamp");
    public static final ResourceKey<BiomeModifier> SPAWN_DUCK_PLAINS = registerKey("spawn_duck_plains");
    public static final ResourceKey<BiomeModifier> SPAWN_GRIZZLY_BEAR_FOREST = registerKey("spawn_grizzly_bear_forest");
    public static final ResourceKey<BiomeModifier> SPAWN_GRIZZLY_BEAR_BIRCH_FOREST = registerKey("spawn_grizzly_bear_birch_forest");

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
        context.register(SPAWN_DUCK_RIVER, new net.neoforged.neoforge.common.world.BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.RIVER)),
                List.of(new MobSpawnSettings.SpawnerData(Entities.DUCK.get(), 12, 2, 8))));
        context.register(SPAWN_DUCK_SWAMP, new net.neoforged.neoforge.common.world.BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SWAMP), biomes.getOrThrow((Biomes.MANGROVE_SWAMP))),
                List.of(new MobSpawnSettings.SpawnerData(Entities.DUCK.get(), 18, 2, 8))));
        context.register(SPAWN_DUCK_PLAINS, new net.neoforged.neoforge.common.world.BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS)),
                List.of(new MobSpawnSettings.SpawnerData(Entities.DUCK.get(), 5, 2, 6))));
        context.register(SPAWN_GRIZZLY_BEAR_FOREST, new net.neoforged.neoforge.common.world.BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST)),
                List.of(new MobSpawnSettings.SpawnerData(Entities.GRIZZLY_BEAR.get(), 5, 2, 5))));
        context.register(SPAWN_GRIZZLY_BEAR_BIRCH_FOREST, new net.neoforged.neoforge.common.world.BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BIRCH_FOREST), biomes.getOrThrow(Biomes.OLD_GROWTH_BIRCH_FOREST)),
                List.of(new MobSpawnSettings.SpawnerData(Entities.GRIZZLY_BEAR.get(), 10, 2, 5))));
    }


    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID, name));
    }
}