import java.util.Scanner;

interface Command {
    void execute();
}

class Light {
    void on() {
        System.out.println("Light is ON");
    }
    void off() {
        System.out.println("Light is OFF");
    }
}

class LightOnCommand implements Command {
    Light light;
    LightOnCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    Light light;
    LightOffCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.off();
    }
}

class RemoteControl {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
    }
}

public class RemoteControlTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Light light = new Light();
        RemoteControl remote = new RemoteControl();

        while (true) {
            System.out.println("1. Turn Light ON");
            System.out.println("2. Turn Light OFF");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                remote.setCommand(new LightOnCommand(light));
                remote.pressButton();
            } 
            else if (choice == 2) {
                remote.setCommand(new LightOffCommand(light));
                remote.pressButton();
            } 
            else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } 
            else {
                System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
