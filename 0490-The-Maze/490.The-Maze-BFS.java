import java.util.LinkedList;

class Solution {
    int m, n;
    int[][] dirs;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return false;

        m = maze.length;
        n = maze[0].length;
        dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //Left Down Right Up

        //BFS solution
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start[0], start[1]});
        maze[start[0]][start[1]] = -1;
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] dir: dirs) {
                int i = curr[0];
                int j = curr[1];

                while(i >= 0 && j>= 0 && i < m && j < n && maze[i][j] != 1) {
                    i = i + dir[0];
                    j = j + dir[1];
                }
                i = i - dir[0];
                j = j - dir[1];

                if (maze[i][j] == 0) {
                    if (i == destination[0] && j == destination[1]) {
                        return true;
                    }
                    maze[i][j] = -1;
                    q.add(new int[] {i, j});
                }
            }
        }

        return false;
    }
}