/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        do {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next; // move forward step twice
            }

            slow = slow.next; // move forward one step

            if (fast == null || slow == null) {
                return false; // ring is not found
            }

            if (fast == slow) {
                return true;
            }
        } while (true);
    }
}
// @lc code=end

