import java.util.Scanner;
public class revStrBuilder {
          public static void main(String[] args) {
                    Scanner vangu = new Scanner (System.in);
                    String s= vangu.nextLine();
                    StringBuilder snew = new StringBuilder(s);
                    snew.reverse();
                    s=snew.toString();
                    System.out.println(S);
                  vangu.close();
          }
          
}