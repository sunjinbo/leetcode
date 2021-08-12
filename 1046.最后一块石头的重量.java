import java.util.List;

/*
 * @lc app=leetcode.cn id=1046 lang=java
 *
 * [1046] 最后一块石头的重量
 */

// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < stones.length; ++i) {
            list.add(stones[i]);
        }

        step(list);

        return list.size() > 0 ? list.get(0) : 0;
    }

    void step(List<Integer> input) {
        if (input.size() <= 1) {
            return;
        }

        // input列表内元素肯定大于等于2
        // 找寻input列表中最大的两个数字
        int index = getMaxIndex(input);
        int max1 = input.get(index);
        input.remove(index);

        index = getMaxIndex(input);
        int max2 = input.get(index);
        input.remove(index);

        if (max1 != max2) {
            int stone = Math.max(max1, max2) - Math.min(max1, max2);
            input.add(stone);
        }

        step(input);
    }

    int getMaxIndex(List<Integer> input) {
        int maxIndex = 0;
        for (int i = 1; i < input.size(); ++i) {
            if (input.get(i) > input.get(maxIndex)) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
// @lc code=end

