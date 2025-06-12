import java.util.Arrays;

public class QuickSort {
          public static void main(String[] args){
                    int arr[]={10,9,8,7,6,5,4,3,2,1};
                    quickSort(arr,0,arr.length-1);
                    System.out.println(Arrays.toString(arr));


          }
          static void quickSort(int[] nums,int start,int high){
                    if(start>=high) return;
                    int s=start;
                    int e=high;
                    int mid=s+(e-s)/2;
                    int pivot=nums[mid];
                    
                    while(s<=e){

                    while(nums[s]<pivot){
                              s++;
                    }
                    while(nums[e]>pivot){
                              e--;
                    }

                    if(s<=e){
                              int temp=nums[s];
                              nums[s]=nums[e];
                              nums[e]=temp;
                              s++;
                              e--;
                    }

                    }

                    quickSort(nums,start,e);


                    quickSort(nums,s,high);


          }
          
}
