package com.labuladong.分类.回溯;

import java.util.List;

public class _79_单词搜索 {

    public static boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtract(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean backtract(char[][] board, int i, int j, String word, int k) {

        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || word.charAt(k) != board[i][j]) {
            return false;
        }

        if (k == word.length() - 1) {
            return true;
        }


        board[i][j] = '\0';
        boolean res = backtract(board, i - 1, j, word, k + 1) || backtract(board, i + 1, j, word, k + 1)
                        || backtract(board, i, j - 1, word, k + 1) || backtract(board, i, j + 1, word, k + 1);
        board[i][j] = word.charAt(k);

        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'C','A','A'}, {'A','A','A'}, {'B','C','D'}};
        String word = "AAB";

        boolean exist = exist(board, word);
        System.out.println(exist);
    }
}
