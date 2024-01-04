package org.example;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {
    private final CompositeBlock blocks;

    public Wall(CompositeBlock blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        if(blocksNullOrEmpty()){
            return Optional.empty();
        }

        return blocks.getBlocks().stream()
                .filter(block -> block.getColor().equals(color))
                .findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if(blocksNullOrEmpty()){
            return Collections.emptyList();
        }

        return blocks.getBlocks().stream()
                .filter(block -> block.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        if(blocksNullOrEmpty()) {
            return 0;
        }
        return blocks.getBlocks().size();
    }

    private boolean blocksNullOrEmpty() {
        return blocks == null || blocks.getBlocks()==null || blocks.getBlocks().isEmpty();
    }
}