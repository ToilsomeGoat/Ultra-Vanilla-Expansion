package net.toilgoat.ultvanillaexp.datagen;

import net.neoforged.neoforge.common.data.DataMapProvider;
import net.toilgoat.ultvanillaexp.item.Items;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.CompletableFuture;

public class DataMapsProvider extends DataMapProvider {
    protected DataMapsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(Items.URANIUM.getId(), new FurnaceFuel(3000), false);

        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(Items.ONION.getId(), new Compostable(0.65f),true)
                .add(Items.BAKED_ONION.getId(), new Compostable(0.85f), true)
                .add(Items.BARLEY_SEEDS.getId(), new Compostable(0.5f), true)
                .add(Items.BARLEY.getId(), new Compostable(0.65f), true);
    }
}