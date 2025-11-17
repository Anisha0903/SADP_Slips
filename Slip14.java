import java.util.Scanner;

interface Command { void execute(); }

class Light {
    public void on() { System.out.println("Light is ON"); }
    public void off() { System.out.println("Light is OFF"); }
}

class GarageDoor {
    public void up() { System.out.println("Garage Door is OPEN"); }
}

class Stereo {
    public void on() { System.out.println("Stereo is ON"); }
    public void setCD() { System.out.println("Stereo set to CD"); }
    public void setVolume(int v) { System.out.println("Stereo volume set to " + v); }
}

class LightOnCommand implements Command {
    Light light;
    public LightOnCommand(Light l) { light = l; }
    public void execute() { light.on(); }
}

class LightOffCommand implements Command {
    Light light;
    public LightOffCommand(Light l) { light = l; }
    public void execute() { light.off(); }
}

class GarageDoorUpCommand implements Command {
    GarageDoor gd;
    public GarageDoorUpCommand(GarageDoor g) { gd = g; }
    public void execute() { gd.up(); }
}

class StereoOnWithCDCommand implements Command {
    Stereo stereo;
    public StereoOnWithCDCommand(Stereo s) { stereo = s; }
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }
}

class RemoteControl {
    Command slot;
    public void setCommand(Command command) { slot = command; }
    public void pressButton() { slot.execute(); }
}

public class Slip14 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Light light = new Light();
        GarageDoor gd = new GarageDoor();
        Stereo stereo = new Stereo();
        RemoteControl remote = new RemoteControl();

        while (true) {
            System.out.println("\nChoose Command:");
            System.out.println("1. Light ON");
            System.out.println("2. Light OFF");
            System.out.println("3. Garage Door UP");
            System.out.println("4. Stereo ON with CD");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("Exiting...");
                break;
            }

            switch (choice) {
                case 1: remote.setCommand(new LightOnCommand(light)); break;
                case 2: remote.setCommand(new LightOffCommand(light)); break;
                case 3: remote.setCommand(new GarageDoorUpCommand(gd)); break;
                case 4: remote.setCommand(new StereoOnWithCDCommand(stereo)); break;
                default:
                    System.out.println("Invalid choice");
                    continue;
            }

            remote.pressButton();
        }
    }
}
