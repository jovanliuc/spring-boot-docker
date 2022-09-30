package leetcode.question0004;

public class Solution {

    public static void main(String[] args) {

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthOfNums1 = nums1.length;
        int lengthOfNums2 = nums2.length;

        if (lengthOfNums1 > lengthOfNums2) {
            findMedianSortedArrays(nums2, nums1);
        }

        if (lengthOfNums1 == 0) {
            return ((double) nums2[(lengthOfNums2 - 1) / 2] + (double) nums2[lengthOfNums2 / 2]) / 2;
        }

        int totalLength = lengthOfNums1 + lengthOfNums2;
        int startOfNums1 = 0;
        int endOfNums1 = lengthOfNums1;
        int midOfNums1;
        int midOfNums2;

        while (startOfNums1 <= endOfNums1) {
            midOfNums1 = startOfNums1 + (endOfNums1 - startOfNums1) / 2;
            midOfNums2 = (totalLength + 1) / 2 - midOfNums1;
            double left1 = midOfNums1 == 0 ? Integer.MIN_VALUE : nums1[midOfNums1 - 1];
            double left2 = midOfNums2 == 0 ? Integer.MIN_VALUE : nums2[midOfNums2 - 1];
            double right1 = midOfNums1 == lengthOfNums1 ? Integer.MAX_VALUE : nums1[midOfNums1];
            double right2 = midOfNums2 == lengthOfNums2 ? Integer.MAX_VALUE : nums2[midOfNums2];

            if (left1 > right2) {
                endOfNums1 = midOfNums1 - 1;
            } else if (left2 > right1) {
                startOfNums1 = midOfNums1 + 1;
            } else {
                if (totalLength % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2;
                } else {
                    return Math.max(left1, left2);
                }
            }
        }
        return -1;
    }
}
