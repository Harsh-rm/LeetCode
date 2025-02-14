class Solution {
    public int findKthLargest(int[] nums, int k) {
        // int temp = 
        // int[] sorted;
        // for (int i = 0; i < nums.length; i++) {
        //     if (temp < nums[i+1]) {
        //         temp = nums[i+1];
        //     }
        // }
        // System.out.println(temp);
        // return temp;
        
        Arrays.sort(nums);
        
        return nums[nums.length - k];
    }
}