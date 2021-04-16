/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 */

// @lc code=start
class Solution {
    public boolean buddyStrings(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();

        //如果俩字符串长度不同，或者字符串长度小于2
        if (lenA != lenB || lenA < 2 || lenB < 2)
            return false;

        //如果俩字符串相同，并且存在重复字符，返回true
        if (A.equals(B)) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < lenA; i++) {
                if (set.contains(A.charAt(i)))
                    return true;
                else
                    set.add(A.charAt(i));
            }
            return false;
        }

        //如果俩字符串不同，进行判断
        int count = 0;    //计数不同的字符个数
        int pre = -1, post = -1;  //pre，post分别记录俩不同字符的位置
        for (int i = 0; i < lenA; i++) {
            if (count > 2) {
                return false;
            }
            if (A.charAt(i) == B.charAt(i))
                continue;
            else {
                ++count;
                if (pre == -1)
                    pre = i;
                else
                    post = i;
            }

        }
        return count == 2 && A.charAt(pre) == B.charAt(post) && A.charAt(post) == B.charAt(pre);
    }
}
// @lc code=end

