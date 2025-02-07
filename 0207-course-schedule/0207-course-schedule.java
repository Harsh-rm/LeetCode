class Solution {
    boolean result;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        result = false;

        if (numCourses == 0) return result;

        //These are the courses that are dependant on other courses and have to be taken prior to others 
        //All sorted in the same list. Note: not index wise sorting rather depandant wise sorting
        int[] topologicalSort = new int[numCourses];

        //This map contains all the prerequisite keys associated with the dependant courses
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            topologicalSort[prerequisites[i][0]]++;

            adjacencyList.computeIfAbsent(prerequisites[i][1], key -> new ArrayList<>()).add(prerequisites[i][0]);
        }

        AtomicInteger coursesCompletedAtomic = new AtomicInteger();
        Queue<Integer> bfs = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (topologicalSort[i] == 0) {
                coursesCompletedAtomic.getAndIncrement();
                bfs.add(i);
            }
        }

        while(!bfs.isEmpty()) {
            int currCourse = bfs.poll();

            Optional.ofNullable(adjacencyList.get(currCourse))

                    .ifPresent(list -> list.forEach(dependantCourse -> {

                        if (--topologicalSort[dependantCourse] == 0) {

                            coursesCompletedAtomic.getAndIncrement();

                            bfs.add(dependantCourse);  

                        }

                    }));
        }

        if (coursesCompletedAtomic.get() == numCourses) {
            result = true;
        }

        return result;
    }
}