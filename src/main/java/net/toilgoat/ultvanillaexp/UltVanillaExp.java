package net.toilgoat.ultvanillaexp;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.toilgoat.ultvanillaexp.block.Blocks;
import net.toilgoat.ultvanillaexp.block.entity.BlockEntities;
import net.toilgoat.ultvanillaexp.entity.Entities;
import net.toilgoat.ultvanillaexp.entity.client.*;
import net.toilgoat.ultvanillaexp.event.ClientEvents;
import net.toilgoat.ultvanillaexp.event.EventBusEvents;
import net.toilgoat.ultvanillaexp.event.Events;
import net.toilgoat.ultvanillaexp.item.Items;
import net.toilgoat.ultvanillaexp.item.potion.Potion;
import net.toilgoat.ultvanillaexp.loot.LootModifiers;
import net.toilgoat.ultvanillaexp.recipe.Recipes;
import net.toilgoat.ultvanillaexp.screen.MenuTypes;
import net.toilgoat.ultvanillaexp.screen.custom.FrosterScreen;
import net.toilgoat.ultvanillaexp.structure.Features;
import net.toilgoat.ultvanillaexp.structure.StructurePieceTypes;
import net.toilgoat.ultvanillaexp.util.WoodTypes;
import net.toilgoat.ultvanillaexp.worldgen.tree.PlacerTypes;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(UltVanillaExp.MODID)
public class UltVanillaExp
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "ultvanillaexp";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public UltVanillaExp(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(ClientModEvents::onClientSetup);
        modEventBus.addListener(ClientModEvents::registerScreens);
        modEventBus.addListener(ClientModEvents::registerBlockColors);
        modEventBus.addListener(EventBusEvents::registerLayers);
        modEventBus.addListener(EventBusEvents::registerAttributes);
        modEventBus.addListener(EventBusEvents::registerSpawnPlacements);
        modEventBus.addListener(ClientEvents::registerBlockEntityRenderers);
        NeoForge.EVENT_BUS.register(Events.class);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        Items.register(modEventBus);
        Potion.register(modEventBus);
        Blocks.register(modEventBus);
        Entities.register(modEventBus);
        LootModifiers.register(modEventBus);
        BlockEntities.register(modEventBus);
        MenuTypes.register(modEventBus);
        Recipes.register(modEventBus);
        PlacerTypes.register(modEventBus);
        Features.register(modEventBus);
        StructurePieceTypes.register(modEventBus);


        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock) net.minecraft.world.level.block.Blocks.FLOWER_POT).addPlant(Blocks.BLUE_ROSE.getId(), Blocks.POTTED_BLUE_ROSE);
            ((FlowerPotBlock) net.minecraft.world.level.block.Blocks.FLOWER_POT).addPlant(Blocks.PALM_SAPLING.getId(), Blocks.POTTED_PALM_SAPLING);
            ((FlowerPotBlock) net.minecraft.world.level.block.Blocks.FLOWER_POT).addPlant(Blocks.PAEONIA.getId(), Blocks.POTTED_PAEONIA);
            ((FlowerPotBlock) net.minecraft.world.level.block.Blocks.FLOWER_POT).addPlant(Blocks.HIBISCUS.getId(), Blocks.POTTED_HIBISCUS);});
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(Items.URANIUM);
            event.accept(Items.BEESWAX);
            event.accept(Items.RUBY);
        }

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(Blocks.RUBY_ORE);
            event.accept(Blocks.DEEPSLATE_RUBY_ORE);
            event.accept(Blocks.PALM_LEAVES);
            event.accept(Blocks.PALM_SAPLING);
            event.accept(Blocks.BLUE_ROSE);
            event.accept(Blocks.PAEONIA);
            event.accept(Blocks.HIBISCUS);
        }

        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS){
            event.accept(Blocks.FROSTER);
            event.accept(Items.PALM_SIGN);
            event.accept(Items.PALM_HANGING_SIGN);
        }

        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(Items.GREEN_APPLE);
            event.accept(Items.CRYSTALLIZED_HONEY);
            event.accept(Items.BARLEY);
            event.accept(Items.BARLEY_SEEDS);
            event.accept(Items.BARLEY_STEW);
            event.accept(Items.ONION);
            event.accept(Items.BAKED_ONION);
            event.accept(Items.PEANUT);
            event.accept(Items.ROASTED_PEANUT);
            event.accept(Items.RAW_DUCK);
            event.accept(Items.ROASTED_DUCK);
            event.accept(Items.MELTED_COCOA);
            event.accept(Items.CHOCOLATE_PIECE);
            event.accept(Items.DARK_CHOCOLATE);
            event.accept(Items.MILK_CHOCOLATE);
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(Blocks.POLISHED_CALCITE);
            event.accept(Blocks.POLISHED_DRIPSTONE);
            event.accept(Blocks.POLISHED_ANDESITE_BRICKS);
            event.accept(Blocks.POLISHED_CALCITE_BRICKS);
            event.accept(Blocks.POLISHED_DIORITE_BRICKS);
            event.accept(Blocks.POLISHED_DRIPSTONE_BRICKS);
            event.accept(Blocks.POLISHED_GRANITE_BRICKS);
            event.accept(Blocks.CRACKED_POLISHED_ANDESITE_BRICKS);
            event.accept(Blocks.CRACKED_POLISHED_CALCITE_BRICKS);
            event.accept(Blocks.CRACKED_POLISHED_DIORITE_BRICKS);
            event.accept(Blocks.CRACKED_POLISHED_DRIPSTONE_BRICKS);
            event.accept(Blocks.CRACKED_POLISHED_GRANITE_BRICKS);
            event.accept(Blocks.CHISELED_POLISHED_ANDESITE_BRICKS);
            event.accept(Blocks.CHISELED_POLISHED_CALCITE_BRICKS);
            event.accept(Blocks.CHISELED_POLISHED_DIORITE_BRICKS);
            event.accept(Blocks.CHISELED_POLISHED_DRIPSTONE_BRICKS);
            event.accept(Blocks.CHISELED_POLISHED_GRANITE_BRICKS);
            event.accept(Blocks.MOSSY_DEEPSLATE_BRICKS);
            event.accept(Blocks.MOSSY_TUFF_BRICKS);
            event.accept(Blocks.MOSSY_POLISHED_ANDESITE_BRICKS);
            event.accept(Blocks.MOSSY_POLISHED_CALCITE_BRICKS);
            event.accept(Blocks.MOSSY_POLISHED_DIORITE_BRICKS);
            event.accept(Blocks.MOSSY_POLISHED_DRIPSTONE_BRICKS);
            event.accept(Blocks.MOSSY_POLISHED_GRANITE_BRICKS);
            //Stairs
            event.accept(Blocks.CALCITE_STAIRS);
            event.accept(Blocks.DRIPSTONE_STAIRS);
            event.accept(Blocks.POLISHED_CALCITE_STAIRS);
            event.accept(Blocks.POLISHED_DRIPSTONE_STAIRS);
            event.accept(Blocks.POLISHED_ANDESITE_BRICKS_STAIRS);
            event.accept(Blocks.POLISHED_CALCITE_BRICKS_STAIRS);
            event.accept(Blocks.POLISHED_DIORITE_BRICKS_STAIRS);
            event.accept(Blocks.POLISHED_DRIPSTONE_BRICKS_STAIRS);
            event.accept(Blocks.POLISHED_GRANITE_BRICKS_STAIRS);
            //Slab
            event.accept(Blocks.CALCITE_SLAB);
            event.accept(Blocks.DRIPSTONE_SLAB);
            event.accept(Blocks.POLISHED_CALCITE_SLAB);
            event.accept(Blocks.POLISHED_DRIPSTONE_SLAB);
            event.accept(Blocks.POLISHED_ANDESITE_BRICKS_SLAB);
            event.accept(Blocks.POLISHED_CALCITE_BRICKS_SLAB);
            event.accept(Blocks.POLISHED_DIORITE_BRICKS_SLAB);
            event.accept(Blocks.POLISHED_DRIPSTONE_BRICKS_SLAB);
            event.accept(Blocks.POLISHED_GRANITE_BRICKS_SLAB);
            //Wall
            event.accept(Blocks.CALCITE_WALL);
            event.accept(Blocks.DRIPSTONE_WALL);
            event.accept(Blocks.POLISHED_ANDESITE_WALL);
            event.accept(Blocks.POLISHED_CALCITE_WALL);
            event.accept(Blocks.POLISHED_DIORITE_WALL);
            event.accept(Blocks.POLISHED_DRIPSTONE_WALL);
            event.accept(Blocks.POLISHED_GRANITE_WALL);
            event.accept(Blocks.POLISHED_ANDESITE_BRICKS_WALL);
            event.accept(Blocks.POLISHED_CALCITE_BRICKS_WALL);
            event.accept(Blocks.POLISHED_DIORITE_BRICKS_WALL);
            event.accept(Blocks.POLISHED_DRIPSTONE_BRICKS_WALL);
            event.accept(Blocks.POLISHED_GRANITE_BRICKS_WALL);
            //HIEROGLYPHS
            event.accept(Blocks.HIEROGLYPH_BASKET);
            event.accept(Blocks.HIEROGLYPH_FOOT);
            event.accept(Blocks.HIEROGLYPH_REEDS);
            event.accept(Blocks.HIEROGLYPH_SNAKE);
            event.accept(Blocks.HIEROGLYPH_VULTURE);
            //ENGRAVED PRISMARINE BRICKS
            event.accept(Blocks.ENGRAVED_PRISMARINE_BRICKS_GUARDIAN);
            event.accept(Blocks.ENGRAVED_PRISMARINE_BRICKS_LASER);
            event.accept(Blocks.ENGRAVED_PRISMARINE_BRICKS_DROWNED);
            event.accept(Blocks.ENGRAVED_PRISMARINE_BRICKS_SUNKEN);
            // PALM
            event.accept(Blocks.PALM_LOG);
            event.accept(Blocks.STRIPPED_PALM_LOG);
            event.accept(Blocks.PALM_WOOD);
            event.accept(Blocks.STRIPPED_PALM_WOOD);
            event.accept(Blocks.PALM_PLANKS);
            event.accept(Blocks.PALM_STAIRS);
            event.accept(Blocks.PALM_SLAB);
            event.accept(Blocks.PALM_FENCE);
            event.accept(Blocks.PALM_FENCE_GATE);
            event.accept(Blocks.PALM_TRAPDOOR);
            event.accept(Blocks.PALM_DOOR);
            event.accept(Blocks.PALM_PRESSURE_PLATE);
            event.accept(Blocks.PALM_BUTTON);

            event.accept(Blocks.ACACIA_LEAVES_CARPET);
            event.accept(Blocks.AZALEA_LEAVES_CARPET);
            event.accept(Blocks.FLOWERING_AZALEA_LEAVES_CARPET);
            event.accept(Blocks.BIRCH_LEAVES_CARPET);
            event.accept(Blocks.CHERRY_LEAVES_CARPET);
            event.accept(Blocks.DARK_OAK_LEAVES_CARPET);
            event.accept(Blocks.JUNGLE_LEAVES_CARPET);
            event.accept(Blocks.MANGROVE_LEAVES_CARPET);
            event.accept(Blocks.PALE_OAK_LEAVES_CARPET);
            event.accept(Blocks.PALM_LEAVES_CARPET);
            event.accept(Blocks.OAK_LEAVES_CARPET);

            event.accept(Blocks.WAX_BLOCK);

        }
        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.accept(Items.DUCK_SPAWN_EGG);
            event.accept(Items.GRIZZLY_BEAR_SPAWN_EGG);
            event.accept(Items.FROSTBITTEN_SPAWN_EGG);
            event.accept(Items.SCORCHED_SPAWN_EGG);
            event.accept(Items.SUNKEN_SPAWN_EGG);
            event.accept(Items.DESERTED_TRADER_SPAWN_EGG);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            Sheets.addWoodType(WoodTypes.PALM);
            ItemBlockRenderTypes.setRenderLayer(Blocks.BARLEY_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.ONION_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.PEANUT_CROP.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.PALM_DOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.PALM_TRAPDOOR.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.PALM_LEAVES.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.PALM_SIGN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.PALM_WALL_SIGN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.PALM_HANGING_SIGN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.PALM_WALL_HANGING_SIGN.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.PALM_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.POTTED_PALM_SAPLING.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.BLUE_ROSE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.POTTED_BLUE_ROSE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.PAEONIA.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.POTTED_PAEONIA.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.HIBISCUS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.POTTED_HIBISCUS.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.ACACIA_LEAVES_CARPET.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.AZALEA_LEAVES_CARPET.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.FLOWERING_AZALEA_LEAVES_CARPET.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.BIRCH_LEAVES_CARPET.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.CHERRY_LEAVES_CARPET.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.DARK_OAK_LEAVES_CARPET.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.JUNGLE_LEAVES_CARPET.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.MANGROVE_LEAVES_CARPET.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.PALE_OAK_LEAVES_CARPET.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.PALM_LEAVES_CARPET.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(Blocks.OAK_LEAVES_CARPET.get(), RenderType.cutout());


            EntityRenderers.register(Entities.DUCK.get(), DuckRenderer::new);
            EntityRenderers.register(Entities.GRIZZLY_BEAR.get(), GrizzlyBearRenderer::new);
            EntityRenderers.register(Entities.SCORCHED.get(), ScorchedRenderer::new);
            EntityRenderers.register(Entities.SUNKEN.get(), SunkenRenderer::new);
            EntityRenderers.register(Entities.FROSTBITTEN.get(), FrostbittenRenderer::new);
            EntityRenderers.register(Entities.DESERTED_TRADER.get(), DesertedTraderRenderer::new);
        }
        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(MenuTypes.FROSTER_MENU.get(), FrosterScreen::new);
        }
        @SubscribeEvent
        public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
            event.register(
                    (state, level, pos, tintIndex)
                            -> level != null && pos != null
                            ? BiomeColors.getAverageFoliageColor(level, pos)
                            : FoliageColor.FOLIAGE_DEFAULT,
                    Blocks.PALM_LEAVES.get(),
                    Blocks.ACACIA_LEAVES_CARPET.get(),
                    Blocks.BIRCH_LEAVES_CARPET.get(),
                    Blocks.DARK_OAK_LEAVES_CARPET.get(),
                    Blocks.JUNGLE_LEAVES_CARPET.get(),
                    Blocks.MANGROVE_LEAVES_CARPET.get(),
                    Blocks.PALM_LEAVES_CARPET.get(),
                    Blocks.OAK_LEAVES_CARPET.get()
            );
        }
    }
}
