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
import net.toilgoat.ultvanillaexp.entity.custom.DesertedTrader;
import net.toilgoat.ultvanillaexp.entity.custom.DuckEntity;
import net.toilgoat.ultvanillaexp.entity.custom.GrizzlyBearEntity;
import net.toilgoat.ultvanillaexp.entity.custom.ScorchedMonster;

import java.util.function.Supplier;

public class Entities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, UltVanillaExp.MODID);

    public static ResourceKey<EntityType<?>> DUCK_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("duck"));
    public static ResourceKey<EntityType<?>> GRIZZLY_BEAR_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("grizzly_bear"));
    public static ResourceKey<EntityType<?>> SCORCHED_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("scorched"));
    public static ResourceKey<EntityType<?>> DESERTED_TRADER_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("deserted_trader"));

    public static final Supplier<EntityType<DuckEntity>> DUCK =
            ENTITY_TYPES.register("duck", () -> EntityType.Builder.of(DuckEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 0.85f).eyeHeight(0.75f).build(DUCK_KEY));

    public static final Supplier<EntityType<GrizzlyBearEntity>> GRIZZLY_BEAR =
            ENTITY_TYPES.register("grizzly_bear", () -> EntityType.Builder.of(GrizzlyBearEntity::new, MobCategory.CREATURE)
                    .sized(1.4f, 1.3f).eyeHeight(0.9f).build(GRIZZLY_BEAR_KEY));

    public static final Supplier<EntityType<ScorchedMonster>> SCORCHED =
            ENTITY_TYPES.register("scorched", () -> EntityType.Builder.of(ScorchedMonster::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.99F).eyeHeight(1.74F).ridingOffset(-0.7F).clientTrackingRange(8).build(SCORCHED_KEY));

    public static final Supplier<EntityType<DesertedTrader>> DESERTED_TRADER =
            ENTITY_TYPES.register("deserted_trader", () -> EntityType.Builder.of(DesertedTrader::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.95F).eyeHeight(1.62F).clientTrackingRange(10).build(DESERTED_TRADER_KEY));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
