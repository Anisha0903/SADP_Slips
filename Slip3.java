import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

class WeatherStation extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() { return temperature; }
    public float getHumidity() { return humidity; }
    public float getPressure() { return pressure; }
}

class CurrentDisplay implements Observer {
    private float temperature;
    private float humidity;
    private float pressure;

    public void update(Observable obs, Object arg) {
        if (obs instanceof WeatherStation) {
            WeatherStation ws = (WeatherStation) obs;
            this.temperature = ws.getTemperature();
            this.humidity = ws.getHumidity();
            this.pressure = ws.getPressure();
            display();
        }
    }

    public void display() {
        System.out.println("\n===== Weather Update =====");
        System.out.println("Temperature: " + temperature + " °C");
        System.out.println("Humidity: " + humidity + " %");
        System.out.println("Pressure: " + pressure + " hPa");
        System.out.println("==========================\n");
    }
}

public class Slip3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        WeatherStation ws = new WeatherStation();
        CurrentDisplay display = new CurrentDisplay();
        ws.addObserver(display);

        while (true) {
            System.out.print("Enter temperature (°C): ");
            float temp = sc.nextFloat();

            System.out.print("Enter humidity (%): ");
            float hum = sc.nextFloat();

            System.out.print("Enter pressure (hPa): ");
            float pres = sc.nextFloat();

            ws.setMeasurements(temp, hum, pres);

            System.out.print("Do you want to enter again? (y/n): ");
            char choice = sc.next().charAt(0);

            if (choice == 'n' || choice == 'N') {
                System.out.println("Exiting Weather Station...");
                break;
            }
        }

        sc.close();
    }
}
