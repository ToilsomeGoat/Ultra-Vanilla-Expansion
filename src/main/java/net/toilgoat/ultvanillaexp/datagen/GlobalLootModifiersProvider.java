package net.toilgoat.ultvanillaexp.datagen;

import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.item.Items;
import net.toilgoat.ultvanillaexp.loot.AddItemStackModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;
import java.util.Random;

public class GlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public GlobalLootModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, UltVanillaExp.MODID);
    }

    Random random = new Random();

    @Override
    protected void start() {
        this.add("barley_seeds_to_tall_grass",
                new AddItemStackModifier(new LootItemCondition[] {
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS).build(),
                        LootItemRandomChanceCondition.randomChance(0.2f).build() }, Items.BARLEY_SEEDS.get()));

        this.add("barley_seeds_from_mineshaft",
                new AddItemStackModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/abandoned_mineshaft")).build(),
                        LootItemRandomChanceCondition.randomChance(0.25f).build()}, Items.BARLEY_SEEDS.get()));

        this.add("onion_from_pillager_outpost",
                new AddItemStackModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/pillager_outpost")).build()}, Items.ONION.get()));

        this.add("onion_from_shipwreck_supply",
                new AddItemStackModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("chests/shipwreck_supply")).build(),
                        LootItemRandomChanceCondition.randomChance(0.4f).build()}, Items.ONION.get()));

        this.add("onion_from_zombie",
                new AddItemStackModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/zombie")).build(),
                        LootItemRandomChanceCondition.randomChance(0.4f).build()}, Items.ONION.get()));


    }
}