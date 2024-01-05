package pl.task;

import java.util.List;

public class Piece extends BlockExample implements CompositeBlock{
    private final List<Block> blocks;
    public Piece(String color, String material, List<Block> blocks) {
        super(color, material);
        this.blocks = blocks;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}
