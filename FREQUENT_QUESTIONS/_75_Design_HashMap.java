package FREQUENT_QUESTIONS;

import java.util.Arrays;

public class _75_Design_HashMap {
        int[] map;
        public _75_Design_HashMap() {
            map = new int[(int)1e7+1];
            Arrays.fill(map,-1);
        }

        public void put(int key, int value) {
            map[key] = value;
        }

        public int get(int key) {
            return map[key];
        }

        public void remove(int key) {
            map[key]= -1;
        }
}
