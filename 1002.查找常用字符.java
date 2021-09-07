import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1002 lang=java
 *
 * [1002] 查找常用字符
 */

// @lc code=start
class Solution {
    public List<String> commonChars(String[] words) {
        HashMap<String, int[]> hashMap = new HashMap<>();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            for (int j = 0; j < word.length(); ++j) {
                String ch = word.substring(j, j + 1);
                if (!hashMap.containsKey(ch)) {
                    int[] arr = new int[words.length];
                    Arrays.fill(arr, 0);
                    hashMap.put(ch, arr);
                }
                hashMap.get(ch)[i] = hashMap.get(ch)[i] + 1;
            }
        }

        List<String> ans = new ArrayList<>();
        for (String key : hashMap.keySet()) {
            int[] arr = hashMap.get(key);
            if (arr.length > 0) {
                int min = arr[0];
                for (int i = 1; i < arr.length; ++i) {
                    min = Math.min(min, arr[i]);
                }

                for (int i = 0; i < min; ++i) {
                    ans.add(key);
                }
            }
        }

        return ans;
    }
}
// @lc code=end

