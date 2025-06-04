package net.toilgoat.ultvanillaexp.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.toilgoat.ultvanillaexp.UltVanillaExp;

public class Items {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltVanillaExp.MODID);

    public static final DeferredItem<Item> URANIUM = ITEMS.registerItem("uranium", Item::new, new Item.Properties());

    public static final DeferredItem<Item> GREEN_APPLE = ITEMS.registerItem("green_apple", Item::new, new Item.Properties().food(Food.GREEN_APPLE));

    public static final DeferredItem<Item> BEESWAX = ITEMS.registerItem("beeswax", Item::new, new Item.Properties());

    public static final DeferredItem<Item> CRYSTALLIZED_HONEY = ITEMS.registerItem("crystallized_honey", Item::new, new Item.Properties().food(Food.CRYSTALLIZED_HONEY));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}