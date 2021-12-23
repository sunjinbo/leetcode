/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 链表为空
        if (head == null) return head;
        // 链表长度为1
        if (head != null && head.next == null) return head;

        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;

        // 找到反转链表的左侧节点
        ListNode cur = tempHead;
        int i = 0;
        for (; i < m - 1; ++i) {
            cur = cur.next;
        }
        ListNode leftNode = cur;

        // 找到反转链表的右侧节点
        for (; i < n; ++i) {
            cur = cur.next;
        }
        ListNode rightNode = cur.next;

        // 切断列表
        ListNode reverseNode = leftNode.next;
        leftNode.next = null;
        cur.next = null;

        // 反转列表并重新连接列表
        leftNode.next = reverse(reverseNode);
        reverseNode.next = rightNode;

        return tempHead.next;
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

