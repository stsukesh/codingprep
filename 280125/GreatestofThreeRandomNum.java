import java.util.*;
public class GreatestofThreeRandomNum{
          public static void main(String[] args){
                    Random ra = new Random();
                    int a = ra.nextInt(1000);
                    int b = ra.nextInt(1000);
                    int c = ra.nextInt(1000);
                    System.out.println("The three mystrious numbers are: ");

                    System.out.println(a);
                    System.out.println(b);
                    System.out.println(c);


                    if(a>b && a>c){
                              System.out.println(a+" is the greatest among three mysterious numbres");
                    }
                    else if(b>a && b> c){
                              System.out.println(b+" is the greatest among three mysterious numbres");

                    }
                    else{
                              System.out.println(c+" is the greatest among three mysterious numbres");

                    }
          }
}