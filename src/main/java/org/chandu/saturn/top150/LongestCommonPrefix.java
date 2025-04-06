package org.chandu.saturn.top150;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters if it is non-empty.
 **/

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] input = new String[]{"flower", "flow", "flight"};

        System.out.println("Output is - " + lcp.longestCommonPrefix(input));

    }

    public String longestCommonPrefix(String[] strs) {

        String op = "";

        char[] ref = strs[0].toCharArray();

        for (int i = 0; i < ref.length; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || ref[i] != strs[j].toCharArray()[i]) {
                    return strs[0].substring(0, i);
                }
            }

        }
        return String.valueOf(ref);


    }

}
