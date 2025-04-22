public class MaxElementi{
          public static void main(String[]args){
                    int[] arr={10,400,30,400,20};
                    int max=arr[0];
                    for(int i=1;i<arr.length;i++){
                              if(max<arr[i])
                                        max=arr[i];
                    
                    }
                    System.out.println("The largest element in array is "+ max);
          }
          
}