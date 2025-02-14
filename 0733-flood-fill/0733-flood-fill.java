class Solution {
    int[][] dirs;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //Base case - Avoid NullPointerException
        if (image == null) return new int[0][0];
        //Check if the rows are empty or if the sc and sc is of color
        if (image.length == 0 || image[sr][sc] == color) return image;

        //Initialize the directions array
        dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        //Calculate the length of rows and cols and take note to the current color to perform Flood fill
        int startColor = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        
        //Create the rows and cols queue to perform the BFS on the image matrix
        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();

        //Add the starting point sr and sc to the queue
        rows.add(sr);
        cols.add(sc);

        //Start the Procedure of Flood Fill - change the color of the first pixel
        image[sr][sc] = color;

        //Start the BFS approach - moving in four direstions UP, RIGHT, DOWN, LEFT
        while (!rows.isEmpty()) {
            int currRow = rows.poll();
            int currCol = cols.poll();

            for (int[] dir: dirs) {
                int nr = dir[0] + currRow;
                int nc = dir[1] + currCol;

                //If you find that the new row and colums' color is the same as first pixel's color then change it
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == startColor) {
                    image[nr][nc] = color;
                    //And record the new row and column in your BFS queue
                    rows.add(nr);
                    cols.add(nc);
                }
            }
        }

        //Finally return the updated image from your flood procedure
        return image;
    }
}