package net.toilgoat.ultvanillaexp.datamaps;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import net.neoforged.neoforge.registries.datamaps.RegisterDataMapTypesEvent;

public class DatamapTypes {
    public static final DataMapType<Item, FrosterFuel> FROSTER_FUELS = DataMapType.builder(
        ResourceLocation.fromNamespaceAndPath("ultvanillaexp", "froster_fuels"),
        Registries.ITEM, FrosterFuel.CODEC)
            .synced(FrosterFuel.CODEC, false).build();
    @SubscribeEvent
    private static void registerDataMapTypes(RegisterDataMapTypesEvent event) {
        event.register(FROSTER_FUELS);
    }
}
