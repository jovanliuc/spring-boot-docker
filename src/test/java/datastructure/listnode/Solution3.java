package datastructure.listnode;

import org.junit.jupiter.api.Test;

public class Solution3 {

    @Test
    void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        traverse(head);
    }

    void traverse(ListNode head) {
        for (ListNode p = head; p != null; p = p.next) {
            System.out.print(p.val + " -> ");
        }
    }
}
