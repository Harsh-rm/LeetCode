class Solution {

    public class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];        
        }

        public void insert(String word) {
            TrieNode curr = this;

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
        if (dictionary == null || dictionary.size() == 0 || sentence.length() == 0) return sentence;

        for (String word: dictionary) {
            root.insert(word);
        }

        StringBuilder resultantSentence = new StringBuilder();
        String[] sentenceAsArray = sentence.split(" ");        

        for (int i = 0; i < sentenceAsArray.length; i++) {
            String word = sentenceAsArray[i];
            StringBuilder currWord = new StringBuilder();
            TrieNode curr = root;

            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);

                if (curr.children[c - 'a'] != null) {                    
                    curr = curr.children[c - 'a'];
                    currWord.append(c);

                    if (curr.isEnd == true) {
                        word = currWord.toString();
                        break;
                    }
                } else {
                    break;
                }
            }

            resultantSentence.append(word);
            if (i < sentenceAsArray.length - 1) resultantSentence.append(" ");
        }

        return resultantSentence.toString();
    }
}