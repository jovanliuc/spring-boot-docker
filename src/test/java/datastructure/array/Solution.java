package datastructure.array;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        int[] arr = new int[] {1, 2, 3};
        traverse(arr);
    }

    void traverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " -> ");
        }
    }
}
