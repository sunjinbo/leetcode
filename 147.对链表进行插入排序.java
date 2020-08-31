/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
    public ListNode insertionSortList(ListNode head) {
        ListNode pro = new ListNode(Integer.MIN_VALUE);
        pro.next = head;

        ListNode cursor = head;
        ListNode find, next;
        while (cursor != null) {
            next = cursor.next;
            find = pro;

            while (find != cursor) {
                if (find.next != null && find.next.val > cursor.val) {
                    ListNode last = pro;
                    while (last.next != cursor) last = last.next;
                    last.next = cursor.next;

                    ListNode temp = find.next;
                    find.next = cursor;
                    cursor.next = temp;
                    break;
                }
                find = find.next;
            }

            cursor = next;
        }

        return pro.next;
    }
}
// @lc code=end

