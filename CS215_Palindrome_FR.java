import java.util.Stack;
import java.util.Scanner;

/**
 * CS215_Palindrome_FR: A program to check if a string is a palindrome using a stack.
 * Author: Felix Ramos
 */
public class CS215_Palindrome_FR {

    /**
     * This method checks if the given string is a palindrome.
     * It uses a stack to reverse the first half of the string and compares it to the second half.
     * @param input The string entered by the user.
     * @return True if the string is a palindrome, false if it is not.
     */
    public static boolean isPalindrome(String input) {
        // Create a stack to store characters
        Stack<Character> stack = new Stack<>();
        
        // Remove any spaces, punctuation, and change to lowercase
        String cleaned = input.replaceAll("[^a-zA-Z]", "").toLowerCase();
        
        // Find the length of the cleaned string
        int length = cleaned.length();

        // Push the first half of the string onto the stack
        for (int i = 0; i < length / 2; i++) {
            stack.push(cleaned.charAt(i));
        }

        // If the length is odd, skip the middle character
        int startIndex = (length % 2 == 0) ? length / 2 : length / 2 + 1;

        // Compare characters in the second half of the string with those popped from the stack
        for (int i = startIndex; i < length; i++) {
            // If the stack is not empty and the characters don't match, it's not a palindrome
            if (!stack.isEmpty() && stack.pop() != cleaned.charAt(i)) {
                return false; // Not a palindrome
            }
        }

        // If all characters match, it is a palindrome
        return true;
    }

    /**
     * The main method gets input from the user and checks if it is a palindrome.
     */
    public static void main(String[] args) {
        // Create a scanner to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Ask the user to enter a string
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Check if the entered string is a palindrome and display the result
        if (isPalindrome(input)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is not a palindrome.");
        }

        // Close the scanner
        scanner.close();
    }
}
