import java.util.*;
public class matrixAdditon {
          public static void main(String[] args) {
                    Scanner va=new Scanner(System.in);
                    int[][] mat1=new int[2][2];
                    int[][] mat2=new int[2][2];
                   System.out.println("Print elements for array1 2x2");
                    for(int i=0;i<2;i++){
                              for(int j=0;j<2;j++){
                                        mat1[i][j]=va.nextInt();
                              }
                    }
                    for(int i=0;i<2;i++){
                              for(int j=0;j<2;j++){
                             System.out.print(mat1[i][j]+" ");
                              }
                              System.out.println();

                    }

          }
  
}
