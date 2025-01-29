import java.util.Scanner;

public class reverseString {
    public static void main(String args[]){
        Scanner van = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String n = van.nextLine();  // Input string
        String s = "";  // Initialize s as an empty string
        char ch;

        // Ensure we are looping within the bounds of the string length
        for (int i = 0; i < n.length(); i++) {
            ch = n.charAt(i); // Get the character at the current index
            s = ch + s;       // Prepend the character to the result string
        }

        System.out.println("Reversed string: " + s); // Print the reversed string
    }
}
