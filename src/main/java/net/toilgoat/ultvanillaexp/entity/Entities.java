package net.toilgoat.ultvanillaexp.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.entity.custom.DuckEntity;

import java.util.function.Supplier;

public class Entities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, UltVanillaExp.MODID);

    public static ResourceKey<EntityType<?>> DUCK_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("duck"));

    public static final Supplier<EntityType<DuckEntity>> DUCK =
            ENTITY_TYPES.register("duck", () -> EntityType.Builder.of(DuckEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 0.85f).eyeHeight(0.75f).build(DUCK_KEY));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
