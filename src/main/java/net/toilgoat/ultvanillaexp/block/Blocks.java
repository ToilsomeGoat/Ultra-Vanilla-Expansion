package net.toilgoat.ultvanillaexp.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.*;
import net.toilgoat.ultvanillaexp.block.custom.BarleyCrop;
import net.toilgoat.ultvanillaexp.block.custom.FrosterBlock;
import net.toilgoat.ultvanillaexp.block.custom.OnionCrop;
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

import java.util.function.Supplier;

public class Blocks {
    public static final DeferredRegister.Blocks BLOCKS  =
            DeferredRegister.createBlocks(UltVanillaExp.MODID);

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
                    .strength(3f, 3f).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE)));







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
