package pl.task;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Block block1= new BlockExample("color1", "material3");
        Block block2= new BlockExample("color2", "material2");
        Block block3= new BlockExample("color3", "material3");
        Block block4= new Piece("color4", "material3", List.of(block2, block3));

        Block block5= new BlockExample("color5", "material3");
        Block block6= new BlockExample("color6", "material6");
        Block block7= new Piece("color7", "material7", List.of(block5, block6, block4));

        Wall wall = new Wall(List.of(block1, block7));

        System.out.println(wall.count());
        System.out.println(wall.findBlockByColor("color2"));
        System.out.println(Arrays.toString( wall.findBlocksByMaterial("material3").toArray()));
    }
}
