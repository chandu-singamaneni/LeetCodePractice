package org.chandu.saturn.top150;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an input string s, reverse the order of the words.
 * <p>
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 * <p>
 * Return a string of the words in reverse order concatenated by a single space.
 * <p>
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 * <p>
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 * <p>
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.*
 */

public class ReverseWordInString {

    public static void main(String[] args) {
        String s = "  hello world  ";
        ReverseWordInString rws = new ReverseWordInString();

        System.out.println("Output :: " + rws.reverseStringApproach2(s));
    }

    public String reverseStringApproach2(String s) {
        List<String> words = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }

    public String reverseString(@NotNull String s) {

        String[] sArr = s.trim().split("\\s+");

        int start = 0, end = sArr.length - 1;

        while (start < end) {
            String temp = sArr[end];
            sArr[end] = sArr[start];
            sArr[start] = temp;
            start++;
            end--;
        }
        String op = "";
        for (int i = 0; i < sArr.length; i++) {
            op = op.concat(sArr[i]);
            if (i + 1 != sArr.length) {
                op = op.concat(" ");
            }
        }

        return op;
    }


}
