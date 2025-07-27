package net.toilgoat.ultvanillaexp.structure;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.phys.Vec3;
import net.toilgoat.ultvanillaexp.entity.Entities;
import net.toilgoat.ultvanillaexp.entity.custom.DesertedTrader;

public class DesertedTraderFeature extends Feature<NoneFeatureConfiguration> {

    public DesertedTraderFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        if (!(level.getLevel() instanceof net.minecraft.server.level.ServerLevel serverLevel)) {
            return false;
        }

        int groundY = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, origin.getX(), origin.getZ());
        BlockPos spawnPos = new BlockPos(origin.getX(), groundY, origin.getZ());

        // Spawn the trader using spawn helper (handles NBT, position, syncing, etc.)
        DesertedTrader trader = Entities.DESERTED_TRADER.get().spawn(
                serverLevel,
                null,
                null,
                spawnPos,
                EntitySpawnReason.STRUCTURE,
                true,  // align to surface
                false  // not from spawn egg
        );

        if (trader == null) return false;

        trader.setPersistenceRequired();

        // Spawn and leash camels
        for (int dx : new int[]{1, -1}) {
            BlockPos camelPos = spawnPos.offset(dx, 0, 1);

            Camel camel = EntityType.CAMEL.spawn(
                    serverLevel,
                    null,
                    null,
                    camelPos,
                    EntitySpawnReason.STRUCTURE,
                    true,
                    false
            );

            if (camel != null) {
                camel.setPersistenceRequired();
                camel.setLeashedTo(trader, true);
            }
        }

        return true;
    }
}
