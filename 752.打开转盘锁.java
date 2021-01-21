import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */

// @lc code=start
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Set<String> deads = new HashSet<>();
        for (String d : deadends) deads.add(d);
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");
        int step = 0;

        while (!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < sz; ++i) {
                String cur = q.poll();

                if (deads.contains(cur)) {
                    continue;
                }

                if (cur.equals(target)) {
                    return step;
                }

                for (int j = 0; j < 4; ++j) {
                    String plus = plusOne(cur, j);
                    if (!visited.contains(plus)) {
                        q.offer(plus);
                        visited.add(plus);
                    }

                    String minus = minusOne(cur, j);
                    if (!visited.contains(minus)) {
                        q.offer(minus);
                        visited.add(minus);
                    }
                }
            }

            step += 1;
        }

        return -1;
    }

    private String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }

    private String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }
}
// @lc code=end

