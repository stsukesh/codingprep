import java.util.*;
public class isPrime{
          public static void main(String args[]){
                    Scanner sc=new Scanner(System.in);
                    int n=sc.nextInt();
                 
                    for(int i=1;i<=n;i++){
                              if(n%i==0){
                                        System.out.println("Not Prime");
                                        break;
                                     
                              }
                              else{
                                        System.out.println("Prime");
                                        break;
                                        
                              }
                    }
                
          }
          
}