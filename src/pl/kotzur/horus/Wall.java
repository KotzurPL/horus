package pl.kotzur.horus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {

    private List<Block> blocks;
    private List<CompositeBlock> compositeBlocks;

    private List<Block> getAllBlocks() {
        List<Block> allBlocks = new ArrayList<>(blocks);
        for (CompositeBlock compositeBlock: compositeBlocks) {
            allBlocks.addAll(compositeBlock.getBlocks());
        }
        return allBlocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        Optional<Block> result;
        result = getAllBlocks().stream().filter(element -> element.getColor().equals(color)).findAny();
        return result;
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> result;
        result = getAllBlocks().stream().filter(element -> element.getMaterial().equals(material)).toList();
        return result;
    }

    @Override
    public int count() {
        return getAllBlocks().size();
    }
}
