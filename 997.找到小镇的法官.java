import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=997 lang=java
 *
 * [997] 找到小镇的法官
 */

// @lc code=start
class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return 1;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        boolean[] t = new boolean[n];
        Arrays.fill(t, false);

        for (int i = 0; i < trust.length; ++i) {
            int[] pair = trust[i];
            t[pair[0] - 1] = true;
            if (hashMap.containsKey(pair[1])) {
                hashMap.put(pair[1], hashMap.get(pair[1]) + pair[0]);
            } else {
                hashMap.put(pair[1], pair[0]);
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; ++i) {
            cnt += i;
        }
        
        for (int key = 1; key <= n; ++key) {
            if (hashMap.containsKey(key)) {
                if (hashMap.get(key) >= cnt - key && !t[key - 1]) {
                    return key;
                }
            }
        }

        return -1;
    }
}
// @lc code=end

