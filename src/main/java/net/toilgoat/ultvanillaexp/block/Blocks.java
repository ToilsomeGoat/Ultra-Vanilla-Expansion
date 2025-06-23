package net.toilgoat.ultvanillaexp.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.common.Tags;
import net.toilgoat.ultvanillaexp.block.custom.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.item.Items;
import net.toilgoat.ultvanillaexp.util.WoodTypes;
import net.toilgoat.ultvanillaexp.worldgen.tree.TreeGrowers;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class Blocks {
    public static final DeferredRegister.Blocks BLOCKS  =
            DeferredRegister.createBlocks(UltVanillaExp.MODID);

    private static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return (p_50763_) -> (Boolean)p_50763_.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }

    public static final DeferredBlock<Block> POLISHED_DRIPSTONE = registerBlock("polished_dripstone",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_dripstone")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<Block> POLISHED_CALCITE = registerBlock("polished_calcite",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_calcite")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE)));


    public static final DeferredBlock<Block> POLISHED_ANDESITE_BRICKS = registerBlock("polished_andesite_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_andesite_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> POLISHED_CALCITE_BRICKS = registerBlock("polished_calcite_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_calcite_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE)));

    public static final DeferredBlock<Block> POLISHED_DIORITE_BRICKS = registerBlock("polished_diorite_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_diorite_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> POLISHED_DRIPSTONE_BRICKS = registerBlock("polished_dripstone_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_dripstone_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<Block> POLISHED_GRANITE_BRICKS = registerBlock("polished_granite_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_granite_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> CRACKED_POLISHED_ANDESITE_BRICKS = registerBlock("cracked_polished_andesite_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:cracked_polished_andesite_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> CRACKED_POLISHED_CALCITE_BRICKS = registerBlock("cracked_polished_calcite_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:cracked_polished_calcite_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE)));

    public static final DeferredBlock<Block> CRACKED_POLISHED_DIORITE_BRICKS = registerBlock("cracked_polished_diorite_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:cracked_polished_diroite_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> CRACKED_POLISHED_DRIPSTONE_BRICKS = registerBlock("cracked_polished_dripstone_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:cracked_polished_dripstone_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<Block> CRACKED_POLISHED_GRANITE_BRICKS = registerBlock("cracked_polished_granite_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:cracked_polished_granite_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> CHISELED_POLISHED_ANDESITE_BRICKS = registerBlock("chiseled_polished_andesite_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:chiseled_polished_andesite_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> CHISELED_POLISHED_CALCITE_BRICKS = registerBlock("chiseled_polished_calcite_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:chiseled_polished_calcite_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE)));

    public static final DeferredBlock<Block> CHISELED_POLISHED_DIORITE_BRICKS = registerBlock("chiseled_polished_diorite_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:chiseled_polished_diorite_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> CHISELED_POLISHED_DRIPSTONE_BRICKS = registerBlock("chiseled_polished_dripstone_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:chiseled_polished_dripstone_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<Block> CHISELED_POLISHED_GRANITE_BRICKS = registerBlock("chiseled_polished_granite_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:chiseled_polished_granite_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> MOSSY_DEEPSLATE_BRICKS = registerBlock("mossy_deepslate_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:mossy_deepslate_bricks")))
                    .strength(3.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DEEPSLATE_BRICKS)));

    public static final DeferredBlock<Block> MOSSY_TUFF_BRICKS = registerBlock("mossy_tuff_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:mossy_tuff_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.TUFF_BRICKS)));

    public static final DeferredBlock<Block> MOSSY_POLISHED_ANDESITE_BRICKS = registerBlock("mossy_polished_andesite_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:mossy_polished_andesite_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> MOSSY_POLISHED_CALCITE_BRICKS = registerBlock("mossy_polished_calcite_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:mossy_polished_calcite_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE)));

    public static final DeferredBlock<Block> MOSSY_POLISHED_DIORITE_BRICKS = registerBlock("mossy_polished_diorite_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:mossy_polished_diroite_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> MOSSY_POLISHED_DRIPSTONE_BRICKS = registerBlock("mossy_polished_dripstone_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:mossy_polished_dripstone_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<Block> MOSSY_POLISHED_GRANITE_BRICKS = registerBlock("mossy_polished_granite_bricks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:mossy_polished_granite_bricks")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    //Stairs
    public static final DeferredBlock<StairBlock> CALCITE_STAIRS = registerBlock("calcite_stairs",
            () -> new StairBlock(net.minecraft.world.level.block.Blocks.CALCITE.defaultBlockState(),
                    BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:calcite_stairs")))
                            .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE)));

    public static final DeferredBlock<StairBlock> DRIPSTONE_STAIRS = registerBlock("dripstone_stairs",
            () -> new StairBlock(net.minecraft.world.level.block.Blocks.DRIPSTONE_BLOCK.defaultBlockState(),
                    BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:dripstone_stairs")))
                            .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<StairBlock> POLISHED_CALCITE_STAIRS = registerBlock("polished_calcite_stairs",
            () -> new StairBlock(Blocks.POLISHED_CALCITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_calcite_stairs")))
                            .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE)));

    public static final DeferredBlock<StairBlock> POLISHED_DRIPSTONE_STAIRS = registerBlock("polished_dripstone_stairs",
            () -> new StairBlock(Blocks.POLISHED_DRIPSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_dripstone_stairs")))
                            .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<StairBlock> POLISHED_ANDESITE_BRICKS_STAIRS = registerBlock("polished_andesite_bricks_stairs",
            () -> new StairBlock(Blocks.POLISHED_ANDESITE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_andesite_bricks_stairs")))
                            .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<StairBlock> POLISHED_CALCITE_BRICKS_STAIRS = registerBlock("polished_calcite_bricks_stairs",
            () -> new StairBlock(Blocks.POLISHED_CALCITE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_calcite_bricks_stairs")))
                            .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<StairBlock> POLISHED_DIORITE_BRICKS_STAIRS = registerBlock("polished_diorite_bricks_stairs",
            () -> new StairBlock(Blocks.POLISHED_DIORITE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_diorite_bricks_stairs")))
                            .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<StairBlock> POLISHED_DRIPSTONE_BRICKS_STAIRS = registerBlock("polished_dripstone_bricks_stairs",
            () -> new StairBlock(Blocks.POLISHED_DRIPSTONE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_dripstone_bricks_stairs")))
                            .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<StairBlock> POLISHED_GRANITE_BRICKS_STAIRS = registerBlock("polished_granite_bricks_stairs",
            () -> new StairBlock(Blocks.POLISHED_GRANITE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_granite_bricks_stairs")))
                            .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    //Slab
    public static final DeferredBlock<SlabBlock> CALCITE_SLAB = registerBlock("calcite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:calcite_slab")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE)));


    public static final DeferredBlock<SlabBlock> DRIPSTONE_SLAB = registerBlock("dripstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:dripstone_slab")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<SlabBlock> POLISHED_CALCITE_SLAB = registerBlock("polished_calcite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_calcite_slab")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE)));

    public static final DeferredBlock<SlabBlock> POLISHED_DRIPSTONE_SLAB = registerBlock("polished_dripstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_dripstone_slab")))
                            .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<SlabBlock> POLISHED_ANDESITE_BRICKS_SLAB = registerBlock("polished_andesite_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_andesite_bricks_slab")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<SlabBlock> POLISHED_CALCITE_BRICKS_SLAB = registerBlock("polished_calcite_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_calcite_bricks_slab")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE)));

    public static final DeferredBlock<SlabBlock> POLISHED_DIORITE_BRICKS_SLAB = registerBlock("polished_diorite_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_diorite_bricks_slab")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<SlabBlock> POLISHED_DRIPSTONE_BRICKS_SLAB = registerBlock("polished_dripstone_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_dripstone_bricks_slab")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<SlabBlock> POLISHED_GRANITE_BRICKS_SLAB = registerBlock("polished_granite_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_granite_bricks_slab")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    //Wall
    public static final DeferredBlock<WallBlock> CALCITE_WALL = registerBlock("calcite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:calcite_wall")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE)));

    public static final DeferredBlock<WallBlock> DRIPSTONE_WALL = registerBlock("dripstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:dripstone_wall")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<WallBlock> POLISHED_ANDESITE_WALL = registerBlock("polished_andesite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_andesite_wall")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<WallBlock> POLISHED_CALCITE_WALL = registerBlock("polished_calcite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_calcite_wall")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE)));

    public static final DeferredBlock<WallBlock> POLISHED_DIORITE_WALL = registerBlock("polished_diorite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_diorite_wall")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<WallBlock> POLISHED_DRIPSTONE_WALL = registerBlock("polished_dripstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_dripstone_wall")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<WallBlock> POLISHED_GRANITE_WALL = registerBlock("polished_granite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_granite_wall")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<WallBlock> POLISHED_ANDESITE_BRICKS_WALL = registerBlock("polished_andesite_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_andesite_bricks_wall")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<WallBlock> POLISHED_CALCITE_BRICKS_WALL = registerBlock("polished_calcite_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_calcite_bricks_wall")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE)));

    public static final DeferredBlock<WallBlock> POLISHED_DIORITE_BRICKS_WALL = registerBlock("polished_diorite_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_diorite_bricks_wall")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<WallBlock> POLISHED_DRIPSTONE_BRICKS_WALL = registerBlock("polished_dripstone_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_dripstone_bricks_wall")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<WallBlock> POLISHED_GRANITE_BRICKS_WALL = registerBlock("polished_granite_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_granite_bricks_wall")))
                    .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));


    public static final DeferredBlock<Block> WAX_BLOCK = registerBlock("wax_block",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:wax_block")))
                    .strength(0.6f, 0.6f).instrument(NoteBlockInstrument.FLUTE).sound(SoundType.CORAL_BLOCK)));

    public static final DeferredBlock<Block> HIEROGLYPH_BASKET = registerBlock("hieroglyph_basket",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:hieroglyph_basket")))
                    .mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)));

    public static final DeferredBlock<Block> HIEROGLYPH_FOOT = registerBlock("hieroglyph_foot",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:hieroglyph_foot")))
                    .mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)));

    public static final DeferredBlock<Block> HIEROGLYPH_REEDS = registerBlock("hieroglyph_reeds",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:hieroglyph_reeds")))
                    .mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)));

    public static final DeferredBlock<Block> HIEROGLYPH_SNAKE = registerBlock("hieroglyph_snake",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:hieroglyph_snake")))
                    .mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)));

    public static final DeferredBlock<Block> HIEROGLYPH_VULTURE = registerBlock("hieroglyph_vulture",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:hieroglyph_vulture")))
                    .mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8F)));
    //Crop
    public static final DeferredBlock<Block> ONION_CROP = BLOCKS.register("onion_crop",
            () -> new OnionCrop(BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.BEETROOTS)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:onion_crop")))));

    public static final DeferredBlock<Block> BARLEY_CROP = BLOCKS.register("barley_crop",
            () -> new BarleyCrop(BlockBehaviour.Properties.ofFullCopy(net.minecraft.world.level.block.Blocks.BEETROOTS)
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:barley_crop")))));

    //Ore
    public static final DeferredBlock<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,5), BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:ruby_ore")))
                    .strength(3f,3f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,5), BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:deepslate_ruby_ore")))
                    .strength(4.5f,4.5f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DEEPSLATE)));



    public static final DeferredBlock<Block> FROSTER = registerBlock("froster",
            () -> new FrosterBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:froster")))
                    .strength(3f, 3f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).lightLevel(litBlockEmission(13))));

    public static final DeferredBlock<Block> PALM_LEAVES = registerBlock("palm_leaves",
            () -> new PalmLeavesBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:palm_leaves")))
                    .mapColor(MapColor.PLANT).strength(0.2F).randomTicks().sound(SoundType.GRASS)
                    .noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> PALM_LOG = registerBlock("palm_log",
            () -> new FlammableRotatedPillarBlock(
                    BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:palm_log")))
                            .instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> PALM_WOOD = registerBlock("palm_wood",
            () -> new FlammableRotatedPillarBlock(
                    BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:palm_wood")))
                            .instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> STRIPPED_PALM_LOG = registerBlock("stripped_palm_log",
            () -> new FlammableRotatedPillarBlock(
                    BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:stripped_palm_log")))
                            .instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final DeferredBlock<Block> STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood",
            () -> new FlammableRotatedPillarBlock(
                    BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:stripped_palm_wood")))
                            .instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));

    public static final DeferredBlock<Block> PALM_PLANKS = registerBlock("palm_planks",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:palm_planks")))
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<StairBlock> PALM_STAIRS = registerBlock("palm_stairs",
            () -> new StairBlock(Blocks.PALM_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:palm_stairs")))
                            .strength(2f)) {
        @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 20;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }
});
    public static final DeferredBlock<SlabBlock> PALM_SLAB = registerBlock("palm_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:palm_slab")))
                    .strength(2f)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<FenceBlock> PALM_FENCE = registerBlock("palm_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:palm_fence")))
                    .strength(2f).requiresCorrectToolForDrops()) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<FenceGateBlock> PALM_FENCE_GATE = registerBlock("palm_fence_gate",
            () -> new FenceGateBlock(WoodTypes.PALM, BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:palm_fence_gate")))
                    .strength(2f)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<DoorBlock> PALM_DOOR = registerBlock("palm_door",
            () -> new DoorBlock(BlockSetType.ACACIA, BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:palm_door"))).strength(2f).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> PALM_TRAPDOOR = registerBlock("palm_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.ACACIA, BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:palm_trapdoor"))).strength(2f).noOcclusion()));

    public static final DeferredBlock<PressurePlateBlock> PALM_PRESSURE_PLATE = registerBlock("palm_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.ACACIA, BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:palm_pressure_plate")))
                    .strength(2f)));
    public static final DeferredBlock<ButtonBlock> PALM_BUTTON = registerBlock("palm_button",
            () -> new ButtonBlock(BlockSetType.ACACIA, 20, BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:palm_button")))
                    .strength(2f).noCollission()));

    public static final DeferredBlock<Block> PALM_SIGN = BLOCKS.register("palm_sign",
            () -> new StandingSignBlocks(WoodTypes.PALM, BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:palm_sign")))
                    .mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final DeferredBlock<Block> PALM_WALL_SIGN = BLOCKS.register("palm_wall_sign",
            () -> new WallSignBlocks(WoodTypes.PALM, BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:palm_wall_sign")))
                    .mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));

    public static final DeferredBlock<Block> PALM_HANGING_SIGN = BLOCKS.register("palm_hanging_sign",
            () -> new HangingSignBlocks(WoodTypes.PALM, BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:palm_hanging_sign")))
                    .mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));
    public static final DeferredBlock<Block> PALM_WALL_HANGING_SIGN = BLOCKS.register("palm_wall_hanging_sign",
            () -> new WallHangingSignBlocks(WoodTypes.PALM, BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:palm_wall_hanging_sign")))
                    .mapColor(MapColor.WOOD).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava()));

    public static final DeferredBlock<Block> PALM_SAPLING = registerBlock("palm_sapling",
            () -> new SaplingBlocks(TreeGrowers.PALM,
                    BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:palm_sapling")))
                            .mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak()
                            .sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY), () -> net.minecraft.world.level.block.Blocks.SAND));

    public static final DeferredBlock<FlowerPotBlock> POTTED_PALM_SAPLING = BLOCKS.register("potted_palm_sapling", () ->
            new FlowerPotBlock(
                    () -> (FlowerPotBlock) net.minecraft.world.level.block.Blocks.FLOWER_POT, Blocks.PALM_SAPLING, BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:potted_palm_sapling")))
                    .instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<FlowerBlock> BLUE_ROSE = registerBlock("blue_rose",
            () -> new FlowerBlock(MobEffects.SPEED, 7.0F, BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:blue_rose")))
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));


    public static final DeferredBlock<FlowerPotBlock> POTTED_BLUE_ROSE = BLOCKS.register("potted_blue_rose", () ->
            new FlowerPotBlock(
                    () -> (FlowerPotBlock) net.minecraft.world.level.block.Blocks.FLOWER_POT, Blocks.BLUE_ROSE, BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:potted_blue_rose")))
                    .instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<FlowerBlock> PAEONIA = registerBlock("paeonia",
            () -> new FlowerBlock(MobEffects.SLOWNESS, 5.0F, BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:paeonia")))
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));


    public static final DeferredBlock<FlowerPotBlock> POTTED_PAEONIA = BLOCKS.register("potted_paeonia", () ->
            new FlowerPotBlock(
                    () -> (FlowerPotBlock) net.minecraft.world.level.block.Blocks.FLOWER_POT, Blocks.PAEONIA, BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:potted_paeonia")))
                    .instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));

    public static final DeferredBlock<FlowerBlock> HIBISCUS = registerBlock("hibiscus",
            () -> new FlowerBlock(MobEffects.SLOW_FALLING, 5.0F, BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:hibiscus")))
                    .mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY)));


    public static final DeferredBlock<FlowerPotBlock> POTTED_HIBISCUS = BLOCKS.register("potted_hibiscus", () ->
            new FlowerPotBlock(
                    () -> (FlowerPotBlock) net.minecraft.world.level.block.Blocks.FLOWER_POT, Blocks.HIBISCUS, BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:potted_hibiscus")))
                    .instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        Items.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(ResourceKey.create(
                Registries.ITEM, ResourceLocation.fromNamespaceAndPath(UltVanillaExp.MODID,name)))));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
