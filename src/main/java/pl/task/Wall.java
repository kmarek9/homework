package pl.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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

        Optional<Block> result = Optional.empty();
        for (Block block : blocks) {
            result = findFirstBlockByColorRecursively(block, color);
            if(result.isPresent()){
                break;
            }
        }

        return result;
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if(blocksNullOrEmpty()){
            return Collections.emptyList();
        }

        List<Block> matchingBlocks = new ArrayList<>();
        for (Block block : blocks) {
            findBlocksByMaterialRecursively(block, material, matchingBlocks);
        }
        return matchingBlocks;
    }

    @Override
    public int count() {
        if(blocksNullOrEmpty()) {
            return 0;
        }

        return countRecursively(blocks);
    }
    private int countRecursively(List<Block> blocks) {
        int totalCount = blocks.size();
        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                totalCount += countRecursively(((CompositeBlock) block).getBlocks());
            }
        }
        return totalCount;
    }

    private Optional<Block> findFirstBlockByColorRecursively(Block block, String color) {
        if (color.equals(block.getColor())) {
            return Optional.of(block);
        }

        Optional<Block> result = Optional.empty();
        if (block instanceof CompositeBlock) {
            for (Block subBlock : ((CompositeBlock) block).getBlocks()) {
                result = findFirstBlockByColorRecursively(subBlock, color);
                if(result.isPresent()){
                    break;
                }
            }
        }
        return result;
    }

    private void findBlocksByMaterialRecursively(Block block, String material, List<Block> matchingBlocks) {
        if (material.equals(block.getMaterial())) {
            matchingBlocks.add(block);
        }
        if (block instanceof CompositeBlock) {
            for (Block subBlock : ((CompositeBlock) block).getBlocks()) {
                findBlocksByMaterialRecursively(subBlock, material, matchingBlocks);
            }
        }
    }

    private boolean blocksNullOrEmpty() {
        return blocks == null || blocks.isEmpty();
    }
}