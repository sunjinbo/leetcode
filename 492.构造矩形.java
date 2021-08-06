/*
 * @lc app=leetcode.cn id=492 lang=java
 *
 * [492] 构造矩形
 */

// @lc code=start
class Solution {
    public int[] constructRectangle(int area) {
        int[] wh = new int[2];

        for (int w = 1; w <= area; ++w) {
            if (area % w == 0) {
                // 能够整除宽w，则计算高h
                int h = area / w;

                if (w <= h) {
                    wh[0] = h;
                    wh[1] = w;
                } else {
                    break;
                }
            }
        }

        return wh;
    }
}
// @lc code=end

