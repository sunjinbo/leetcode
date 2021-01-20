import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 */

// @lc code=start
class Solution {
    private List<List<String>> results = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        Chessboard chessboard = new Chessboard(n);
        backtrack(chessboard, 0);
        return results;
    }

    void backtrack(Chessboard chessboard, int row) {
        if (chessboard.getN() <= row) {
            results.add(chessboard.getResult());
            return;
        }

        for (int col = 0; col < chessboard.getN(); ++col) {
            if (!chessboard.isValidPosition(row, col)) {
                continue;
            }

            chessboard.addQ(row, col);
            backtrack(chessboard, row + 1);
            chessboard.removeQ(row, col);
        }
    }

    class Chessboard {
        private int n;
        private String[][] chessboard;

        public Chessboard(int n) {
            this.n = n;
            chessboard = new String[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    chessboard[i][j] = ".";
                }
            }
        }

        public int getN() {
            return n;
        }

        public void addQ(int row, int col) {
            chessboard[row][col] = "Q";
        }

        public void removeQ(int row, int col) {
            chessboard[row][col] = ".";
        }

        public boolean isValidPosition(int row, int col) {
            // 判断同行和同列上是否已经有Q
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (i == row || j == col) {
                        if (chessboard[i][j] == "Q") {
                            return false;
                        }
                    }
                }
            }

            // 判断斜线上是否已经有Q
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
                if (chessboard[i][j] == "Q") {
                    return false;
                }
            }

            for (int i = row - 1, j = col + 1; i >= 0 && j < n; --i, ++j) {
                if (chessboard[i][j] == "Q") {
                    return false;
                }
            }

            return true;
        }

        public List<String> getResult() {
            List<String> result = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; ++j) {
                    sb.append(chessboard[i][j]);
                }
                result.add(sb.toString());
            }
            return result;
        }
    }
}
// @lc code=end

