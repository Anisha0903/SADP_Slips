import java.util.Scanner;

interface FlyBehavior {
    void fly();
}

class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("Flying with wings!");
    }
}

class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("I can't fly.");
    }
}

class FlyRocketPowered implements FlyBehavior {
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}

interface QuackBehavior {
    void quack();
}

class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("Quack Quack!");
    }
}

class Squeak implements QuackBehavior {
    public void quack() {
        System.out.println("Squeak!");
    }
}

class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("<< Silence >>");
    }
}

class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    Duck(FlyBehavior fb, QuackBehavior qb) {
        this.flyBehavior = fb;
        this.quackBehavior = qb;
    }

    void performFly() {
        flyBehavior.fly();
    }

    void performQuack() {
        quackBehavior.quack();
    }

    void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }
}

public class Slip10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Duck duck = new Duck(new FlyWithWings(), new Quack());
        int choice;

        do {
            System.out.println("\n=== DUCK BEHAVIOR MENU ===");
            System.out.println("1. Perform Fly");
            System.out.println("2. Perform Quack");
            System.out.println("3. Change Fly Behavior");
            System.out.println("4. Change Quack Behavior");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    duck.performFly();
                    break;

                case 2:
                    duck.performQuack();
                    break;

                case 3:
                    System.out.println("\nSelect Fly Behavior:");
                    System.out.println("1. Fly with Wings");
                    System.out.println("2. No Fly");
                    System.out.println("3. Rocket Powered Fly");
                    System.out.print("Choose: ");
                    int fb = sc.nextInt();

                    if (fb == 1) duck.setFlyBehavior(new FlyWithWings());
                    else if (fb == 2) duck.setFlyBehavior(new FlyNoWay());
                    else if (fb == 3) duck.setFlyBehavior(new FlyRocketPowered());
                    else System.out.println("Invalid option");
                    break;

                case 4:
                    System.out.println("\nSelect Quack Behavior:");
                    System.out.println("1. Quack");
                    System.out.println("2. Squeak");
                    System.out.println("3. Mute");
                    System.out.print("Choose: ");
                    int qb = sc.nextInt();

                    if (qb == 1) duck.setQuackBehavior(new Quack());
                    else if (qb == 2) duck.setQuackBehavior(new Squeak());
                    else if (qb == 3) duck.setQuackBehavior(new MuteQuack());
                    else System.out.println("Invalid option");
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
