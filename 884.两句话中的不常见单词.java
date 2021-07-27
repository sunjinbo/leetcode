import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode.cn id=884 lang=java
 *
 * [884] 两句话中的不常见单词
 */

// @lc code=start
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] split1 = s1.split(" ");
        String[] split2 = s2.split(" ");

        HashMap<String, Integer> hashMap1 = getHashMap(split1);
        HashMap<String, Integer> hashMap2 = getHashMap(split2);

        List<String> result = new ArrayList<String>();

        for (String key : hashMap1.keySet()) {
            if (hashMap1.get(key) < 2) {
                if (!hashMap2.containsKey(key)) {
                    result.add(key);
                }
            }
        }

        for (String key : hashMap2.keySet()) {
            if (hashMap2.get(key) < 2) {
                if (!hashMap1.containsKey(key)) {
                    result.add(key);
                }
            }
        }

        String[] resultArray = new String[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    public HashMap<String, Integer> getHashMap(String[] words) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            Integer count = 1;
            String key = words[i];
            if (hashMap.containsKey(key)) {
                count = hashMap.get(key) + 1;
                hashMap.remove(key);
            }
            hashMap.put(key, count);
        }
        return hashMap;
    }
}
// @lc code=end
