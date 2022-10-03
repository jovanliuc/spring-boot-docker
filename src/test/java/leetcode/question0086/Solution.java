package leetcode.question0086;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        partition(null, 3);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode lessThanXListNode = new ListNode(-1);
        ListNode moreThanOrEqualToXListNode = new ListNode(-1);
        ListNode c1 = lessThanXListNode;
        ListNode c2 = moreThanOrEqualToXListNode;

        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                c1.next = new ListNode(current.val);
                c1 = c1.next;
            } else {
                c2.next = new ListNode(current.val);
                c2 = c2.next;
            }
            current = current.next;
        }

        c1.next = moreThanOrEqualToXListNode.next;

        return lessThanXListNode.next;
    }
}
