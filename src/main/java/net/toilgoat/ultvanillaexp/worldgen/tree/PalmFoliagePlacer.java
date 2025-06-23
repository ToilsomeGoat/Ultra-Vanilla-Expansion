/*
 * This file includes portions of code originally developed by satisfy (2022–2024)
 * under the MIT License, available at the original repository.
 *
 * Copyright (c) 2022–2024 satisfy
 * Modified and redistributed under the terms of the MIT License.
 */
//Credits and massive thanks to satisfy, creator of [Let's Do] Beachparty with the lines of code under file name "PalmFoliagePlacer" for the reference in the following code below
package net.toilgoat.ultvanillaexp.worldgen.tree;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import org.jetbrains.annotations.NotNull;

public class PalmFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<PalmFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(instance ->
            foliagePlacerParts(instance).apply(instance, PalmFoliagePlacer::new)
    );

    public PalmFoliagePlacer(IntProvider pRadius, IntProvider pOffset) {
        super(pRadius, pOffset);
    }

    private static void createQuadrant(Direction direction, BlockPos startingPos, LevelSimulatedReader pLevel, FoliagePlacer.FoliageSetter foliageSetter, RandomSource pRandom, TreeConfiguration pConfig) {
        BlockPos.MutableBlockPos pos = startingPos.mutable();

        pos.move(direction);
        tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig, pos);

        for (int i = 0; i < 2; i++) {
            pos.move(direction);
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig, pos);
            pos.move(Direction.DOWN);
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig, pos);
        }

        pos.set(startingPos);
        pos.move(direction).move(direction.getCounterClockWise());
        tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig, pos);
        pos.move(Direction.DOWN).move(direction.getCounterClockWise());
        tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig, pos);
        pos.move(direction);
        tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig, pos.relative(direction.getClockWise()));
        for (int i = 0; i < 3; i++) {
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig, pos);
            pos.move(Direction.DOWN);
        }
    }

    @Override
    protected @NotNull FoliagePlacerType<?> type() {
        return PlacerTypes.PALM_FOLIAGE_PLACER.value();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter foliageSetter, RandomSource pRandom, TreeConfiguration pConfig, int i, FoliageAttachment pAttachment, int j, int k, int l) {
        BlockPos startingPos = pAttachment.pos();

        tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig, startingPos);

        createQuadrant(Direction.NORTH, startingPos, pLevel, foliageSetter, pRandom, pConfig);
        createQuadrant(Direction.EAST, startingPos, pLevel, foliageSetter, pRandom, pConfig);
        createQuadrant(Direction.SOUTH, startingPos, pLevel, foliageSetter, pRandom, pConfig);
        createQuadrant(Direction.WEST, startingPos, pLevel, foliageSetter, pRandom, pConfig);
    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return false;
    }
    }
