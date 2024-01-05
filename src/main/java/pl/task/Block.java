package pl.task;

import pl.task.ex.MenuComponent;

import java.util.Iterator;

public interface Block {
    String getColor();
    String getMaterial();

    Iterator<Block> createIterator();
}