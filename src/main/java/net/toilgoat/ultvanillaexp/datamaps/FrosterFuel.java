package net.toilgoat.ultvanillaexp.datamaps;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ExtraCodecs;


    public record FrosterFuel(int frostTime) {
        public static final Codec<FrosterFuel> FROST_TIME_CODEC = ExtraCodecs.POSITIVE_INT
                .xmap(FrosterFuel::new, FrosterFuel::frostTime);
        public static final Codec<FrosterFuel> CODEC = Codec.withAlternative(
                RecordCodecBuilder.create(in -> in.group(
                        ExtraCodecs.POSITIVE_INT.fieldOf("frost_time").forGetter(FrosterFuel::frostTime)).apply(in, FrosterFuel::new)),
                FROST_TIME_CODEC);
    }
