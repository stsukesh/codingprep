package DSAwJava.Sorting;

public class BubbleSort {
          public static void main(String[] args) {
                    int[] arr = {100, 102, 30, 1, 2};
                    BubbleSort(arr);
            
                    // Print the sorted array
                    for (int num : arr) {
                        System.out.print(num + " ");
                    }
                }
                public static void BubbleSort(int[] arr) {
                    int temp;
                    for(int i=arr.length-1;i>=0;i--){
                              for(int j=0;j<=i-1;j++){
                                        if(arr[j]>arr[j+1]){
                                                  temp=arr[j];
                                                  arr[j]=arr[j+1];
                                                  arr[j+1]=temp;
                                        
                                        }
                              }
                    }
                  
              }
          
}
