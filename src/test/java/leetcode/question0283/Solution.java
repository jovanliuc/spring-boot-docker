package leetcode.question0283;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        moveZeroes(null);
    }

    public void moveZeroes(int[] nums) {
        int index = removeElement(nums, 0);
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }

    private int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }
}
