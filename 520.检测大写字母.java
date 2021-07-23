/*
 * @lc app=leetcode.cn id=520 lang=java
 *
 * [520] 检测大写字母
 */

// @lc code=start
class Solution {
    public enum State {
        Whatever, // 接下来大小写都ok
        OnlyCapitalUse, // 接下来只能是大写
        OnlyOridnaryUse // 接下来只能是小写
    }

    public boolean detectCapitalUse(String word) {
        State state = State.Whatever;
        for (int i = 0; i < word.length(); ++i) {
            switch (i) {
                case 0:
                    // 如果第一个字母是小写，接下来都应该保持小写
                    if (isOridnaryChar(word.charAt(i))) {
                        state = State.OnlyOridnaryUse;
                    }
                    break;
                case 1:
                    // 判断当前状态
                    switch (state) {
                        case Whatever:
                            // 说明上一个是大写字母，根据当前字符的大小写情况进行调正
                            if (isOridnaryChar(word.charAt(i))) {
                                state = State.OnlyOridnaryUse;
                            } else {
                                state = State.OnlyCapitalUse;
                            }
                            break;

                        case OnlyOridnaryUse:
                            if (!isOridnaryChar(word.charAt(i))) {
                                return false;
                            }
                            break;

                        default:
                            break;
                    }
                    break;

                default:
                    if (!isCorrect(state, word.charAt(i))) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

    private boolean isCorrect(State state, char ch) {
        switch (state) {
            case OnlyCapitalUse:
                if (isCapitalChar(ch)) {
                    return true;
                } else {
                    return false;
                }

            case OnlyOridnaryUse:
                if (isOridnaryChar(ch)) {
                    return true;
                } else {
                    return false;
                }

            default:
                return true;
        }
    }

    private boolean isOridnaryChar(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    private boolean isCapitalChar(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
}
// @lc code=end

