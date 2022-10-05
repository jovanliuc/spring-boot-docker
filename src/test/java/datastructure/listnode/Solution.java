package datastructure.listnode;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        hasCycle(null);
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
