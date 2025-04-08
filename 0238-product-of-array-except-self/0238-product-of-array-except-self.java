/*
    Leetcode problem 238: Product of Array Except Self 
    T.C: O(n) - O(n + n) :: S.C: O(1) - an Output array is expected

    Solved using running product; First look into brute force 
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[] {};

        int n = nums.length;
        //int rProduct = 1;
        int[] result = new int[n];
        int lp = 1, rp = 1, l = 1, r = n - 2;

        result[0] = lp;
        result[n - 1] = rp;

        while (l < n && r >= 0) {

            if (l == r) {
                result[l] = (nums[l - 1] * lp) * (nums[r + 1] * rp);
                lp = nums[l - 1] * lp;
                rp = nums[r + 1] * rp;
            } 
            else if (l > r) {
                result[l] *= nums[l - 1] * lp;
                result[r] *= nums[r + 1] * rp;
                lp = nums[l - 1] * lp;
                rp = nums[r + 1] * rp;
            }            
            else {
                result[l] = nums[l - 1] * lp;
                result[r] = nums[r + 1] * rp;
                lp = nums[l - 1] * lp;
                rp = nums[r + 1] * rp;
            }

            l++; r--;
        }

/*
        result[0] = rProduct;

        for (int i = 1; i < n; i++) {
            rProduct *= nums[i - 1];
            result[i] = rProduct;
        }

        rProduct = 1;

        for (int i = n - 2; i >= 0; i--) {
            rProduct *= nums[i + 1];
            result[i] *= rProduct;
        }
*/

        return result;
    }
}