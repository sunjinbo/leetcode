/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        
        while (k > 0) {
            ListNode tail = head;
            int n = 2;
            while (tail.next != null && tail.next.next != null) {
                tail = tail.next;
                n += 1;
            }

            if (n < k) {
                k = k % n;
            }

            if (k > 0) {
                tail.next.next = head;
                head = tail.next;
                tail.next = null;
            }

            k -= 1;
        }

        return head;
    }
}
// @lc code=end

