package pl.task.ex;

public class MenuTest {
    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("Pancake house menu", "breakfast menu");
        MenuComponent dinerMenu = new Menu("ObjectTown menu", "lunch menu");
        MenuComponent cafeMenu = new Menu("cafe menu", "dinner menu");
        MenuComponent dessertMenu = new Menu("dessert menu", "enjoy dessert!!");

        MenuComponent allMenus = new Menu("all menus", "all menus");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        dinerMenu.add(new MenuItem("pasta", "pasta with bread", true, 3.89));
        dinerMenu.add(dessertMenu);

        dessertMenu.add(new MenuItem("apple pie", "apple pie with vanilla icecream", true, 1.59));

        Waitress waitress = new Waitress(new MenuItem("apple pie", "apple pie with vanilla icecream", true, 1.59));
        waitress.print();
        waitress.printVegetarianMenu();
    }
}
