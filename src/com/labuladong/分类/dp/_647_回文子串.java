package com.labuladong.分类.dp;

public class _647_回文子串 {


    /**
     * 推荐
     * 动态规划
     *
     * 时间：O(n^2)
     * 空间：O(n^2)
     */
    public static int countSubstrings1(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];
        int ans = 0;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1] == 1)) {
                    dp[i][j] = 1;
                    ans++;
                }
            }
        }

        return ans;
    }

    public static int countSubstrings2(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        int ans = 0;

        // base case
        // 1.单个字母是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            ans ++;
        }

        // 2.两个相同字母是回文串
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                ans++;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && i + 1 <= j - 1) {
                    dp[i][j] = dp[i + 1][j - 1];

                    if (dp[i][j] == 1) {
                        ans ++;
                    }
                }
            }

        }

        return ans;
    }


    private void printfDP(int[][] dp) {
        int n = dp.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
