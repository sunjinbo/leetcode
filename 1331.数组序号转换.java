import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1331 lang=java
 *
 * [1331] 数组序号转换
 */

// @lc code=start
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        int[] ans = Arrays.copyOf(arr, len);
        Arrays.sort(arr);
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int cnt = 1;
        for (int i = 0; i < len; ++i) {
            if (i != 0 && arr[i] != arr[i-1]) {
                cnt += 1;
            }
            hashmap.put(arr[i], cnt);
        }

        for (int i = 0; i < len; ++i) {
            ans[i] = hashmap.get(ans[i]);
        }

        return ans;
    }
}
// @lc code=end

