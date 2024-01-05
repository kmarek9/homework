package pl.task;

import java.util.*;
import java.util.stream.Collectors;

public class Wall implements Structure {
    private final List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        if(blocksNullOrEmpty()){
            return Optional.empty();
        }

        for(Block block : blocks){
            Iterator<Block> blockIterator = block.createIterator();
            while(blockIterator.hasNext()){
                Block b = blockIterator.next();
                if (color.equals(b.getColor())) {
                    return Optional.of(b);
                }
            }
        }

        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if(blocksNullOrEmpty()){
            return Collections.emptyList();
        }

        List<Block> matchingBlocks = new ArrayList<>();
        for(Block block : blocks) {
            Iterator<Block> blockIterator = block.createIterator();
            while (blockIterator.hasNext()) {
                Block b = blockIterator.next();
                if (material.equals(b.getMaterial())) {
                    matchingBlocks.add(b);
                }
            }
        }
        return matchingBlocks;
    }

    @Override
    public int count() {
        if(blocksNullOrEmpty()) {
            return 0;
        }

        int result=0;

        for(Block block : blocks) {
            Iterator<Block> blockIterator = block.createIterator();
            while (blockIterator.hasNext()) {
                result++;
                blockIterator.next();
            }
        }
        return result;
    }

    private boolean blocksNullOrEmpty() {
        return blocks == null || blocks.isEmpty();
    }
}