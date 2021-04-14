package problem200To300;

public class a208Trie {


    public static class Trie {

        boolean isWord;
        Trie[] tries;
        char ch;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            tries = new Trie[26];
            isWord = false;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            char[] arr = word.toCharArray();
            insert(arr, 0);
        }

        public void insert(char[] arr, int i) {
            if (i == arr.length) {
                isWord = true;
                return;
            }
            if (tries[arr[i] - 'a'] == null) {
                tries[arr[i] - 'a'] = new Trie();
            }
            Trie trie = tries[arr[i] - 'a'];
            ch = arr[i];
            trie.insert(arr, i + 1);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            char[] arr = word.toCharArray();
            return search(arr, 0);
        }

        public boolean search(char[] arr, int i) {
            if (i == arr.length) {
                return isWord;
            }
            if (tries[arr[i] - 'a'] == null) {
                return false;
            }
            Trie trie = tries[arr[i] - 'a'];
            return trie.search(arr, i + 1);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            char[] arr = prefix.toCharArray();
            return startsWith(arr, 0);
        }

        public boolean startsWith(char[] arr, int i) {
            if (i == arr.length) return true;
            if (tries[arr[i] - 'a'] == null) {
                return false;
            }
            Trie trie = tries[arr[i] - 'a'];
            return trie.startsWith(arr, i + 1);
        }
    }


}
