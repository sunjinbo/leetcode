import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=412 lang=java
 *
 * [412] Fizz Buzz
 */

// @lc code=start
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();

            if (i % 3 == 0) {
                sb.append("Fizz");
            }

            if (i % 5 == 0) {
                sb.append("Buzz");
            }

            if (sb.toString().length() == 0) {
                sb.append(i);
            }

            result.add(sb.toString());
        }

        return result;
    }
}
// @lc code=end

