/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode temp = new ListNode(-1);
        temp.next = head;

        ListNode left = temp;
        ListNode right = temp;
        ListNode cur = temp.next;
        int i = 1;
        while (cur != null) {
            if (i % k == 0) {
                // 翻转子链表

                // 拆分链表
                right = cur.next;
                cur.next = null;

                // 拼接链表
                ListNode reverseNode = left.next;
                left.next = reverse(left.next);
                reverseNode.next = right;

                // 准备下一次循环
                cur = right;
                left = reverseNode;
            } else {
                // 寻找子链表的左右边界
                cur = cur.next;
            }

            i += 1;
        }

        return temp.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}
// @lc code=end

