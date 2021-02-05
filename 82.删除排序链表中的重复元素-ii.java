/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode previous = dummyHead;
        ListNode current = dummyHead.next;

        while (current != null && current.next != null) {
            ListNode p = current;
            ListNode cur = current.next;
            boolean hasDuplicate = false;
            while (cur != null) {
                if (cur.val == current.val) {
                    // 如果后序节点的数值与current节点相同，则将其删除
                    cur = cur.next;
                    p.next = cur;
                    hasDuplicate = true;
                } else {
                    // 如果后序节点的数值与current节点不相同，则将指针向后移动
                    p = p.next;
                    cur = cur.next;
                }
            }

            if (hasDuplicate) {
                // 如果存在重复的元素，则将current节点删除
                current = current.next;
                previous.next = current;
            } else {
                // 不存在重复的元素，检测下一个节点
                previous = previous.next;
                current = current.next;
            }
        }

        return dummyHead.next;
    }
}
// @lc code=end

