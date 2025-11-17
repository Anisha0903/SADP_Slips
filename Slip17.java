import java.util.Scanner;

interface Shape {
    void draw();
}

class Rectangle implements Shape {
    public void draw() { System.out.println("Normal Rectangle"); }
}

class Square implements Shape {
    public void draw() { System.out.println("Normal Square"); }
}

class RoundedRectangle implements Shape {
    public void draw() { System.out.println("Rounded Rectangle"); }
}

class RoundedSquare implements Shape {
    public void draw() { System.out.println("Rounded Square"); }
}

abstract class AbstractFactory {
    abstract Shape getShape(String shapeType);
}

class ShapeFactory extends AbstractFactory {
    Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("RECTANGLE")) return new Rectangle();
        if (shapeType.equalsIgnoreCase("SQUARE")) return new Square();
        return null;
    }
}

class RoundedShapeFactory extends AbstractFactory {
    Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("RECTANGLE")) return new RoundedRectangle();
        if (shapeType.equalsIgnoreCase("SQUARE")) return new RoundedSquare();
        return null;
    }
}

class FactoryProducer {
    static AbstractFactory getFactory(boolean rounded) {
        if (rounded) return new RoundedShapeFactory();
        return new ShapeFactory();
    }
}
public class Slip17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose Shape Type:");
            System.out.println("1. Normal Shapes");
            System.out.println("2. Rounded Shapes");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }

            AbstractFactory factory = FactoryProducer.getFactory(choice == 2);

            System.out.print("Enter Shape (rectangle/square): ");
            String shape = sc.nextLine();

            Shape s = factory.getShape(shape);
            if (s != null) s.draw();
            else System.out.println("Invalid Shape");
        }
    }
}
