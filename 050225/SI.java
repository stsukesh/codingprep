import java.util.Scanner;
/*Simple interest is a quick method of calculating the interest charge on a loan. Simple interest is determined by multiplying the daily interest rate by the principal by the number of days that elapse between payments. 

Simple interest formula is given by:

Simple Interest = (P x T x R)/100 
Example 1:

Input :  P = 10000
         R = 5
         T = 5
Output : 2500*/
public class SI {

          public static void main(String[] args) {
          Scanner vangu = new Scanner(System.in);
          int p=vangu.nextInt();               
          int t=vangu.nextInt();               
          int r=vangu.nextInt();     
          int si=(p*t*r)/100;    
          System.out.println(si);
          vangu.close();      
          }
          
}
