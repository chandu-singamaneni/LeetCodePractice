package org.chandu.saturn.top150;

import java.util.Arrays;

/**
 * Scenario ::
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 * Example 2:
 * <p>
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 * Example 3:
 * <p>
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 * <p>
 * Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 **/

public class MergeSortedArrays {

    public static void main(String[] args) {

        MergeSortedArrays msa = new MergeSortedArrays();

        int[] test1a = new int[]{1, 2, 3, 0, 0, 0};
        int[] test1b = new int[]{2, 5, 6};
        msa.merge(test1a, 3, test1b, 3);
        System.out.println("Test1 o/p");
        Arrays.stream(test1a).forEach(System.out::println);

        int[] test2a = new int[]{2, 0};
        int[] test2b = new int[]{1};
        msa.merge(test2a, 1, test2b, 1);
        System.out.println("Test2 o/p");
        Arrays.stream(test2a).forEach(System.out::println);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Initialize pointers for nums1, nums2, and the merged array (nums1).
        int i = m - 1; // Pointer for the last element of the valid part of nums1.
        int j = n - 1; // Pointer for the last element of nums2.
        int k = m + n - 1; // Pointer for the last position in the merged nums1.

        // Merge from the end of both arrays.
        while (j >= 0) { // Continue as long as there are elements in nums2.
            if (i >= 0 && nums1[i] > nums2[j]) {
                // If there are elements in nums1 and the current element in nums1 is greater,
                // copy the element from nums1 to the merged position.
                nums1[k] = nums1[i];
                i--; // Move the nums1 pointer to the previous element.
            } else {
                // Otherwise, copy the element from nums2 to the merged position.
                nums1[k] = nums2[j];
                j--; // Move the nums2 pointer to the previous element.
            }
            k--; // Move the merged array pointer to the previous position.
        }
    }

    public void mergeAnotherApproach(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) {
            // Do nothing
            return;
        }

        int[] numsFinal = new int[m + n];
        int i = 0, j = 0;

        while (m + n > 0) {
            if (m == 0) { // When m becomes 0, there might still be elements in nums2 array, hence we need this condition.
                numsFinal[i + j] = nums2[j];
                j++;
                n--;
            } else if (n == 0) { // When n becomes 0, there might still be elements in nums1 array, hence we need this condition.
                numsFinal[i + j] = nums1[i];
                i++;
                m--;
            } else { // If neither m, nor n are 0, compare the lowest and perform necessary computations.
                if (nums1[i] < nums2[j]) {
                    numsFinal[i + j] = nums1[i];
                    i++;
                    m--;
                } else {
                    numsFinal[i + j] = nums2[j];
                    j++;
                    n--;
                }
            }
        }

        // Copy the elements from numsFinal into nums1, as the requirements says, we need the final array in nums1.
        System.arraycopy(numsFinal, 0, nums1, 0, nums1.length);
    }
}
