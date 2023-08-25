class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();

        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);

        int i = 0;
        while (i < n) {
            if (i == 0 || nums[i] != nums[i - 1]) {

                int left = i + 1;
                int right = n - 1;

                while(left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if (sum < 0) {
                        left++;
                    }
                    else if(sum > 0) {
                        right--;
                    }
                    else {
                        List<Integer> triples = Arrays.asList(nums[i], nums[left], nums[right]);
                        result.add(triples);
                        left++;
                        right--;
                        
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
            if (nums[i] > 0) break;
            i++;
        }

        // HashSet<List<Integer>> setOfTriples = new HashSet<>();

        // for(int i = 0; i < n; i++) {
        //     for(int j = i + 1; j < n; j++) {
        //         for(int k = j + 1; k < n; k++) {
        //             int sum = nums[i] + nums[j] + nums[k];
        //             if (sum == 0) {
        //                 List<Integer> checkDuplicates = Arrays.asList(nums[i], nums[j], nums[k]);
        //                 Collections.sort(checkDuplicates);
        //                 if (!setOfTriples.contains(checkDuplicates)) {
        //                     result.add(checkDuplicates);
        //                     setOfTriples.add(checkDuplicates);
        //                 }
        //             }
        //         }
        //     }
        // }

        return result;
    }
}