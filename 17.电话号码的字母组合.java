import java.awt.List;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        for (int i = 0; i < digits.length(); ++i) {
            Integer digit = Integer.parseInt(digits.charAt(i) + "");
            if (map.containsKey(digit)) {
                String keys = map.get(digit);
                List<String> temp = new ArrayList<>();
                for (int j = 0; j < keys.length(); ++j) {
                    if (result.size() == 0) {
                        temp.add(keys.charAt(j) + "");
                    } else {
                        for (int n = 0; n < result.size(); ++n) {
                            temp.add(result.get(n) + keys.charAt(j));
                        }
                    }
                }
                result.clear();
                result.addAll(temp);
            }
        }

        return result;
    }
}
// @lc code=end

