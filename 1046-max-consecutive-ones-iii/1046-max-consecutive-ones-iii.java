class Solution {

    private int maxResult;

    public int longestOnes(int[] nums, int k) {

        try {
            maxResult = 0;

            if (nums == null || nums.length == 0) return 0;

            int l = 0, r = 0;

            while (r < nums.length) {
                if (nums[r] == 0 && k == 0) {
                    while(nums[l] != 0) {
                        l++;
                    }
                    l++;
                }

                if (nums[r] == 0 && k > 0) {
                    k--;
                }

                maxResult = Math.max(maxResult, (r - l) + 1);

                r++;
            }
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return 0; 
        }

        return maxResult;

    }
}

//0,0,1,1,1,0,0
//| |