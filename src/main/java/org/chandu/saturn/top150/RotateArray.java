package org.chandu.saturn.top150;

import java.util.Arrays;


/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 **/
public class RotateArray {

    public static void main(String[] args) {
        int[] test1 = new int[]{1, 2, 3, 4, 5, 6, 7};

        int k = 3;
        int n = test1.length;
        k %= n;

        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(test1, 0, n - 1);
        rotateArray.rotate(test1, 0, k - 1);
        rotateArray.rotate(test1, k, n - 1);

        Arrays.stream(test1).forEach(System.out::println);
    }

    public void rotate(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
