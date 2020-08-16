/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode cursor = null;
        int pop = 0;

        while (!(l1 == null && l2 == null && pop == 0)) {
            int sum = (l1 != null ? l1.val : 0);
            sum += (l2 != null ? l2.val : 0);
            sum += pop;

            if (sum > 9) {
                pop = 1;
                sum %= 10;
            } else {
                pop = 0;
            }

            if (result == null) {
                result = new ListNode(sum);
                cursor = result;
            } else {
                cursor.next = new ListNode(sum);
                cursor = cursor.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return result;
    }
}
// @lc code=end

