import java.util.Scanner;

interface BeatModel {
    void initialize();
    int getHeartRate();
}

class HeartModel {
    private int heartRate;

    public HeartModel(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getHeartRateValue() {
        return heartRate;
    }

    public void setHeartRateValue(int heartRate) {
        this.heartRate = heartRate;
    }
}

class HeartAdapter implements BeatModel {
    private HeartModel heartModel;

    public HeartAdapter(HeartModel heartModel) {
        this.heartModel = heartModel;
    }

    public void initialize() {
        System.out.println("Heart Model Initialized...");
    }

    public int getHeartRate() {
        return heartModel.getHeartRateValue();
    }
}

public class Slip11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial heart rate: ");
        int rate = sc.nextInt();

        HeartModel heart = new HeartModel(rate);
        BeatModel beatModel = new HeartAdapter(heart);

        beatModel.initialize();

        int choice;
        do {
            System.out.println("\n===== HEART BEAT MENU =====");
            System.out.println("1. Show Heart Rate");
            System.out.println("2. Change Heart Rate");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Heart Rate: " + beatModel.getHeartRate() + " BPM");
                    break;

                case 2:
                    System.out.print("Enter new heart rate: ");
                    int newRate = sc.nextInt();
                    heart.setHeartRateValue(newRate);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 3);

        sc.close();
    }
}
