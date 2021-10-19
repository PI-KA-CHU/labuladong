package com.labuladong.剑指Offer.回溯;

public class 剑指Offer12_矩阵中的路径 {

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || word.charAt(k) != board[i][j]) {
            return false;
        }

        if (k == word.length() - 1) return true;
        //将访问过的元素位标为无效字符，防止重复访问
        board[i][j] = '\0';
        boolean res = dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = word.charAt(k);

        return res;
    }

}
