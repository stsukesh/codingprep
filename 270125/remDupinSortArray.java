import java.util.Arrays; 

public class remDupinSortArray {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4, 4};  //
        
        Solution solution = new Solution();
        int uniqueCount = solution.removeDuplicates(nums);
        
      
        System.out.println("The unique elements in the array: " + Arrays.toString(Arrays.copyOf(nums, uniqueCount)));
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;  // Edge case handling

        int uniqueIndex = 1;  // Tracks unique element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {  //  different from the previous one
                nums[uniqueIndex] = nums[i];  // Place it in the next unique position
                uniqueIndex++;  // Increment the index for the next unique element
            }
        }

        return uniqueIndex;
    }
}
