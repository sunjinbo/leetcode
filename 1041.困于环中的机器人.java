import java.util.Queue;

/*
 * @lc app=leetcode.cn id=1041 lang=java
 *
 * [1041] 困于环中的机器人
 */

// @lc code=start
class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int dx = 0;
        int dy = 1;

        while(true) {
            for (int i = 0; i < instructions.length(); ++i) {
                switch (instructions.charAt(i)) {
                    case 'G': // 前进直走 1 个单位
                        x += dx;
                        y += dy;
                        break;
                    case 'L': // 左转 90 度
                        if (dx == 0 && dy == 1) { // 向北
                            dx = -1;
                            dy = 0;
                        } else if (dx == -1 && dy == 0) { // 向西
                            dx = 0;
                            dy = -1;
                        } else if (dx == 0 && dy == -1) { // 向南
                            dx = 1;
                            dy = 0;
                        } else if (dx == 1 && dy == 0) { // 向东
                            dx = 0;
                            dy = 1;
                        }
                        break;
                    case 'R': // 右转 90 度
                        if (dx == 0 && dy == 1) { // 向北
                            dx = 1;
                            dy = 0;
                        } else if (dx == -1 && dy == 0) { // 向西
                            dx = 0;
                            dy = 1;
                        } else if (dx == 0 && dy == -1) { // 向南
                            dx = -1;
                            dy = 0;
                        } else if (dx == 1 && dy == 0) { // 向东
                            dx = 0;
                            dy = -1;
                        }
                        break;
                }
            }

            // 一次指令之后，只有(x,y)不是原点，并且方向和原来的方向一致，最后才回不去
            if (x == 0 && y == 0) {
                return true;
            }

            if (dx == 0 && dy == 1) {
                return false;
            }
        }
    }
}
// @lc code=end

