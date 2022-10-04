package leetcode.question0023;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    @Test
    void test() {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode mergedKListNode = new ListNode(-1);
        ListNode current = mergedKListNode;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                lists.length, Comparator.comparingInt(a -> a.val));

        for (ListNode head : lists) {
            if (head != null) {
                priorityQueue.add(head);
            }
        }

        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            current.next = node;
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
            current = current.next;
        }

        return mergedKListNode.next;
    }
}
