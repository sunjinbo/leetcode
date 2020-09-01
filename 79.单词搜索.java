/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null) return false;
        if (board.length == 0) return false;
        if (board[0].length == 0) return false;
        if (word == null) return false;
        if (word.length() == 0) return false;

        int width = board[0].length;
        int height = board.length;
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                if (board[j][i] == word.charAt(0)) {
                    boolean[][] marked = new boolean[height][width];
                    if (dfs(board, width, height, i, j, marked, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int width, int height, int x, int y, boolean[][] marked, String word, int start) {
        if (start == word.length() - 1 && board[y][x] == word.charAt(start)) {
            return true; // 已经找到整个单词，直接返回true
        }

        if (board[y][x] == word.charAt(start)) { // 单词字母匹配，继续匹配下一个字母
            marked[y][x] = true;

            // 基于x,y位置，向上匹配
            if (isInArea(width, height, x, y - 1) && !isMarked(marked, x, y - 1)) {
                if (dfs(board, width, height, x, y - 1, marked, word, start + 1)) {
                    return true;
                }
            }

            // 基于x,y位置，向下匹配
            if (isInArea(width, height, x, y + 1) && !isMarked(marked, x, y + 1)) {
                if (dfs(board, width, height, x, y + 1, marked, word, start + 1)) {
                    return true;
                }
            }

            // 基于x,y位置，向左匹配
            if (isInArea(width, height, x - 1, y) && !isMarked(marked, x - 1, y)) {
                if (dfs(board, width, height, x - 1, y, marked, word, start + 1)) {
                    return true;
                }
            }

            // 基于x,y位置，向右匹配
            if (isInArea(width, height, x + 1, y) && !isMarked(marked, x + 1, y)) {
                if (dfs(board, width, height, x + 1, y, marked, word, start + 1)) {
                    return true;
                }
            }

            marked[y][x] = false;
        }

        return false;
    }

    private boolean isMarked(boolean[][] marked, int x, int y) {
        return marked[y][x];
    }

    private boolean isInArea(int width, int height, int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return true;
        }
        return false;
    }
}
// @lc code=end

