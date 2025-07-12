package net.toilgoat.ultvanillaexp.event;

import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.block.Blocks;
import net.toilgoat.ultvanillaexp.entity.Entities;
import net.toilgoat.ultvanillaexp.entity.client.DuckModel;
import net.toilgoat.ultvanillaexp.entity.client.GrizzlyBearModel;
import net.toilgoat.ultvanillaexp.entity.custom.DesertedTrader;
import net.toilgoat.ultvanillaexp.entity.custom.DuckEntity;
import net.toilgoat.ultvanillaexp.entity.custom.GrizzlyBearEntity;
import net.toilgoat.ultvanillaexp.entity.custom.ScorchedMonster;

import java.util.List;

public class EventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DuckModel.LAYER_LOCATION, DuckModel::createBodyLayer);
        event.registerLayerDefinition(GrizzlyBearModel.LAYER_LOCATION, GrizzlyBearModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(Entities.DUCK.get(), DuckEntity.createAttributes().build());
        event.put(Entities.GRIZZLY_BEAR.get(), GrizzlyBearEntity.createAttributes().build());
        event.put(Entities.SCORCHED.get(), ScorchedMonster.createAttributes().build());
        event.put(Entities.DESERTED_TRADER.get(), DesertedTrader.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(Entities.DUCK.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(Entities.GRIZZLY_BEAR.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(Entities.SCORCHED.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ScorchedMonster::checkScorchedSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }
}
