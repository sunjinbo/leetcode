/*
 * @lc app=leetcode.cn id=1859 lang=java
 *
 * [1859] 将句子排序
 */

// @lc code=start
class Solution {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i; j < arr.length; ++j) {
                if (arr[i].charAt(arr[i].length() - 1) > arr[j].charAt(arr[j].length() - 1)) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            sb.append(arr[i].substring(0, arr[i].length() - 1));
            if (i < arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
// @lc code=end

