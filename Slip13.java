import java.util.Scanner;

class Volt {
    private int volts;
    public Volt(int volts) {
        this.volts = volts;
    }
    public int getVolts() {
        return volts;
    }
}

class Socket {
    public Volt getVolt() {
        return new Volt(120);
    }
}

interface ChargerAdapter {
    Volt get3Volt();
    Volt get12Volt();
    Volt get120Volt();
}

class MobileChargerAdapter extends Socket implements ChargerAdapter {
    public Volt get3Volt() {
        return convertVolt(getVolt(), 40);
    }
    public Volt get12Volt() {
        return convertVolt(getVolt(), 10);
    }
    public Volt get120Volt() {
        return getVolt();
    }
    private Volt convertVolt(Volt v, int div) {
        return new Volt(v.getVolts() / div);
    }
}

public class Slip13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ChargerAdapter adapter = new MobileChargerAdapter();
        int choice;

        do {
            System.out.println("\n===== MOBILE CHARGER ADAPTER MENU =====");
            System.out.println("1. Get 3 Volts");
            System.out.println("2. Get 12 Volts");
            System.out.println("3. Get 120 Volts");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Output: " + adapter.get3Volt().getVolts() + "V");
                    break;
                case 2:
                    System.out.println("Output: " + adapter.get12Volt().getVolts() + "V");
                    break;
                case 3:
                    System.out.println("Output: " + adapter.get120Volt().getVolts() + "V");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);

        sc.close();
    }
}
