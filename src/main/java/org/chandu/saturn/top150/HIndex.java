package org.chandu.saturn.top150;

import java.util.Arrays;

/**
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 * Example 2:
 * <p>
 * Input: citations = [1,3,1]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == citations.length
 * 1 <= n <= 5000
 * 0 <= citations[i] <= 1000
 **/
public class HIndex {

    public static void main(String[] args) {
        HIndex hi = new HIndex();
        int[] test1 = new int[]{0, 1, 2, 3, 4, 5};
        System.out.println("H-Index - " + hi.hIndex(test1));
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int h = n; h > 0; --h) {
            if (citations[n - h] >= h) {
                return h;
            }
        }
        return 0;
    }
}
