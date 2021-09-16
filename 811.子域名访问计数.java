import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=811 lang=java
 *
 * [811] 子域名访问计数
 */

// @lc code=start
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; ++i) {
            String[] cpdomainSplit = cpdomains[i].split(" ");
            String cpString = cpdomainSplit[0];
            String domainString = cpdomainSplit[1];
            int cp = Integer.parseInt(cpString);

            String[] domainSplit = domainString.split("\\.");
            for (int j = 0; j < domainSplit.length; ++j) {
                StringBuilder domain = new StringBuilder();
                domain.append(domainSplit[j]);
                for (int k = j + 1; k < domainSplit.length; ++k) {
                    domain.append(".");
                    domain.append(domainSplit[k]);
                }

                final String key = domain.toString();
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + cp);
                } else {
                    map.put(key, cp);
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            ans.add(map.get(key) + " " + key);
        }

        return ans;
    }
}
// @lc code=end

