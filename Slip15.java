import java.util.Scanner;

class Amplifier {
    public void on() { System.out.println("Amplifier ON"); }
    public void off() { System.out.println("Amplifier OFF"); }
    public void setVolume(int v) { System.out.println("Volume set to " + v); }
}

class DVDPlayer {
    public void on() { System.out.println("DVD Player ON"); }
    public void off() { System.out.println("DVD Player OFF"); }
    public void play(String movie) { System.out.println("Playing movie: " + movie); }
}

class Projector {
    public void on() { System.out.println("Projector ON"); }
    public void off() { System.out.println("Projector OFF"); }
    public void wideScreenMode() { System.out.println("Projector in widescreen mode"); }
}

class TheaterLights {
    public void dim(int level) { System.out.println("Lights dimmed to " + level + "%"); }
    public void on() { System.out.println("Lights ON"); }
}

class HomeTheaterFacade {
    Amplifier amp;
    DVDPlayer dvd;
    Projector projector;
    TheaterLights lights;

    public HomeTheaterFacade(Amplifier a, DVDPlayer d, Projector p, TheaterLights l) {
        amp = a; dvd = d; projector = p; lights = l;
    }

    public void watchMovie(String movie) {
        System.out.println("\nGet ready to watch a movie...");
        lights.dim(30);
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setVolume(8);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("\nShutting movie theater down...");
        lights.on();
        projector.off();
        amp.off();
        dvd.off();
    }
}

public class Slip15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Amplifier amp = new Amplifier();
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        TheaterLights lights = new TheaterLights();
        HomeTheaterFacade home = new HomeTheaterFacade(amp, dvd, projector, lights);

        while (true) {
            System.out.println("\n1. Watch Movie");
            System.out.println("2. End Movie");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 3) break;

            if (ch == 1) {
                System.out.print("Enter movie name: ");
                String movie = sc.nextLine();
                home.watchMovie(movie);
            } else if (ch == 2) {
                home.endMovie();
            } else {
                System.out.println("Invalid choice");
            }
        }
    }
}
