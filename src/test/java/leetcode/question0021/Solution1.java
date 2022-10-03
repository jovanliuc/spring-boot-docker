package leetcode.question0021;

import org.junit.jupiter.api.Test;

public class Solution1 {

    @Test
    void test() {
        mergeTwoLists(null, null);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedListNode = new ListNode(-1);
        ListNode current = mergedListNode;

        ListNode c1 = list1;
        ListNode c2 = list2;

        while (c1 != null && c2 != null) {
            if (c1.val > c2.val) {
                current.next = c2;
                c2 = c2.next;
            } else {
                current.next = c1;
                c1 = c1.next;
            }
            current = current.next;
        }

        if (c1 != null) {
            current.next = c1;
        }

        if (c2 != null) {
            current.next = c2;
        }

        return mergedListNode.next;
    }
}
