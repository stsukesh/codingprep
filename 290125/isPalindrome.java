import java.util.*;
public class isPalindrome {
public static void main(String args[]){
          Scanner va =new Scanner(System.in);
          String input=va.nextLine();
          String reversed="";
          //System.out.println(input.length());
          for(int i=input.length()-1;i>=0;i--){
                    reversed+=input.charAt(i);
          }
          System.out.println(reversed);
          if(input.equals(reversed)){
                    System.out.println("is a palindrome");
          }
          else{
                    System.out.println("not a palindrome");
          }
          
}
          
}
