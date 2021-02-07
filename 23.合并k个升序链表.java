/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummpyHead = new ListNode();

        for (int i = 0; i < lists.length; ++i) {
            dummpyHead.next = mergeList(dummpyHead.next, lists[i]);
        }

        return dummpyHead.next;
    }

    // 将链表newList合并到链表originalList中
    public ListNode mergeList(ListNode originalList, ListNode newList) {
        ListNode head = originalList;
        ListNode current = newList;
        while (current != null) {
            ListNode temp = current;
            current = current.next;

            // 将temp节点插入到originalList列表中
            if (head == null) {
                head = temp;
                break;
            } else {
                ListNode cur = head;
                while (cur != null) {
                    if (temp.val >= cur.val && (cur.next == null || temp.val < cur.next.val)) {
                        // 插入到cur之后
                        ListNode t = cur.next;
                        cur.next = temp;
                        temp.next = t;
                        break;
                    } else if (temp.val < cur.val) {
                        // 插入到cur节点之前
                        head = temp;
                        temp.next = cur;
                        break;
                    } else {
                        // 继续寻找下一个插入位置
                        cur = cur.next;
                    }
                }
            }
        }

        return head;
    }
}
// @lc code=end

