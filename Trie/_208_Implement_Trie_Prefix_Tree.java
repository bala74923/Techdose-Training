package Trie;

public class _208_Implement_Trie_Prefix_Tree {
    // my java implementation of trie
    class Trie {
        Trie[] arr;
        int we, pc;
        public Trie() {
            arr = new Trie[26];
            we = pc = 0;
        }

        public void insert(String word) {
            Trie temp = this;
            for(int i=0;i<word.length();i++){
                int ind = word.charAt(i)-'a';
                if(temp.arr[ind]==null)
                    temp.arr[ind] = new Trie();
                temp.pc++; // incrementing prefix count
                temp = temp.arr[ind];
            }
            temp.pc++; // consider full string as prefix to itself
            temp.we ++;
        }

        public boolean search(String word) {
            Trie temp = this;
            for(int i=0;i<word.length();i++){
                int ind = word.charAt(i)-'a';
                if(temp.arr[ind] == null)
                    return false;
                temp = temp.arr[ind];
            }
            return temp.we>0;
        }

        public boolean startsWith(String prefix) {
            Trie temp = this;
            for(int i=0;i<prefix.length();i++){
                int ind = prefix.charAt(i)-'a';
                if(temp.arr[ind] == null)
                    return false;
                temp = temp.arr[ind];
            }
            return temp.pc>0;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
