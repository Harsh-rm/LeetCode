class Solution {
    int[][] dirs;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0 || image[sr][sc] == color) return image;

        dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int startColor = image[sr][sc];
        int m = image.length;
        int n = image[0].length;

        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        rows.add(sr);
        cols.add(sc);

        image[sr][sc] = color;

        while (!rows.isEmpty()) {
            int currRow = rows.poll();
            int currCol = cols.poll();

            for (int[] dir: dirs) {
                int nr = dir[0] + currRow;
                int nc = dir[1] + currCol;

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == startColor) {
                    image[nr][nc] = color;
                    rows.add(nr);
                    cols.add(nc);
                }
            }
        }

        return image;
    }
}