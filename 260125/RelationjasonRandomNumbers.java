import java.util.Random;
/*2.You have two secret numbers, and you need to figure out how they relate to each other 
using a set of special tools. Your challenge is to write a program that uses these tools—>, 
>=, <, <=, ==, and !=—to uncover all the secrets about how these numbers compare. How 
will you use each tool to solve the puzzle?
For example, consider two numbers 15 and 20. 
15 < 20 is true.
15 <= 20 is true.
15 > 20 is false. 
15 >= 20 is false. 
15 == 20 is false. 
15 != 20 is true.*/
public class RelationjasonRandomNumbers {
    public static void main(String[] args) {
        Random na=new Random();//defining the Random class
        int num1 = na.nextInt(1000);//genrates random number 1-100
        int num2 = na.nextInt(1000);

        System.out.println(num1 + " < " + num2 + " is " + (num1 < num2));
        System.out.println(num1 + " <= " + num2 + " is " + (num1 <= num2));
        System.out.println(num1 + " > " + num2 + " is " + (num1 > num2));
        System.out.println(num1 + " >= " + num2 + " is " + (num1 >= num2));
        System.out.println(num1 + " == " + num2 + " is " + (num1 == num2));
        System.out.println(num1 + " != " + num2 + " is " + (num1 != num2));
    }
}