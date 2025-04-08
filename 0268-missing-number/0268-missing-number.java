class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        HashMap<Integer, Integer> map1 = new HashMap<>();
        int n = nums.length;
        
        for (int i = 0; i <= n; i++) {
            map1.put(i, 0);
            // System.out.println(map1);
        }
        
        for (int i = 0; i < n; i++) {
            map1.replace(nums[i], 1);
            // System.out.println(map1);
        }
        
        for (int key: map1.keySet()) {
            if (map1.get(key) == 0) {
                return key;
            }
            // else {
            //     return n;
            // }
        }

        return 0;
    }
}