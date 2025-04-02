package org.chandu.saturn.top150;

import java.util.HashMap;

public class RomanNumbers {

    public static void main(String[] args) {
        String s = "IXVL";
        RomanNumbers rn = new RomanNumbers();

        System.out.println("Integer value = " + rn.romanToInt(s));
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> romanNums = new HashMap<Character, Integer>();
        populateRomanNums(romanNums);

        char[] chars = s.toCharArray();

        int len = chars.length;
        int ans = 0;

        for (int i = 0; i < len; i++) {
            if (chars[i] == 'I') {
                if (((i + 1) < len) && (chars[i + 1] == 'V' || chars[i + 1] == 'X')) {
                    ans += romanNums.get(chars[i + 1]) - romanNums.get(chars[i]);
                    i++;
                } else {
                    ans += romanNums.get(chars[i]);
                }
            } else if (chars[i] == 'X') {
                if ((i + 1 < len) && (chars[i + 1] == 'L' || chars[i + 1] == 'C')) {
                    ans += romanNums.get(chars[i + 1]) - romanNums.get(chars[i]);
                    i++;
                } else {
                    ans += romanNums.get(chars[i]);
                }
            } else if (chars[i] == 'C') {
                if ((i + 1 < len) && (chars[i + 1] == 'D' || chars[i + 1] == 'M')) {
                    ans += romanNums.get(chars[i + 1]) - romanNums.get(chars[i]);
                    i++;
                } else {
                    ans += romanNums.get(chars[i]);
                }
            } else {
                ans += romanNums.get(chars[i]);
            }
        }

        return ans;
    }

    public void populateRomanNums(HashMap<Character, Integer> romanNums) {
        romanNums.put('I', 1);
        romanNums.put('V', 5);
        romanNums.put('X', 10);
        romanNums.put('L', 50);
        romanNums.put('C', 100);
        romanNums.put('D', 500);
        romanNums.put('M', 1000);
    }

}
