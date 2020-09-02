/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {
        ListNode h1 = new ListNode(-1); // 记录比x小的节点组成的链表
        ListNode h2 = new ListNode(-1); // 记录比x大的节点组成的链表
        ListNode p1 = h1, p2 = h2;
        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        // 将两个链表拼接起来
        p2.next = null;
        p1.next = h2.next;
        return h1.next;
    }
}
// @lc code=end

