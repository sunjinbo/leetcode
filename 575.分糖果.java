/*
 * @lc app=leetcode.cn id=575 lang=java
 *
 * [575] 分糖果
 */

// @lc code=start
class Solution {
    public int distributeCandies(int[] candyType) {
        HashMap<Integer, Integer> hashMap = new HashMap();

        for (int i = 0; i < candyType.length; ++i) {
            int cnt = 1;
            if (hashMap.containsKey(candyType[i])) {
                cnt = hashMap.get(candyType[i]) + 1;
            }
            hashMap.put(candyType[i], cnt);
        }

        int cnt = 0;
        for (int key : hashMap.keySet()) {
            cnt += 1;
        }

        return Math.min(cnt, candyType.length / 2);
    }
}
// @lc code=end

