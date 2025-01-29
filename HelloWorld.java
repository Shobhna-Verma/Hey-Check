// HelloWorld.java
import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for their name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Print the greeting message
        System.out.println("Hello, " + name + "!");
        
        scanner.close();
    }
}
