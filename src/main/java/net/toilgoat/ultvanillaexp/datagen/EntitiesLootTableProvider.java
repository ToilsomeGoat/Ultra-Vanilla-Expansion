package net.toilgoat.ultvanillaexp.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.functions.SmeltItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithEnchantedBonusCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.toilgoat.ultvanillaexp.entity.Entities;
import net.toilgoat.ultvanillaexp.item.potion.Potion;

import java.util.stream.Stream;

public class EntitiesLootTableProvider extends EntityLootSubProvider {
    protected EntitiesLootTableProvider(HolderLookup.Provider provider) {
        super(FeatureFlags.DEFAULT_FLAGS, provider);
    }

    @Override
    public void generate() {
        this.add(
                Entities.DUCK.get(),
                LootTable.lootTable().withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(Items.FEATHER)
                                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(net.toilgoat.ultvanillaexp.item.Items.RAW_DUCK.get())
                                                .apply(SmeltItemFunction.smelted().when(this.shouldSmeltLoot()))
                                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));
        this.add(
                Entities.GRIZZLY_BEAR.get(),
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(net.toilgoat.ultvanillaexp.item.Items.BEESWAX.get())
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))
                        .add(LootItem.lootTableItem(net.toilgoat.ultvanillaexp.item.Items.CRYSTALLIZED_HONEY.get())
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.2F, 0.05F)))
                        .add(LootItem.lootTableItem(Items.SWEET_BERRIES)
                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                        .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.1F, 0.05F)))));
        this.add(
                Entities.SCORCHED.get(),
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.ARROW)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))))
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(Items.BONE)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F)))))
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(Items.TIPPED_ARROW)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 1.0F)))
                                        .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))
                                                .setLimit(1))
                                        .apply(SetPotionFunction.setPotion(Potion.HUNGER)))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer()))
        );
        this.add(Entities.DESERTED_TRADER.get(), LootTable.lootTable());
        this.add(Entities.FROSTBITTEN.get(), LootTable.lootTable());
        this.add(Entities.SUNKEN.get(), LootTable.lootTable()
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(
                                        AlternativesEntry.alternatives(
                                                LootItem.lootTableItem(Items.BRAIN_CORAL_FAN)
                                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                                        .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.2F, 0.02F)),
                                                LootItem.lootTableItem(Items.BUBBLE_CORAL_FAN)
                                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                                        .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.2F, 0.02F)),
                                                LootItem.lootTableItem(Items.FIRE_CORAL_FAN)
                                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                                        .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.2F, 0.02F)),
                                                LootItem.lootTableItem(Items.HORN_CORAL_FAN)
                                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                                        .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.2F, 0.02F)),
                                                LootItem.lootTableItem(Items.TUBE_CORAL_FAN)
                                                        .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                                        .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.2F, 0.02F))

                                        )
                                )
                )
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(
                                        LootItem.lootTableItem(Items.COPPER_INGOT)
                                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                                .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries, 0.2F, 0.02F))
                                )
                )
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.BONE)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F, 2.0F)))
                                .apply(EnchantedCountIncreaseFunction.lootingMultiplier(this.registries, UniformGenerator.between(0.0F, 1.0F))))));;
    }
    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return Entities.ENTITY_TYPES.getEntries()
                .stream()
                .map(DeferredHolder::get);
    }
}
