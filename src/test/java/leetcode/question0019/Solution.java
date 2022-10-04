package leetcode.question0019;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        removeNthFromEnd(null, 1);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode removedNthListNode = new ListNode(-1);
        removedNthListNode.next = head;
        ListNode node = findNthFromEnd(removedNthListNode, n + 1);
        node.next = node.next.next;
        return removedNthListNode.next;
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
