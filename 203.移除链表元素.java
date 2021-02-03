/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode previous = dummyHead;
        ListNode current = head;

        while (current != null) {
            if (current.val == val) {
                // 删除current节点，previous节点不变
                current = current.next;
                previous.next = current;
            } else {
                // current节点和previous节点向前移动
                previous = current;
                current = current.next;
            }
        }

        return dummyHead.next;
    }
}
// @lc code=end

