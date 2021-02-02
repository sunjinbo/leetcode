/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != null && pB != null) {
            if (pA == pB) {
                return pA;
            }
            
            pA = pA.next;
            pB = pB.next;

            if (pA == null && pB == null) {
                return null;
            }

            if (pA == pB) {
                return pA;
            }

            if (pA == null) {
                pA = headB;
            }

            if (pB == null) {
                pB = headA;
            }
        }

        return null;
    }
}
// @lc code=end

