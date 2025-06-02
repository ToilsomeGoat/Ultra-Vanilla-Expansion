package net.toilgoat.ultvanillaexp.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.toilgoat.ultvanillaexp.UltVanillaExp;

public class Items {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltVanillaExp.MODID);

    public static final DeferredItem<Item> URANIUM = ITEMS.registerItem("ore_uranium", Item::new, new Item.Properties());

    public static final DeferredItem<Item> GREEN_APPLE = ITEMS.registerItem("green_apple", Item::new, new Item.Properties().food(Food.GREEN_APPLE));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}