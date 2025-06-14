package net.toilgoat.ultvanillaexp.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.block.Blocks;
import net.toilgoat.ultvanillaexp.block.custom.FrosterBlock;
import net.toilgoat.ultvanillaexp.entity.Entities;
import net.toilgoat.ultvanillaexp.item.food.Consumables;
import net.toilgoat.ultvanillaexp.item.food.Food;

public class Items {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltVanillaExp.MODID);

    public static final DeferredItem<Item> URANIUM = ITEMS.registerItem("uranium", Item::new, new Item.Properties());

    public static final DeferredItem<Item> GREEN_APPLE = ITEMS.registerItem("green_apple", Item::new, new Item.Properties().food(Food.GREEN_APPLE));

    public static final DeferredItem<Item> BEESWAX = ITEMS.registerItem("beeswax", Item::new, new Item.Properties());

    public static final DeferredItem<Item> CRYSTALLIZED_HONEY = ITEMS.registerItem("crystallized_honey", Item::new, new Item.Properties().food(Food.CRYSTALLIZED_HONEY, Consumables.CRYSTALLIZED_HONEY));

    public static final DeferredItem<Item> ONION = ITEMS.registerItem("onion",
            (properties) -> new BlockItem(Blocks.ONION_CROP.get(), properties.food(Food.ONION)));

    public static final DeferredItem<Item> BAKED_ONION = ITEMS.registerItem("baked_onion", Item::new, new Item.Properties().food(Food.BAKED_ONION));

    public static final DeferredItem<Item> BARLEY = ITEMS.registerItem("barley", Item::new, new Item.Properties());

    public static final DeferredItem<Item> BARLEY_SEEDS = ITEMS.registerItem("barley_seeds",
            (properties) -> new BlockItem(Blocks.BARLEY_CROP.get(), properties));

    public static final DeferredItem<Item> BARLEY_STEW = ITEMS.registerItem("barley_stew", Item::new, new Item.Properties().food(Food.BARLEY_STEW).stacksTo(1).usingConvertsTo(net.minecraft.world.item.Items.BOWL));

    public static final DeferredItem<Item> RUBY = ITEMS.registerItem("ruby", Item::new, new Item.Properties());

    public static final DeferredItem<Item> DUCK_SPAWN_EGG = ITEMS.registerItem("duck_spawn_egg",
            (properties) -> new SpawnEggItem(Entities.DUCK.get(), properties));

    public static final DeferredItem<Item> RAW_DUCK = ITEMS.registerItem("raw_duck", Item::new, new Item.Properties().food(Food.RAW_DUCK, Consumables.RAW_DUCK));

    public static final DeferredItem<Item> ROASTED_DUCK = ITEMS.registerItem("roasted_duck", Item::new, new Item.Properties().food(Food.ROASTED_DUCK));






    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}