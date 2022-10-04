package leetcode.question0206;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        reverseList(null);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }
}
