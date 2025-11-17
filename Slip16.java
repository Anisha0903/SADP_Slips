import java.util.*;

interface Observer {
    void update(int number);
}

interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class NumberSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int number;

    public void setNumber(int number) {
        this.number = number;
        notifyObservers();
    }

    public int getNumber() { return number; }

    public void addObserver(Observer o) { observers.add(o); }

    public void removeObserver(Observer o) { observers.remove(o); }

    public void notifyObservers() {
        for (Observer o : observers) o.update(number);
    }
}

class BinaryObserver implements Observer {
    public void update(int number) {
        System.out.println("Binary: " + Integer.toBinaryString(number));
    }
}

class OctalObserver implements Observer {
    public void update(int number) {
        System.out.println("Octal: " + Integer.toOctalString(number));
    }
}

class HexObserver implements Observer {
    public void update(int number) {
        System.out.println("Hexadecimal: " + Integer.toHexString(number).toUpperCase());
    }
}

public class Slip16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NumberSubject subject = new NumberSubject();

        subject.addObserver(new BinaryObserver());
        subject.addObserver(new OctalObserver());
        subject.addObserver(new HexObserver());

        while (true) {
            System.out.println("\n1. Enter Number");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if (ch == 2) break;

            System.out.print("Enter decimal number: ");
            int num = sc.nextInt();
            subject.setNumber(num);
        }
    }
}
