class Solution {
    private int[][] dirs;
    private int m, n;
    private int startColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null) return new int[0][0];

        if (image.length == 0 || image[sr][sc] == color) return image;

        dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        m = image.length;
        n = image[0].length;

        startColor = image[sr][sc];

        helper(image, sr, sc, color);

        return image;
    }

    private void helper(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return;

        image[sr][sc] = color;

        for (int[] dir: dirs) {
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;            

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == startColor) {                
                helper(image, nr, nc, color);
            }
        }
    }
}