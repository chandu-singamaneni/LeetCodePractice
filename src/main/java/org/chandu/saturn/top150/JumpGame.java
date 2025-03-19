package org.chandu.saturn.top150;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * <p>
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 **/

public class JumpGame {

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();

        int[] test1 = new int[]{2, 0, 0};
        System.out.println("True or False :: " + jg.canJump(test1));
    }


    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }


    public boolean canJumpMyApp(int[] nums) {
        int prevZero = -1, i = 0;

        for (int num : nums) {
            if (num == 0) {

                if (nums.length - 1 == i) return true;
                boolean flag = false;
                int l = i;
                while (l > prevZero) {
                    if (nums[l] + l > i) {
                        flag = true;
                        break;
                    }
                    l--;
                }
                if (!flag) return false;
            }
            i++;
        }

        return true;
    }


}
