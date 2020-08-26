import java.util.Map;

/*
 * @lc app=leetcode.cn id=166 lang=java
 *
 * [166] 分数到小数
 */

// @lc code=start
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        String ans = "";

        long dividend = Math.abs(Long.valueOf(numerator)); // 避免溢出
        long divisor = Math.abs(Long.valueOf(denominator));

        if (numerator < 0 ^ denominator < 0) {
            ans += "-";
        }

        ans += (dividend / divisor);

        long reminder = dividend % divisor;
        if (reminder == 0) {
            return ans;
        }

        ans += ".";

        Map<Long, Integer> map = new HashMap<>();
        while (reminder != 0) {
            if (map.containsKey(reminder)) {
                StringBuilder sb = new StringBuilder(ans);
                sb.insert(map.get(reminder), "(");
                sb.append(")");
                ans = sb.toString();
                break;
            }
            map.put(reminder, ans.length());
            reminder = reminder * 10;
            ans += (reminder / divisor);
            reminder %= divisor;
        }
        return ans;
    }
}
// @lc code=end

