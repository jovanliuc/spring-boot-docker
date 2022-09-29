package leetcode.question0088;

class Solution {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,8,0,0,0,0,0};
        int[] nums2 = new int[]{3,5,6,9,11};
        int m = 3;
        int n = 5;

        merge(nums1, m, nums2, n);

        System.out.println(nums1.length);
    }

    // method 1 -> use the methods of jdk
    /*public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }*/

    // method 2 -> which is need to a new int array of size m+n
    /*public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedNums = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m && j < n) {
            mergedNums[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }

        while (i < m) {
            mergedNums[k++] = nums1[i++];
        }

        while (j < n) {
            mergedNums[k++] = nums2[j++];
        }

        return mergedNums;
    }*/

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n -1;

        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] < nums2[j] ? nums2[j--] : nums1[i--];
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
