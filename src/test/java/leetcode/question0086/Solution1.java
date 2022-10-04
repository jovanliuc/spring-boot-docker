package leetcode.question0086;

import org.junit.jupiter.api.Test;

public class Solution1 {

    @Test
    void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        partition(head, 3);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode lessThanXListNode = new ListNode(-1);
        ListNode moreThanOrEqualToXListNode = new ListNode(-1);
        ListNode c1 = lessThanXListNode;
        ListNode c2 = moreThanOrEqualToXListNode;

        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                c1.next = current;
                c1 = c1.next;
            } else {
                c2.next = current;
                c2 = c2.next;
            }
            ListNode temp = current.next;
            current.next = null;
            current = temp;
        }

        c1.next = moreThanOrEqualToXListNode.next;

        return lessThanXListNode.next;
    }
}
