package Patterns;
import java.util.Scanner;


public class SquareNumMat {
          public static void main(String[] args){
                    Scanner s=new Scanner(System.in);
                    int n=s.nextInt();
                    
                    for(int i=1;i<=2*n-1;i++){
                              for(int j=1;j<=2*n-1;j++){
                                        //distance between and key;
                                        int top=i;
                                        int left=j;
                                        int right=(2*n)-j;
                                        int down=(2*n)-i;
                                        int a=Math.min(Math.min(top,left),Math.min(right,down));
                                        System.out.print(n-a+1);

                              }
                              System.out.println();
                    }
                    

          }
          
}
// Input Fo bb b bb   rmat: N = 3
// Result: 
// 3 3 3 3 3 
// 3 2 2 2 3 
// 3 2 1 2 3 
// 3 2 2 2 3 
// 3 3 3 3 3

// Input Format: N = 6
// Result:   
// 6 6 6 6 6 6 6 6 6 6 6 
// 6 5 5 5 5 5 5 5 5 5 6 
// 6 5 4 4 4 4 4 4 4 5 6 
// 6 5 4 3 3 3 3 3 4 5 6 
// 6 5 4 3 2 2 2 3 4 5 6      
// 6 5 4 3 2 1 2 3 4 5 6 
// 6 5 4 3 2 2 2 3 4 5 6 
// 6 5 4 3 3 3 3 3 4 5 6 
// 6 5 4 4 4 4 4 4 4 5 6 
// 6 5 5 5 5 5 5 5 5 5 6 
// 6 6 6 6 6 6 6 6 6 6 6