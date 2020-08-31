/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
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
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode pointer1 = head;
        ListNode pointer2 = null;

        do {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next; // move forward step twice
            }

            slow = slow.next; // move forward one step

            if (fast == null || slow == null) {
                return null; // ring is not found
            }

            if (fast == slow) {
                pointer2 = fast;
                break;
            }
        } while (true);

        if (pointer2 != null) {
            while (pointer1 != pointer2) {
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }
            return pointer2;
        }

        return null;
    }
}
// @lc code=end

