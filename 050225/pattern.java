import java.util.Scanner;

public class pattern {
          /*Input:
size = 7

Output:

      * 
     * * 
    * * * 
   * * * * 
  * * * * * 
 * * * * * * 
* * * * * * * 
* * * * * * * 
 * * * * * * 
  * * * * * 
   * * * * 
    * * * 
     * * 
      *
 */
          public static void main(String[] args) {
                    


        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int size = sc.nextInt();
        
        for (int i = 1; i <= size; i++) {
            // Printing spaces
            for (int j = i; j < size; j++) {
                System.out.print(" ");
            }
            // Printing stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        for (int i = size - 1; i >= 1; i--) {
            // Printing spaces
            for (int j = size; j > i; j--) {
                System.out.print(" ");
            }
            // Printing stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        sc.close();
    }
}

