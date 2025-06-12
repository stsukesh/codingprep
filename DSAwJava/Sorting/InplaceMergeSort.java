import java.util.Arrays;

public class InplaceMergeSort {
           public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;

        mergeSort(arr, start, mid);       // Sort the left half
        mergeSort(arr, mid + 1, end);     // Sort the right half
        merge(arr, start, mid, end);      // Merge both halves
    }

    static void merge(int[] arr, int start, int mid, int end) {
        int[] merged = new int[end - start + 1];

        int i = start;     // Pointer for left half
        int j = mid + 1;   // Pointer for right half
        int k = 0;         // Pointer for merged array

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                merged[k++] = arr[i++];
            } else {
                merged[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            merged[k++] = arr[i++];
        }

        while (j <= end) {
            merged[k++] = arr[j++];
        }

        // Copy back to original array
        for(int l = 0; l < merged.length; l++) {
            arr[start + l] = merged[l];
        }
    }
          
}
