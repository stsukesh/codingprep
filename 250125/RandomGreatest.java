import java.util.*;           
//4.Imagine you have two mysterious numbers. Your task is to write a program that 
//reveals which one of them is the bigger one. How will you solve this puzzle?
public class RandomGreatest
 {
          public static void main(String[] args){
                    Random rand= new Random();
                    int a=rand.nextInt(100);
                    int b=rand.nextInt(100);
                    System.out.println("The first randrom number is "+a);
                    System.out.println("The Second randrom number is "+b);
                    if(a>b){
                               System.out.println(a+" is greatest than "+b);
                    }
                    else{
                              System.out.println(b+" is the greatest ");
                    }

          
          }

          
}
