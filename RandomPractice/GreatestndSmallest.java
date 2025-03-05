public class GreatestndSmallest {
          public static void main(String[] args) {
              int[] arr1 = {10, 50, 20, 40, 80};
              int max = arr1[0],min=arr1[0];// Start with the first element as the max
      
              for (int i = 1; i < arr1.length; i++) { // Start from index 1
                  if (arr1[i] > max) { // Compare the current element with max
                      max = arr1[i]; // Update max if the current element is larger
                  }
                  if(arr1[i]<min){
                    min=arr1[i];
                  }
              }
      
              // Output the greatest value
              System.out.println("Maximum value: " + max);
              System.out.println(min);
          }
      }
      