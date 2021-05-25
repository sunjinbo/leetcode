/*
 * @lc app=leetcode.cn id=657 lang=java
 *
 * [657] 机器人能否返回原点
 */

// @lc code=start
class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < moves.length(); ++i) {
            switch (moves.charAt(i)) {
                case 'U':
                    y -= 1;
                    break;
                case 'D':
                    y += 1;
                    break;
                case 'L':
                    x -= 1;
                    break;
                case 'R':
                    x += 1;
                    break;
                default:
                    break;
            }
        }

        return ((x == 0) && (y == 0));
    }
}
// @lc code=end

