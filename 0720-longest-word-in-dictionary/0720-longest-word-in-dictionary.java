class Solution {

    public class Trie {
        Trie[] children;
        String word;

        public Trie() {
            children = new Trie[26];            
        }

        public void insert(String word) {
            Trie curr = this;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Trie();
                }

                curr = curr.children[c - 'a'];
            }

            curr.word = word;
        }
    }

    public String longestWord(String[] words) {
        if (words == null || words.length == 0) return "";

        Trie root = new Trie();
        
        for (String word: words) {
            root.insert(word);
        }

        //Start BFS sloution on the Trie
        Queue<Trie> q = new LinkedList<>();
        q.add(root);
        Trie curr = new Trie();

        while(!q.isEmpty()) {
            curr = q.poll();

            for (int i = 25; i >= 0; i--) {
                if (curr.children[i] != null && curr.children[i].word != null) {
                    q.add(curr.children[i]);
                }
            }
        }

        if (curr.word == null) return "";

        return curr.word;
    }
}