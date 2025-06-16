class Solution {
    public void rotate(int[] nums, int k) {
                int len = nums.length;
        k = k % len;  // Normalize k

        // Step 1: Copy last k elements
        int[] temp = Arrays.copyOfRange(nums, len - k, len);

        // Step 2: Shift remaining elements to the right
        for (int i = len - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        // Step 3: Copy temp[] to the front
        for (int j = 0; j < k; j++) {
            nums[j] = temp[j];
        }

    }
        
    }