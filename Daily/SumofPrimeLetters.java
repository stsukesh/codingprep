import java.util.Scanner;
public class SumofPrimeLetters {
          public static void main(String[] args){
                    Scanner van=new Scanner(System.in);
                    String str=van.nextLine();
                    char[] arr=str.toCharArray();
                    int sum=0;
                    for(char ch : arr){
                              if(isPrime(ch)){
                                        sum+=(int)ch;
                                        System.out.print(ch);
                              }
                    }
                    System.out.print(":"+sum);
          }
          public static boolean isPrime(char ch){
                    int n=(int)ch;
                    for(int i=2;i<=n/2;i++){
                              if(n%i==0){
                                        return false;
                              }
                    }
                    return true;
          }         
}
// Prime Chars
// Given a String input1, find the characters whose ascii value is a prime number and generate the result as follows:

// Case 1: When the String contains characters whose ascii value is prime.

// Example 1:
// input1: WIPRO
// output1: IO:152
// Explanation: The ascii value of ‘W’,‘I’,‘P’,‘R’ and ‘O’ are 87,73,80,82 and 79 respectively.
// Out of which 73 and 79 are prime where I and O are the character equivalent of the prime ascii values
// and 152 is the sum of the prime ascii values.

// Example 2:
// input1: Fa8&201tOI
// output1: aOI:249
// Explanation: The ascii values of ‘F’,‘a’,‘8’,‘&’,‘2’,‘0’,‘1’,‘t’,‘O’ and ‘I’ are
// 70,97,56,38,50,48,49,116,79 and 73 respectively.
// Out of which 97 and 79 are prime, where a and O are the character equivalent of the prime ascii values
// and 249 is the sum of the prime ascii values.

// Output format: <concatenate all characters with prime ascii values>:<sum of the prime ascii values>

