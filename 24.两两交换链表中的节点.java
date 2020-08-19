/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;

        ListNode a = head;
        ListNode b = head.next;

        while (a != null && b != null) {
            int temp = a.val;
            a.val = b.val;
            b.val = temp;

            if (a.next != null) {
                a = a.next.next;
            } else {
                a = null;
            }

            if (b.next != null) {
                b = b.next.next;
            } else {
                b = null;
            }
        }
        return head;
    }
}
// @lc code=end

