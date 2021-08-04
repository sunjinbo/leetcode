import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=500 lang=java
 *
 * [500] 键盘行
 */

// @lc code=start
class Solution {
    private final static String KEYBOARD_LINE_1 = "qwertyuiop";
    private final static String KEYBOARD_LINE_2 = "asdfghjkl";
    private final static String KEYBOARD_LINE_3 = "zxcvbnm";

    public String[] findWords(String[] words) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];

            int line = findLineId(word.charAt(0));
            boolean allInOneLine = true;
            for (int j = 0; j < word.length(); ++j) {
                if (!findLine(line, word.charAt(j))) {
                    allInOneLine = false;
                    break;
                }
            }

            if (allInOneLine) {
                result.add(word);
            }
        }

        return result.toArray(new String[result.size()]);
    }

    public int findLineId(char ch) {
        if (findLine(1, ch)) return 1;
        if (findLine(2, ch)) return 2;
        if (findLine(3, ch)) return 3;
        return -1;
    }

    public boolean findLine(int lineId, char ch) {
        switch (lineId) {
            case 1:
                return findLine(KEYBOARD_LINE_1, ch);
            case 2:
                return findLine(KEYBOARD_LINE_2, ch);
            case 3:
                return findLine(KEYBOARD_LINE_3, ch);
            default:
                return false;
        }
    }

    public boolean findLine(String keyboard, char ch) {
        int offset = 'A' - 'a';
        for (int i = 0; i < keyboard.length(); ++i) {
            if (keyboard.charAt(i) == ch || keyboard.charAt(i) + offset == ch) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

