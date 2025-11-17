import java.util.Scanner;

interface Car {
    void assemble();
}

class BasicCar implements Car {
    public void assemble() {
        System.out.println("Basic Car");
    }
}

abstract class CarDecorator implements Car {
    protected Car car;
    public CarDecorator(Car car) {
        this.car = car;
    }
    public void assemble() {
        car.assemble();
    }
}

class SportsCar extends CarDecorator {
    public SportsCar(Car car) {
        super(car);
    }
    public void assemble() {
        super.assemble();
        System.out.println("Adding features of Sports Car");
    }
}

class LuxuryCar extends CarDecorator {
    public LuxuryCar(Car car) {
        super(car);
    }
    public void assemble() {
        super.assemble();
        System.out.println("Adding features of Luxury Car");
    }
}

public class Slip12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== CAR DECORATOR MENU =====");
            System.out.println("1. Basic Car");
            System.out.println("2. Sports Car");
            System.out.println("3. Luxury Car");
            System.out.println("4. Sports + Luxury Car");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            Car car;

            switch (choice) {
                case 1:
                    car = new BasicCar();
                    car.assemble();
                    break;

                case 2:
                    car = new SportsCar(new BasicCar());
                    car.assemble();
                    break;

                case 3:
                    car = new LuxuryCar(new BasicCar());
                    car.assemble();
                    break;

                case 4:
                    car = new LuxuryCar(new SportsCar(new BasicCar()));
                    car.assemble();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}
