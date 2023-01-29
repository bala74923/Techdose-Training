package _15_Trie;

public class _1804_Implement_Trie_II_Prefix_Tree {
    // my java implementation of trie
    class Trie {
        int we,pc;
        Trie[] arr;
        public Trie() {
            we = pc = 0;
            arr = new Trie[26];
        }

        public void insert(String word) {
            Trie temp = this;
            for(int i=0;i<word.length();i++){
                int ind = word.charAt(i)-'a';
                if(temp.arr[ind]==null)
                    temp.arr[ind]  = new Trie();
                temp.pc ++;
                temp = temp.arr[ind];
            }
            temp.we++;temp.pc++;

        }

        public int countWordsEqualTo(String word) {
            Trie temp = this;
            for(int i=0;i<word.length();i++){
                int ind = word.charAt(i)-'a';
                if(temp.arr[ind]==null)
                    return 0;
                temp = temp.arr[ind];
            }
            return temp.we;
        }

        public int countWordsStartingWith(String prefix) {
            Trie temp = this;
            for(int i=0;i<prefix.length();i++){
                int ind = prefix.charAt(i)-'a';
                if(temp.arr[ind] == null)
                    return 0;
                temp = temp.arr[ind];
            }
            return temp.pc;
        }
        // considering word always exist , if doubt means use search then erase
        public void erase(String word) {
            Trie temp = this;
            for(int i=0;i<word.length();i++){
                int ind = word.charAt(i)-'a';
                if(temp.arr[ind] == null)
                    return;
                temp.pc--;
                temp = temp.arr[ind];
            }
            temp.we--;
            temp.pc--;
        }

    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
}
