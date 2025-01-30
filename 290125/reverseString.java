import java.util.Scanner;

public class reverseString {
    public static void main(String args[]){
        Scanner van = new Scanner(System.in);
        //i've done using prepend operation
        System.out.print("Enter a string: ");
        String n = van.nextLine();  // Input string
        String s = "";  // Initialize s empty string
        char ch;

        for (int i = 0; i < n.length(); i++) {
            ch = n.charAt(i); // Get the character
            s = ch + s;       
        }

        System.out.println("Reversed string: " + s); // Print the reversed string
    }
}
