class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0 || k == 0) return new ArrayList<>();

        int n = arr.length;
        int low = 0;
        int high = n - k;
        List<Integer> result = new ArrayList<>();

        while (low < high) {
            int mid = low + (high - low) / 2;

            int distStart = x - arr[mid];
            int distEnd = arr[mid + k] - x;

            if (distStart > distEnd) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}