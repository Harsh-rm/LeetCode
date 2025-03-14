class Trie {

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        List<String> prefixWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            prefixWord = new ArrayList<>();
        }
    }

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        int n = word.length();
        TrieNode curr = root;

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);

            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            
            curr = curr.children[c - 'a'];
            curr.prefixWord.add(word);
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        boolean flag = false;
        int n = word.length();
        TrieNode curr = root;

        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);

            if (curr.children[c - 'a'] == null) {
                return flag;
            } else {
                curr = curr.children[c - 'a'];
            }
        }

        System.out.println(curr.prefixWord);

        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        boolean flag = false;
        int n = prefix.length();
        TrieNode curr = root;

        for (int i = 0; i < n; i++) {
            char c = prefix.charAt(i);

            if (curr.children[c - 'a'] == null) {
                return flag;
            } else {
                curr = curr.children[c - 'a'];
            }
        }

        flag = true;
        return flag;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */