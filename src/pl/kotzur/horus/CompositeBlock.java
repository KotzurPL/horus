package pl.kotzur.horus;

import java.util.List;

public interface CompositeBlock extends Block {
    List<Block> getBlocks();
}
