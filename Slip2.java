import java.util.Scanner;

// ------------ Singleton Class ------------
class UserInputSingleton {

    // volatile ensures visibility across threads
    private static volatile UserInputSingleton instance;

    private String userInput;  // stores input given by user

    // private constructor
    private UserInputSingleton() {}

    // thread-safe instance getter
    public static UserInputSingleton getInstance() {
        if (instance == null) {                          // First check
            synchronized (UserInputSingleton.class) {
                if (instance == null) {                  // Second check
                    instance = new UserInputSingleton();
                }
            }
        }
        return instance;
    }

    // setter method
    public void setUserInput(String input) {
        this.userInput = input;
    }

    // getter method
    public String getUserInput() {
        return userInput;
    }
}

// ------------ Main Class ------------
public class Slip2 {
    public static void main(String[] args) {

        // Taking user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any text: ");
        String inputText = sc.nextLine();

        // Set input inside singleton
        UserInputSingleton singleton = UserInputSingleton.getInstance();
        singleton.setUserInput(inputText);

        // Creating threads
        Runnable task = () -> {
            UserInputSingleton obj = UserInputSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() +
                    " received: " + obj.getUserInput());
        };

        // Start multiple threads
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
