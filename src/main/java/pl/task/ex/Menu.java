package pl.task.ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent {
    List<MenuComponent> menuComponents = new ArrayList<>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("--------------------");

        menuComponents.forEach(MenuComponent::print);
    }

    public Iterator<MenuComponent> createIterator() {
        return new CompositeIterator(menuComponents.iterator());
    }
}
