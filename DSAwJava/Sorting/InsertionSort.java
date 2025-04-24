package DSAwJava.Sorting;

public class InsertionSort {
          public static void main(String[] args) {
                    int[] arr = {100, 102, 30, 1, 2};
                    insertionSort(arr);
            
                    // Print the sorted array
                    for (int num : arr) {
                        System.out.print(num + " ");
                    }
                }
                public static void insertionSort(int[] arr) {
                    for(int i=1;i<arr.length;i++){
                              int j=i,temp;
                              while(j>0 && arr[j-1]>arr[j]){
                                        temp=arr[j];
                                        arr[j]=arr[j-1];
                                        arr[j-1]=temp;

                                        j--;
                              }


                    }
                  }
              }


