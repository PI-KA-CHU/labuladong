package com.labuladong.分类.dp;

public class _5_最长回文子串 {


    /**
     * 动态规划
     *
     * 时间：O(n)
     * 空间：O(n)
     */
    public static String longestPalindrome(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];
        int startIndex = 0;
        int endIndex = 0;

        //大方向左序
        for (int j = 0; j < n; j++) {
            //小方向正序
            for (int i = 0; i <= j; i++) {
                // j - i < 2表示字符串长度小于等于2的子串
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1] == 1)) {
                    dp[i][j] = 1;

                    if (j - i > endIndex - startIndex) {
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }
        }

        return s.substring(startIndex, endIndex + 1);

    }


    /**
     * 动态规划
     *
     * 画出dp二维数组图，
     * 可以发现dp[i][j]由dp[i+1][j-1]转移来，如aba由b转移来
     * 为了保证对角的dp先得出值，所以需要采用可以先遍历对角的方式遍历，例如倒序，左序（具体参考labuladong）
     *
     * 时间：O(n^2)
     * 空间：O(n^2)
     */
    public static String longestPalindrome2(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        int startIndex = 0;
        int endIndex = 0;

        // base case
        // 1.单个字母是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // 2.两个相同字母是回文串
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                startIndex = i;
                endIndex = i + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 需要加入i + 1 <= j - 1的条件，该条件下的字串才有意义，否则的话偶数位子串会被刷新为0
                if (s.charAt(i) == s.charAt(j) && i + 1 <= j - 1) {
                    dp[i][j] = dp[i + 1][j - 1];

                    if (endIndex - startIndex < j - i) {
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }

        }

        return s.substring(startIndex, endIndex + 1);
    }

    private static void printfDP(int[][] dp) {
        int n = dp.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String s = "aaaaa";
        System.out.println(longestPalindrome(s));
    }
}
