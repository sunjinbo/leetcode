import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1394 lang=java
 *
 * [1394] 找出数组中的幸运数
 */

// @lc code=start
class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; ++i) {
            int cnt = 1;
            if (hashMap.containsKey(arr[i])) {
                cnt = hashMap.get(arr[i]) + 1;
            }
            hashMap.put(arr[i], cnt);
        }

        int ans = -1;
        for (int key : hashMap.keySet()) {
            if (key == hashMap.get(key)) {
                if (key > ans) {
                    ans = key;
                }
            }
        }

        return ans;
    }
}
// @lc code=end

