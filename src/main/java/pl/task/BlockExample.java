package pl.task;

import java.util.Iterator;

public class BlockExample implements Block{
    private final String color;
    private final String material;

    public BlockExample(String color, String material) {
        this.color = color;
        this.material = material;
    }


    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "BlockExample{" +
                "color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
