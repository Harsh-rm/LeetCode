class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int count = 0;
        ArrayList<int[]> result = new ArrayList<>();
        ArrayList<Integer> rSum = new ArrayList<>();
        rSum.add(0);

        for (int i = 0; i < nums.length; i++) {
            rSum.add(rSum.get(i) + nums[i]);
        }
        
        //System.out.println(rSum);

        for (int i = nums.length; i >= 0; i--) {
            int diff = rSum.get(i) - k;

            for (int j = i - 1; j >= 0; j--) {
                if (rSum.get(j) == diff) {
                    //int subArray = Arrays.copyOfRange(nums, j , i);                   
                    //result.add(subArray);
                    count++;                    
                }
            }
        }
    /*
        for (int[] subArray : result) {
            System.out.println(Arrays.toString(subArray));
        }
    */
        return count;
    }
}