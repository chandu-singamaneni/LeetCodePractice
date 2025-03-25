package org.chandu.saturn.top150;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 * <p>
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 **/

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] test1 = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        TrappingRainWater trw = new TrappingRainWater();

        System.out.println("Trapped rain water = " + trw.trap(test1));
    }

    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
            right[n - i - 1] = Math.max(right[n - i], height[n - i - 1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }

        return ans;
    }

    public int trapMySol(int[] height) {

        int trapStartPos = 0;
        int waterTrapped = 0;

        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[trapStartPos] && i > trapStartPos + 1) {
                int benchMark = Math.min(height[trapStartPos++], height[i]);
                while (trapStartPos < i) {
                    waterTrapped += benchMark - height[trapStartPos];
                    trapStartPos++;
                }
            } else {
                if (height[i] > height[trapStartPos]) trapStartPos = i;
            }
        }

        trapStartPos = height.length - 1;
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i] >= height[trapStartPos] && i < trapStartPos - 1) {
                int benchMark = Math.min(height[trapStartPos--], height[i]);
                while (trapStartPos > i) {
                    waterTrapped += benchMark - height[trapStartPos];
                    trapStartPos--;
                }
            } else {
                if (height[i] > height[trapStartPos]) trapStartPos = i;
            }
        }

        return waterTrapped;

    }


}
