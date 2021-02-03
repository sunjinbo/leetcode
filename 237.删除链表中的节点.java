/*
 * @lc app=leetcode.cn id=237 lang=java
 *
 * [237] 删除链表中的节点
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
    public void deleteNode(ListNode node) {
        ListNode current = node;
        while (current.next != null) {
            current.val = current.next.val;

            if (current.next.next != null) {
                current = current.next;
            } else {
                current.next = null;
            }
        }
    }
}
// @lc code=end

