package net.toilgoat.ultvanillaexp.structure.processors;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.camel.Camel;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.toilgoat.ultvanillaexp.block.Blocks;
import net.toilgoat.ultvanillaexp.entity.Entities;
import net.toilgoat.ultvanillaexp.entity.custom.DesertedTrader;

import javax.annotation.Nullable;

public class DesertedTraderWithCamelsProcessor extends StructureProcessor {
    public static final DesertedTraderWithCamelsProcessor INSTANCE = new DesertedTraderWithCamelsProcessor();
    public static final MapCodec<DesertedTraderWithCamelsProcessor> CODEC = MapCodec.unit(() -> INSTANCE);

    @Override
    protected StructureProcessorType<?> getType() {
        return Processors.DESERTED_TRADER_CAMELS.get();
    }

    @Override
    @Nullable
    public StructureTemplate.StructureBlockInfo processBlock(
            LevelReader level,
            BlockPos structureOrigin,
            BlockPos blockPos,
            StructureTemplate.StructureBlockInfo originalBlockInfo,
            StructureTemplate.StructureBlockInfo currentBlockInfo,
            StructurePlaceSettings settings
    ) {
        if (currentBlockInfo.state().getBlock() == net.toilgoat.ultvanillaexp.block.Blocks.PALM_LOG.get()) {
            BlockPos pos = currentBlockInfo.pos();

            // Replace the palm log with your marker block
            return new StructureTemplate.StructureBlockInfo(
                    pos,
                    Blocks.PALM_LOG.get().defaultBlockState(),
                    null
            );
        }

        return currentBlockInfo;
    }
}
