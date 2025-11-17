import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float t, float h, float p) {
        this.temperature = t;
        this.humidity = h;
        this.pressure = p;
        measurementsChanged();
    }
}

class CurrentConditionsDisplay implements Observer {
    public void update(Observable o, Object arg) {
        WeatherData wd = (WeatherData) o;
        System.out.println("Temp: " + wd.getTemperature() +
                " Humidity: " + wd.getHumidity() +
                " Pressure: " + wd.getPressure());
    }
}

public class Slip18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WeatherData wd = new WeatherData();
        CurrentConditionsDisplay display = new CurrentConditionsDisplay();
        wd.addObserver(display);

        while (true) {
            System.out.println("\n1. Enter Weather Data");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            if (ch == 2)
                break;

            System.out.print("Enter Temperature: ");
            float t = sc.nextFloat();
            System.out.print("Enter Humidity: ");
            float h = sc.nextFloat();
            System.out.print("Enter Pressure: ");
            float p = sc.nextFloat();

            wd.setMeasurements(t, h, p);
        }
    }
}
