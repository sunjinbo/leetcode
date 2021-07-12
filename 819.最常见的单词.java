import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=819 lang=java
 *
 * [819] 最常见的单词
 */

// @lc code=start
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();

        int begin = -1;
        for (int i = 0; i < paragraph.length(); ++i) {
            if (isAlphabet(paragraph.charAt(i))) {
                if (begin == -1) {
                    begin = i;
                }
            } else {
                if (begin != -1) {
                    String word = paragraph.substring(begin, i);
                    addWord(map, banned, word);
                    begin = -1;
                }
            }
        }

        if (begin != -1) {
            String word = paragraph.substring(begin, paragraph.length());
            addWord(map, banned, word);
        }
    
        String mostWord = "";
        int count = 0;
        for (String word : map.keySet()) {
            if (map.get(word) > count) {
                mostWord = word;
                count = map.get(word);
            }
        }

        return mostWord;
    }

    private void addWord(HashMap<String, Integer> map, String[] banned, String word) {
        word = word.toLowerCase();
        if (!isBanned(word, banned)) {
            int count = 1;
            if (map.containsKey(word)) {
                count += map.get(word);
                map.remove(word);
            }
            map.put(word, count);
        }
    }

    private boolean isBanned(String word, String[] banned) {
        for (int i = 0; i < banned.length; ++i) {
            if (word.equals(banned[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean isAlphabet(char ch) {
        return ((ch >= 'a' && ch <= 'z')
            || (ch >= 'A' && ch <= 'Z'));
    }
}
// @lc code=end

