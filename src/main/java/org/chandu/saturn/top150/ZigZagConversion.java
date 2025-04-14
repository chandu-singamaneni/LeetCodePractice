package org.chandu.saturn.top150;

public class ZigZagConversion {

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        ZigZagConversion zzc = new ZigZagConversion();
        System.out.println("Output :: " + zzc.convert(s, numRows));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        int maxCols = s.length() / 2;
        String[][] mat = new String[numRows][maxCols];

        int col = 0, row = 0;

        boolean goingDown = true, goingUp = false;
        for (char c : s.toCharArray()) {
            mat[row][col] = String.valueOf(c);
            if (row == 0) {
                goingDown = true;
                goingUp = false;
            } else if (row == numRows - 1) {
                goingDown = false;
                goingUp = true;
            }

            if (row < numRows && goingDown) {
                row++;
            } else {
                row--;
                col++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < maxCols; j++) {
                if (mat[i][j] != null) {
                    sb.append(mat[i][j]);
                }
            }
        }

        return sb.toString();
    }

    public String convertAISol(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[curRow].append(c);
            if (curRow == 0) {
                goingDown = true;
            } else if (curRow == numRows - 1) {
                goingDown = false;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}
