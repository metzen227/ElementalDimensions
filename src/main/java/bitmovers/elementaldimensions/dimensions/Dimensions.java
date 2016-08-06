package bitmovers.elementaldimensions.dimensions;

import bitmovers.elementaldimensions.util.Config;
import com.google.common.collect.Maps;
import elec332.core.api.structure.GenerationType;
import net.minecraft.util.IStringSerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;

/**
 * Created by Elec332 on 4-8-2016.
 */
public enum Dimensions implements IStringSerializable {

    EARTH(0, GenerationType.SURFACE) {

        @Override
        public int getDimensionID() {
            return Config.Dimensions.Earth.dimensionID;
        }

    },
    WATER(1, GenerationType.SURFACE) {

        @Override
        public int getDimensionID() {
            return Config.Dimensions.Water.dimensionID;
        }

    },
    AIR(2, GenerationType.SEA_LEVEL) {

        @Override
        public int getDimensionID() {
            return Config.Dimensions.Air.dimensionID;
        }

    },
    SPIRIT(3, GenerationType.NONE) {

        @Override
        public int getDimensionID() {
            return Config.Dimensions.Spirit.dimensionID;
        }

    },
    FIRE(4, GenerationType.SEA_LEVEL) {

        @Override
        public int getDimensionID() {
            return Config.Dimensions.Fire.dimensionID;
        }

    },
    OVERWORLD(-1, GenerationType.SURFACE) {

        @Override
        public int getDimensionID() {
            return 0;
        }

    };

    Dimensions(int level, GenerationType generationType){
        this.level = (byte)level;
        this.generationType = generationType;
        this.name = toString().toLowerCase();
    }

    private final byte level;
    private final GenerationType generationType;
    private final String name;

    public abstract int getDimensionID();

    public byte getLevel(){
        return level;
    }

    public GenerationType getGenerationType() {
        return generationType;
    }

    @Nullable
    public static Dimensions findDimension(int id) {
        for (Dimensions dimension : Dimensions.values()){
            if (dimension.getDimensionID() == id){
                return dimension;
            }
        }
        return null;
    }

    @Override
    @Nonnull
    public String getName() {
        return name;
    }

    public static Dimensions getDimensionFromLevel(int level){
        return LEVEL_MAP.get(level);
    }

    public static final Dimensions[] VALUES;
    private static final Map<Integer, Dimensions> LEVEL_MAP;

    static {
        VALUES = values();
        LEVEL_MAP = Maps.newHashMap();
        for (Dimensions dim : VALUES){
            LEVEL_MAP.put((int)dim.getLevel(), dim);
        }
    }

}
