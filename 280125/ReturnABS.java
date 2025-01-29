/*
2.You have two numbers, and your challenge is to write a program that performs both 
addition and subtraction with them. However, if any subtraction results in a negative 
number, display it as a positive value. How will you tackle this and show the final 
results?*/
import java.util.Random;
public class ReturnABS {
          public static void main(String[] args) {
                    Random ra = new Random();
                    int a =ra.nextInt(100);// insted of entering input manually we are genrating it random ly
                    int b =ra.nextInt((1000-100)+1)+100;//this make's sure that the second numbers is less than that of the first number
                    System.out.println("The genrated first random number is: "+ a);
                    System.out.println("The genrated Second random number is: "+ b);
                    System.out.println("The Absolute value of first - second number is "+Math.abs(a-b));

          }
          
}
