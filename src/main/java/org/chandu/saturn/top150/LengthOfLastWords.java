package org.chandu.saturn.top150;

/**
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * <p>
 * A word is a maximal substring consisting of non-space characters only.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 * <p>
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 * <p>
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 **/

public class LengthOfLastWords {

    public static void main(String[] args) {
        LengthOfLastWords lw = new LengthOfLastWords();

        System.out.println("Output - " + lw.lengthOfLastWord("Hello World!"));
    }

    public int lengthOfLastWord(String s) {

        char[] arr = s.toCharArray();

        int counter = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != ' ') {
                if (arr[i - 1] == ' ') counter = 0; // reset counter
                counter++;
            }
        }

        return counter;
    }
}
