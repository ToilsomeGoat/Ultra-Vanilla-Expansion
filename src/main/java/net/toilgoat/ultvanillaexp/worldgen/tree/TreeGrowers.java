package net.toilgoat.ultvanillaexp.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.toilgoat.ultvanillaexp.UltVanillaExp;
import net.toilgoat.ultvanillaexp.worldgen.ConfiguredFeatures;

import java.util.Optional;

public class TreeGrowers {
    public static final TreeGrower PALM = new TreeGrower(UltVanillaExp.MODID + ":palm",
            Optional.empty(), Optional.of(ConfiguredFeatures.PALM_KEY), Optional.empty());
}
