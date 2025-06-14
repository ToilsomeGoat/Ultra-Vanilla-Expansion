package net.toilgoat.ultvanillaexp.loot;

import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class LootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, UltVanillaExp.MODID);

    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> ADD_ITEM_STACK =
            LOOT_MODIFIER_SERIALIZERS.register("add_table_loot", () -> AddItemStackModifier.CODEC);

    public static void register(IEventBus eventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }
}