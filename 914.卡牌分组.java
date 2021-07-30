import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=914 lang=java
 *
 * [914] 卡牌分组
 */

// @lc code=start
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int N = deck.length;
        int[] count = new int[10000];
        for (int c: deck) {
            count[c]++;
        }

        List<Integer> values = new ArrayList<Integer>();
        for (int i = 0; i < 10000; ++i) {
            if (count[i] > 0) {
                values.add(count[i]);
            }
        }

        for (int X = 2; X <= N; ++X) {
            if (N % X == 0) {
                boolean flag = true;
                for (int v: values) {
                    if (v % X != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }

        return false;
    }
}
// @lc code=end

