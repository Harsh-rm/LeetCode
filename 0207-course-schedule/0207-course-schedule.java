class Solution {
    boolean result;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        result = false;

        if (prerequisites.length == 0) return true;

        int[] tocomplete = new int[numCourses];
        HashMap<Integer, List<Integer>> prereqtotakemap = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            tocomplete[prerequisites[i][0]]++;

            prereqtotakemap.computeIfAbsent(prerequisites[i][1], key -> new ArrayList<>()).add(prerequisites[i][0]);
        }

        AtomicInteger count = new AtomicInteger();
        Queue<Integer> bfs = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (tocomplete[i] == 0) {
                bfs.add(i);
                count.getAndIncrement();
            }
        }

        while(!bfs.isEmpty()) {
            int curr = bfs.poll();

            Optional.ofNullable(prereqtotakemap.get(curr))

                    .ifPresent(list -> list.forEach(course -> {

                        if(--tocomplete[course] == 0) {
                            
                            bfs.add(course);
                            count.getAndIncrement();

                        }

                    }));
        }

        if (numCourses <= count.get()) {
            result = true;
        }

        return result;
    }
}