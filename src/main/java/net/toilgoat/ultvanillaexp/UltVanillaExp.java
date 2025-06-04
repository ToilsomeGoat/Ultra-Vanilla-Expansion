package net.toilgoat.ultvanillaexp;

import net.toilgoat.ultvanillaexp.block.Blocks;
import net.toilgoat.ultvanillaexp.item.Items;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
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

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        Items.register(modEventBus);
        Blocks.register(modEventBus);


        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example net.toilgoat.ultvanillaexp.block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(Items.URANIUM);
            event.accept(Items.BEESWAX);
        }
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(Items.GREEN_APPLE);
            event.accept(Items.CRYSTALLIZED_HONEY);
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
            event.accept(Blocks.MOSSY_POLISHED_ANDESITE_BRICKS);
            event.accept(Blocks.MOSSY_POLISHED_CALCITE_BRICKS);
            event.accept(Blocks.MOSSY_POLISHED_DIORITE_BRICKS);
            event.accept(Blocks.MOSSY_POLISHED_DRIPSTONE_BRICKS);
            event.accept(Blocks.MOSSY_POLISHED_GRANITE_BRICKS);
            event.accept(Blocks.WAX_BLOCK);
            event.accept(Blocks.POLISHED_DRIPSTONE_STAIRS);
            event.accept(Blocks.POLISHED_DRIPSTONE_SLAB);
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
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
