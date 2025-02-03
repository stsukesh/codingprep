public class armstrongNum{
          public static void main(String[] args) {
                    int n=153,temp=n;
                    int rem=0,sum=0;


                    while(temp>0){
                             rem=temp%10;
                             sum+=Math.pow(rem,3);
                             temp=temp/10;
                    }
                    if(n==sum){
                              System.out.println(n+" is a armstrong number");
                    }
                    else{
                              System.out.println(n+" is not a armstrong number");      
                    }
                    
          }

}