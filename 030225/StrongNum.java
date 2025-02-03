public class StrongNum {
          public static void main(String[] args) {
                    int n=145,temp=n,rem=0,a=0;
                    while (temp>0){
                              rem=temp%10;
                              a+=factorial(rem);
                              temp/=10;



                    } 

                    if(n==a){
                              System.out.println(a+" is a strong number");
                    }
          }
          static int factorial(int n){
              int fact = 1;
              for (int i = 1; i <= n; i++) {
                  fact *= i;
              }
              return fact;
          }


}
