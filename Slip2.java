import java.util.Scanner;

class UserInputSingleton {

    private static volatile UserInputSingleton instance;

    private String userInput;  

    private UserInputSingleton() {}

    public static UserInputSingleton getInstance() {
        if (instance == null) {                          
            synchronized (UserInputSingleton.class) {
                if (instance == null) {                 
                    instance = new UserInputSingleton();
                }
            }
        }
        return instance;
    }

    public void setUserInput(String input) {
        this.userInput = input;
    }

    public String getUserInput() {
        return userInput;
    }
}

public class Slip2 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any text: ");
        String inputText = sc.nextLine();

        UserInputSingleton singleton = UserInputSingleton.getInstance();
        singleton.setUserInput(inputText);

        Runnable task = () -> {
            UserInputSingleton obj = UserInputSingleton.getInstance();
            System.out.println(Thread.currentThread().getName() +
                    " received: " + obj.getUserInput());
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
