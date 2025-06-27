class Solution {

    private int[] result;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //HashMap -> Map dependencies
        //Create an in-degree array 
        //Process independent elements in a Queue
        //Update the in-degree array as you pop from Queue

        try {
            if (numCourses == 0) return new int[] {};

            if (prerequisites.length == 0 || prerequisites == null) {
                return IntStream.range(0, numCourses).toArray();
            }

            result = new int[numCourses];

            Map<Integer, List<Integer>> dependencies = new HashMap<>();

            int[] inDegree = new int[numCourses];            

            Queue<Integer> bfs = new LinkedList<>();

            for (int i = 0; i < prerequisites.length; i++) {
                
                List<Integer> li = dependencies.getOrDefault(prerequisites[i][1], new ArrayList<>());
                li.add(prerequisites[i][0]);

                dependencies.put(prerequisites[i][1], li);

                inDegree[prerequisites[i][0]] += 1;
            }

            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    bfs.add(i);
                }
            }

            int i = 0;
            while (!bfs.isEmpty()) {
                int course = bfs.poll();

                result[i] = course;

                if (dependencies.containsKey(course)) {
                    for (int courses: dependencies.get(course)) {
                        inDegree[courses]--;

                        if (inDegree[courses] == 0) {
                            bfs.add(courses);
                        }
                    }
                }

                i++;
            }

            if (i == numCourses) {
                return result;
            }

            return new int[0];
            
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());            
        }

        return result;
    }
}