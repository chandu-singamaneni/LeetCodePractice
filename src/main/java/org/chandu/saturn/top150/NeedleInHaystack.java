package org.chandu.saturn.top150;

public class NeedleInHaystack {

    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        NeedleInHaystack ni = new NeedleInHaystack();
        System.out.println("Output - " + ni.strStr(haystack, needle));
        haystack = "aaaaa";
        needle = "bba";
        System.out.println("Output - " + ni.strStr(haystack, needle));
        haystack = "";
        needle = "";
        System.out.println("Output - " + ni.strStr(haystack, needle));
        haystack = "mississippi";
    }

    public int strStr(String haystack, String needle) {
        return haystack.contains(needle) ? haystack.indexOf(needle) : -1;
    }
}
