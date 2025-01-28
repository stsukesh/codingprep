import java.util.Scanner;
public class FibronacciSeries {
          public static void main(String[] args) {
                    Scanner vangu = new Scanner(System.in);
                    System.out.println("Enter a number for fib series");
                    int n=vangu.nextInt();
                    int a=0,b=1,c=0;// initalization of numbers
                    System.out.print(a);

                    for(int i=1;i<n;i++){
                              c=a+b; //finds the fib number for the current literation
                              System.out.print(" " + c);
                              a=b;// swaps the previous and the current to the next number
                              b=c;
                    }

          vangu.close();
}
}