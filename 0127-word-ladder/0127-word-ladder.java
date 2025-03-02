class Solution {
    private AtomicInteger result;
    private boolean found;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        result = new AtomicInteger(0);
        found = false;

        Set<String> wordSet = new HashSet<>(wordList);

        if (beginWord == null || beginWord.length() == 0 || !wordSet.contains(endWord)) {
            return result.get();
        }

        Queue<String> bfs = new LinkedList<>();

        bfs.add(beginWord);
        result.getAndIncrement();

        while (!bfs.isEmpty()) {
            int size = bfs.size();

            IntStream.range(0, size).forEach(i -> {
                String curr = bfs.poll();

                if (curr.equals(endWord) || found) {
                    found = true;
                    return;
                }                

                IntStream.range(0, curr.length()).forEach( j -> {
                    char[] temp = curr.toCharArray();

                    IntStream.rangeClosed('a', 'z').forEach(c -> {
                        if (temp[j] == (char) c) return;

                        temp[j] = (char) c;

                        String newStr = new String(temp);                        
                        
                        if (wordSet.contains(newStr)) {
                            bfs.add(newStr);
                            wordSet.remove(newStr);                            
                        }

                    });
                });
            });

            if (found) break;

            result.getAndIncrement();
        }

        if (found) return result.get();

        return 0;
    }
}