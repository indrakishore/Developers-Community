// Java program that prompts the user for a list of integers, then checks if the number at index k is greater than 0. 
// The program handles user input and checks for valid indices.

// How the Code Works:
// Input Handling: The program takes input from the user until they type "done". It adds valid integers to a list.
// Index Input: After the user has finished entering numbers, it prompts for an index k.
// Validation: The program checks if k is a valid index for the list. 
// If valid, it checks if the number at that index is greater than 0 and prints the appropriate message.
// Error Handling: It handles cases where the input is not a valid integer or where the index is out of bounds.

// solution
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckNumberAtIndex {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Enter numbers (type 'done' to finish):");

        // Read integers from user until they type 'done'
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            } else if (scanner.next().equalsIgnoreCase("done")) {
                break;
            } else {
                System.out.println("Please enter a valid integer or 'done' to finish.");
            }
        }

        System.out.println("Enter the index k to check:");
        int k = scanner.nextInt();

        // Check if k is within the valid range
        if (k >= 0 && k < numbers.size()) {
            int numberAtK = numbers.get(k);
            if (numberAtK > 0) {
                System.out.println("The number at index " + k + " is greater than 0.");
            } else {
                System.out.println("The number at index " + k + " is not greater than 0.");
            }
        } else {
            System.out.println("Index " + k + " is out of bounds. Please enter a valid index.");
        }

        scanner.close();
    }
}
