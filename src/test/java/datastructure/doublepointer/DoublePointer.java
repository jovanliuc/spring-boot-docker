package datastructure.doublepointer;

public class DoublePointer {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        reverseNumArr(nums);
        traverseNumArr(nums);
    }

    private static void traverseNumArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private static int[] reverseNumArr(int[] nums) {

        int i = 0;
        int j = nums.length - 1;

        for (; i < j ;) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i ++;
            j --;
        }

        return nums;
    }
}
