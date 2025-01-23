class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;
        
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map= new HashMap(); 
            
        for (int[] edge: prerequisites) {
            int in = edge[0];
            int out = edge[1];
            indegrees[in]++;
            if (!map.containsKey(out)) {
                 map.put(out, new ArrayList<>());
            }
            map.get(out).add(in);
        }
        
        int coursesCompleted = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                coursesCompleted++;
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> edges = map.get(curr);
            if (edges != null) {
                for (int edge : edges ) {
                    indegrees[edge]--;
                    if (indegrees[edge] == 0) {
                        coursesCompleted++;
                        q.add(edge);
                    }
                }
            }
        }
        
        return coursesCompleted == numCourses;
    }
}