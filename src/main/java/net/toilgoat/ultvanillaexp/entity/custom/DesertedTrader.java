package net.toilgoat.ultvanillaexp.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.toilgoat.ultvanillaexp.block.Blocks;

public class DesertedTrader extends WanderingTrader {
    public DesertedTrader(EntityType<? extends WanderingTrader> type, Level level) {
        super(type, level);
    }
    public static AttributeSupplier.Builder createAttributes() {
        return WanderingTrader.createMobAttributes();
    }
    @Override
    protected void updateTrades() {
        MerchantOffers offers = this.getOffers();

        this.addOffersFromItemListings(offers, new VillagerTrades.ItemListing[]{
                (entity, randomSource) -> new MerchantOffer(
                        new ItemCost(net.toilgoat.ultvanillaexp.item.Items.RUBY.get(), 4),
                        new ItemStack(Blocks.BLUE_ROSE.get(), 1),
                        10, 10, 0f
                ),
                (entity, randomSource) -> new MerchantOffer(
                        new ItemCost(net.toilgoat.ultvanillaexp.item.Items.RUBY.get(), 2),
                        new ItemStack(Items.DRY_SHORT_GRASS, 1),
                        15, 10, 0f
                ),
                (entity, randomSource) -> new MerchantOffer(
                        new ItemCost(net.toilgoat.ultvanillaexp.item.Items.RUBY.get(), 4),
                        new ItemStack(Items.FIREFLY_BUSH, 1),
                        10, 10, 0f
                ),
                (entity, randomSource) -> new MerchantOffer(
                        new ItemCost(net.toilgoat.ultvanillaexp.item.Items.RUBY.get(), 1),
                        new ItemStack(Items.LEAF_LITTER, 1),
                        32, 10, 0f
                ),
                (entity, randomSource) -> new MerchantOffer(
                        new ItemCost(net.toilgoat.ultvanillaexp.item.Items.RUBY.get(), 3),
                        new ItemStack(Items.PINK_PETALS, 2),
                        20, 10, 0f
                ),
                (entity, randomSource) -> new MerchantOffer(
                        new ItemCost(net.toilgoat.ultvanillaexp.item.Items.RUBY.get(), 3),
                        new ItemStack(Items.WILDFLOWERS, 2),
                        20, 10, 0f
                ),
                (entity, randomSource) -> new MerchantOffer(
                        new ItemCost(net.toilgoat.ultvanillaexp.item.Items.RUBY.get(), 4),
                        new ItemStack(Items.CACTUS_FLOWER, 1),
                        15, 10, 0f
                ),
                (entity, randomSource) -> new MerchantOffer(
                        new ItemCost(net.toilgoat.ultvanillaexp.item.Items.RUBY.get(), 4),
                        new ItemStack(Items.SPORE_BLOSSOM, 1),
                        15, 10, 0f
                ),
                (entity, randomSource) -> new MerchantOffer(
                        new ItemCost(net.toilgoat.ultvanillaexp.item.Items.RUBY.get(), 5),
                        new ItemStack(Blocks.PALM_SAPLING.asItem(), 1),
                        8, 10, 0f
                ),
                (entity, randomSource) -> new MerchantOffer(
                        new ItemCost(net.toilgoat.ultvanillaexp.item.Items.RUBY.get(), 6),
                        new ItemStack(Blocks.HIEROGLYPH_BASKET.get(), 1),
                        10, 10, 0f
                ),
                (entity, randomSource) -> new MerchantOffer(
                        new ItemCost(net.toilgoat.ultvanillaexp.item.Items.RUBY.get(), 6),
                        new ItemStack(Blocks.HIEROGLYPH_FOOT.get(), 1),
                        10, 10, 0f
                ),
                (entity, randomSource) -> new MerchantOffer(
                        new ItemCost(net.toilgoat.ultvanillaexp.item.Items.RUBY.get(), 6),
                        new ItemStack(Blocks.HIEROGLYPH_REEDS.get(), 1),
                        10, 10, 0f
                ),
                (entity, randomSource) -> new MerchantOffer(
                        new ItemCost(net.toilgoat.ultvanillaexp.item.Items.RUBY.get(), 6),
                        new ItemStack(Blocks.HIEROGLYPH_SNAKE.get(), 1),
                        10, 10, 0f
                ),
                (entity, randomSource) -> new MerchantOffer(
                        new ItemCost(net.toilgoat.ultvanillaexp.item.Items.RUBY.get(), 6),
                        new ItemStack(Blocks.HIEROGLYPH_VULTURE.get(), 1),
                        10, 10, 0f
                )
        }, 5);

        // Add rare trades
        this.addOffersFromItemListings(offers, new VillagerTrades.ItemListing[]{
                (entity, randomSource) -> new MerchantOffer(
                        new ItemCost(net.toilgoat.ultvanillaexp.item.Items.RUBY.get(), 32),
                        new ItemStack(Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE, 1),
                        2, 20, 0.5f
                ),
                (entity, randomSource) -> new MerchantOffer(
                        new ItemCost(net.toilgoat.ultvanillaexp.item.Items.RUBY.get(), 25),
                        new ItemStack(Items.DEEPSLATE_EMERALD_ORE, 1),
                        5, 20, 0.5f
                )
        }, 1);
    }
}
