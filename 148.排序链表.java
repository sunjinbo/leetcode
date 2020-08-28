/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        ListNode i = head;
        while (i != null && i.next != null) {
            ListNode j = i.next;
            while (j != null) {
                if (i != j && i.val > j.val) {
                    i.val ^= j.val;
                    j.val ^= i.val;
                    i.val ^= j.val;
                }
                j = j.next;
            }

            i = i.next;
        }
        return head;
    }
}
// @lc code=end

