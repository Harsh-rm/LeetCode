class Solution {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];            
        }

        private void insert (String word) {
            TrieNode curr = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }

                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }
    }

    TrieNode root;

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        if (dictionary == null || dictionary.size() == 0) return sentence;

        for (String word : dictionary) {
            root.insert(word);
        }

        String[] strArray = sentence.split(" ");
        
        StringBuilder resultantSb = new StringBuilder();

        for (int i = 0; i < strArray.length; i++) {
            String word = strArray[i];
            StringBuilder currSb = new StringBuilder();
            TrieNode curr = root;

            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);

                if (curr.children[c - 'a'] != null) {
                    curr = curr.children[c - 'a'];
                    currSb.append(c);

                    if (curr.isEnd == true) {
                        word = currSb.toString();
                        break;
                    }
                } else {
                    break;
                }
            }

            resultantSb.append(word);
            if (i < strArray.length - 1) resultantSb.append(" ");
        }

        return resultantSb.toString();
    }
}