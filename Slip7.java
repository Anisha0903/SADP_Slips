import java.util.Scanner;

interface Command {
    void execute();
    void undo();
}

class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    private int speed = OFF;

    public void high() {
        speed = HIGH;
        System.out.println("Ceiling Fan is HIGH");
    }

    public void medium() {
        speed = MEDIUM;
        System.out.println("Ceiling Fan is MEDIUM");
    }

    public void low() {
        speed = LOW;
        System.out.println("Ceiling Fan is LOW");
    }

    public void off() {
        speed = OFF;
        System.out.println("Ceiling Fan is OFF");
    }

    public int getSpeed() {
        return speed;
    }
}

class CeilingFanHighCommand implements Command {
    CeilingFan fan;
    int prevSpeed;

    CeilingFanHighCommand(CeilingFan fan) {
        this.fan = fan;
    }

    public void execute() {
        prevSpeed = fan.getSpeed();
        fan.high();
    }

    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) fan.high();
        else if (prevSpeed == CeilingFan.MEDIUM) fan.medium();
        else if (prevSpeed == CeilingFan.LOW) fan.low();
        else fan.off();
    }
}

class CeilingFanMediumCommand implements Command {
    CeilingFan fan;
    int prevSpeed;

    CeilingFanMediumCommand(CeilingFan fan) {
        this.fan = fan;
    }

    public void execute() {
        prevSpeed = fan.getSpeed();
        fan.medium();
    }

    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) fan.high();
        else if (prevSpeed == CeilingFan.MEDIUM) fan.medium();
        else if (prevSpeed == CeilingFan.LOW) fan.low();
        else fan.off();
    }
}

class CeilingFanLowCommand implements Command {
    CeilingFan fan;
    int prevSpeed;

    CeilingFanLowCommand(CeilingFan fan) {
        this.fan = fan;
    }

    public void execute() {
        prevSpeed = fan.getSpeed();
        fan.low();
    }

    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) fan.high();
        else if (prevSpeed == CeilingFan.MEDIUM) fan.medium();
        else if (prevSpeed == CeilingFan.LOW) fan.low();
        else fan.off();
    }
}

class CeilingFanOffCommand implements Command {
    CeilingFan fan;
    int prevSpeed;

    CeilingFanOffCommand(CeilingFan fan) {
        this.fan = fan;
    }

    public void execute() {
        prevSpeed = fan.getSpeed();
        fan.off();
    }

    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) fan.high();
        else if (prevSpeed == CeilingFan.MEDIUM) fan.medium();
        else if (prevSpeed == CeilingFan.LOW) fan.low();
        else fan.off();
    }
}

class RemoteControl {
    Command command;
    Command undoCommand;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        undoCommand = command;
    }

    public void pressUndo() {
        if (undoCommand != null) {
            System.out.println("Undoing...");
            undoCommand.undo();
        }
    }
}

public class Slip7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CeilingFan fan = new CeilingFan();
        RemoteControl remote = new RemoteControl();

        while (true) {
            System.out.println("\n1. Fan HIGH");
            System.out.println("2. Fan MEDIUM");
            System.out.println("3. Fan LOW");
            System.out.println("4. Fan OFF");
            System.out.println("5. UNDO");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    remote.setCommand(new CeilingFanHighCommand(fan));
                    remote.pressButton();
                    break;

                case 2:
                    remote.setCommand(new CeilingFanMediumCommand(fan));
                    remote.pressButton();
                    break;

                case 3:
                    remote.setCommand(new CeilingFanLowCommand(fan));
                    remote.pressButton();
                    break;

                case 4:
                    remote.setCommand(new CeilingFanOffCommand(fan));
                    remote.pressButton();
                    break;

                case 5:
                    remote.pressUndo();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
