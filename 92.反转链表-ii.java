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
        // 链表为空或者个数为1，直接返回该链表
        if (head == null
                || (head != null && head.next == null)) return head;

        int i = 1;
        ListNode next = head;
        ListNode cursor = null, start = null, end = null,
                tempHead = null;
        while (next != null) {
            cursor = next;
            next = next.next;

            if (i < m - 1) {
                // continue
            } else if (i == m - 1) {
                start = cursor;
            } else if (i == m) {
                tempHead = cursor;
                end = cursor;
            } else if (i > m && i < n) {
                cursor.next = tempHead;
                tempHead = cursor;
            } else if (i == n) {
                cursor.next = tempHead;
                tempHead = cursor;
                if (start != null) {
                    start.next = tempHead;
                } else {
                    head = tempHead; // 临时链表前面没有节点，直接有head指针指向临时链表
                }
                end.next = next;
                break;
            }

            i += 1;
        }

        return head;
    }
}
// @lc code=end

