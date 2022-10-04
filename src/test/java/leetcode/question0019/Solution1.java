package leetcode.question0019;

import org.junit.jupiter.api.Test;

public class Solution1 {

    @Test
    void test() {
        removeNthFromEnd(null, 1);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        if (size(head) == n) {
            ListNode node = head.next;
            return node;
        }

        ListNode node = findNthFromEnd(head, n + 1);
        node.next = node.next.next;
        return head;
    }

    private int size(ListNode head) {
        int i = 0;
        ListNode current = head;
        while (current != null) {
            i++;
            current = current.next;
        }
        return i;
    }

    private ListNode findNthFromEnd(ListNode head, int n) {
        ListNode right = head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        ListNode left = head;
        while (right != null) {
            right = right.next;
            left = left.next;
        }

        return left;
    }
}