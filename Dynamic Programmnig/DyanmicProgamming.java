import java.util.*;
public class DyanmicProgamming{
          public static void main(String[] args) {
                    Scanner sc= new Scanner(System.in);
                    int n=10;
                    int[] a =new int[n+1];
                    a[0]=0;
                    a[1]=1;
                    for(int i=2;i<=n;i++)
                     a[i]=a[i-1]+a[i-1];

               System.out.println(a[2]);
                    n=sc.nextInt();
                 
                    System.out.println(a[n]);
sc.close();
                    

          }
}