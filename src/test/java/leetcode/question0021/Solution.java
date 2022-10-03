package leetcode.question0021;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        mergeTwoLists(null, null);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null && list2 == null) {
            return null;
        }

        ListNode result = new ListNode(-1);
        ListNode current = result;

        ListNode c1 = list1;
        ListNode c2 = list2;

        if (c1 == null) {
            while (c2 != null) {
                current.next = new ListNode(c2.val);
                current = current.next;
                c2 = c2.next;
            }
        } else if (c2 == null) {
            while (c1 != null) {
                current.next = new ListNode(c1.val);
                current = current.next;
                c1 = c1.next;
            }
        } else {
            while (c1 != null || c2 != null) {
                if (c1 == null) {
                    current.next = new ListNode(c2.val);
                    current = current.next;
                    c2 = c2.next;
                } else if (c2 == null) {
                    current.next = new ListNode(c1.val);
                    current = current.next;
                    c1 = c1.next;
                } else {
                    if (c1.val < c2.val) {
                        current.next = new ListNode(c1.val);
                        current = current.next;
                        c1 = c1.next;
                    } else {
                        current.next = new ListNode(c2.val);
                        current = current.next;
                        c2 = c2.next;
                    }
                }
            }
        }

        return result.next;
    }
}
