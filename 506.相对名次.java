/*
 * @lc app=leetcode.cn id=506 lang=java
 *
 * [506] 相对名次
 */

// @lc code=start
class Solution {
    public String[] findRelativeRanks(int[] score) {
        List<String> list = new ArrayList();

        for (int i = 0; i < score.length; ++i) {
            int rank = getRank(score[i], score);
            switch (rank) {
                case 1:
                    list.add("Gold Medal");
                    break;
                case 2:
                    list.add("Silver Medal");
                    break;
                case 3:
                    list.add("Bronze Medal");
                    break;
                default:
                    list.add(rank + "");
                    break;
            }
        }

        return list.toArray(new String[list.size()]);
    }

    private int getRank(int s, int[] score) {
        int rank = 0;
        for (int i = 0; i < score.length; ++i) {
            if (score[i] > s) {
                rank++;
            }
        }
        return rank + 1;
    }
}
// @lc code=end

