/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int x = 0, y = 0;
        int dir = 0;
        int max_distance = 0;

        for (int i = 0; i < commands.length; ++i) {
            switch (commands[i]) {
                case -2: // 向左转 90 度
                    dir -= 1;
                    if (dir < 0) {
                        dir = 3;
                    }
                    break;
                case -1: // 向右转 90 度
                    dir += 1;
                    if (dir >= 4) {
                        dir = 0;
                    }
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    for (int j = 0; j < commands[i]; ++j) {
                        int nextX = x + dx[dir];
                        int nextY = y + dy[dir];
                        if (!isObstacles(nextX, nextY, obstacles)) {
                            x = nextX;
                            y = nextY;
                            max_distance = Math.max(max_distance, x * x + y * y);
                        } else {
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        return max_distance;
    }

    boolean isObstacles(int nextX, int nextY, int[][] obstacles) {
        for (int i = 0; i < obstacles.length; ++i) {
            if (obstacles[i][0] == nextX && obstacles[i][1] == nextY) {
                return true;
            }
        }
        
        return false;
    }
}
// @lc code=end

