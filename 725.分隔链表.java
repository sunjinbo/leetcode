/*
 * @lc app=leetcode.cn id=725 lang=java
 *
 * [725] 分隔链表
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
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] split = new ListNode[k];
        int len = getLength(root);
        int num1 = len / k;
        int num2 = len % k;
        ListNode head = root;
        for (int i = 0; i < k; ++i) {
            int count = num1 + (i < num2 ? 1 : 0);
            split[i] = head;
            head = cut(head, count);
        }

        return split;
    }

    public ListNode cut(ListNode head, int n) {
        if (head == null) return null;
        ListNode next = head;
        while (n > 0) {
            n -= 1;
            if (n == 0) {
                ListNode tail = next;
                next = next.next;
                tail.next = null;
            } else {
                next = next.next;
            }
        }

        return n == 0 ? next : null;
    }

    public int getLength(ListNode root) {
        int len = 0;
        ListNode next = root;
        while (next != null) {
            len += 1;
            next = next.next;
        }
        return len;
    }
}
// @lc code=end

