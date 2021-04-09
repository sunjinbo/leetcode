/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;

        int num1 = getLength(l1);
        int num2 = getLength(l2);

        int carry = 0;
        while (num1 != 0 || num2 != 0) {
            ListNode node1 = getNode(num1--, l1);
            ListNode node2 = getNode(num2--, l2);

            if (node1 != null || node2 != null) {
                int sum = (node1 != null ? node1.val : 0);
                sum += (node2 != null ? node2.val : 0);
                sum += carry;

                int val = 0;
                if (sum >= 10) {
                    val = sum % 10;
                    carry = sum / 10;
                } else {
                    val = sum;
                    carry = 0;
                }

                ListNode newNode = new ListNode(val);
                newNode.next = head;
                head = newNode;
            } else {
                break;
            }
        }

        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }

    // 获取单链表第n个节点，如果不存在则返回null
    private ListNode getNode(int n, ListNode l) {
        if (n <= 0) return null;
        ListNode next = l;
        while (next != null && n > 1) {
            n -= 1;
            next = next.next;
        }
        return next;
    }

    // 获取链表的长度
    private int getLength(ListNode l) {
        int num = 0;
        ListNode next = l;
        while (next != null) {
            num += 1;
            next = next.next;
        }
        return num;
    }
}
// @lc code=end

