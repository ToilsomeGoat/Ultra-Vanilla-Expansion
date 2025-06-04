package net.toilgoat.ultvanillaexp.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
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
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:mossy_deepslate_andesite_bricks")))
                    .strength(3.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DEEPSLATE_BRICKS)));

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

    public static final DeferredBlock<StairBlock> POLISHED_DRIPSTONE_STAIRS = registerBlock("polished_dripstone_stairs",
            () -> new StairBlock(Blocks.POLISHED_DRIPSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_dripstone_stairs")))
                            .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<SlabBlock> POLISHED_DRIPSTONE_SLAB = registerBlock("polished_dripstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:polished_dripstone_slab")))
                            .strength(1.5f, 6.0f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<Block> WAX_BLOCK = registerBlock("wax_block",
            () -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("ultvanillaexp:wax_block")))
                    .strength(0.6f, 0.6f).instrument(NoteBlockInstrument.FLUTE).sound(SoundType.CORAL_BLOCK)));







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
