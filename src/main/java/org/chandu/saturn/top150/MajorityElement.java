package org.chandu.saturn.top150;

import java.util.HashMap;


/**
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 * Example 1:
 * <p>
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 **/
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] test1 = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(me.majorityElement(test1));
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> majElem = new HashMap<>();
        for (int num : nums) {
            majElem.put(num, majElem.getOrDefault(num, 0) + 1);
        }
        return majElem.entrySet().stream().max(HashMap.Entry.comparingByValue()).get().getKey();
    }
}
