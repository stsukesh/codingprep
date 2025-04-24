public class SelectionSort {
          public static void main(String[] args) {
              int[] arr = {100, 102, 30, 1, 2};
              selectionSort(arr);
      
              // Print the sorted array
              for (int num : arr) {
                  System.out.print(num + " ");
              }
          }
          public static void selectionSort(int[] arr) {
            for(int i=0;i<arr.length-2;i++){
                int key=i,temp;
                for(int j=i+1;j<arr.length;j++){
                    if(arr[j]<arr[key]){
                        key=j;
    
                    }
    
                }
                temp=arr[key];
            arr[key]=arr[i];
                arr[i]=temp;

            }

              }
          }
    