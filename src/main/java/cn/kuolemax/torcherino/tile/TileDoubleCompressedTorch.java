package cn.kuolemax.torcherino.tile;

import java.util.Arrays;

public class TileDoubleCompressedTorch extends TileTorch {

    private final int factor = 9 * 9;

    @Override
    public int getSpeed() {
        return super.getSpeed() * factor;
    }

    @Override
    public int[] getSpeeds() {
        return Arrays.stream(super.getSpeeds()).map(it -> it * factor).toArray();
    }
}
