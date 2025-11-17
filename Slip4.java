import java.util.Scanner;

abstract class Pizza {
    String name;

    void prepare() {
        System.out.println("Preparing " + name);
    }

    void bake() {
        System.out.println("Baking " + name);
    }

    void cut() {
        System.out.println("Cutting " + name);
    }

    void box() {
        System.out.println("Boxing " + name);
    }

    String getName() {
        return name;
    }
}

class NYStyleCheesePizza extends Pizza {
    NYStyleCheesePizza() {
        name = "NY Style Cheese Pizza";
    }
}

class ChicagoStyleCheesePizza extends Pizza {
    ChicagoStyleCheesePizza() {
        name = "Chicago Style Cheese Pizza";
    }

    void cut() {
        System.out.println("Cutting " + name + " into square slices");
    }
}

abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    abstract Pizza createPizza(String type);
}

class NYPizzaStore extends PizzaStore {
    Pizza createPizza(String type) {
        if (type.equalsIgnoreCase("cheese"))
            return new NYStyleCheesePizza();
        return null;
    }
}

class ChicagoPizzaStore extends PizzaStore {
    Pizza createPizza(String type) {
        if (type.equalsIgnoreCase("cheese"))
            return new ChicagoStyleCheesePizza();
        return null;
    }
}

public class PizzaFactoryDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Store: 1) NY  2) Chicago");
        int storeChoice = sc.nextInt();
        System.out.println("Enter Pizza Type (cheese): ");
        String type = sc.next();

        PizzaStore store;
        if (storeChoice == 1)
            store = new NYPizzaStore();
        else
            store = new ChicagoPizzaStore();

        Pizza pizza = store.orderPizza(type);
        System.out.println(pizza.getName() + " is ready");
        sc.close();
    }
}
