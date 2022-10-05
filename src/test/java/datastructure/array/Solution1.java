package datastructure.array;

import org.junit.jupiter.api.Test;

public class Solution1 {

    @Test
    void test() {
        int[] arr = new int[] {1, 2, 3};
        traverse(arr, 0);
    }

    void traverse(int[] arr, int i) {
        if (i == arr.length) {
            return;
        }
        System.out.print(arr[i] + " -> ");
        traverse(arr, ++i);
    }
}
