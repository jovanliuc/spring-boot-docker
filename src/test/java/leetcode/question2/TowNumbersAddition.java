package leetcode.question2;

public class TowNumbersAddition {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(9);

        ListNode header = addTwoNumbers(l1, l2);
        printListNodes(header);
    }

    private static void printListNodes(ListNode header) {
        if (header == null) {
            System.out.println("null");
        }
        StringBuilder sb = new StringBuilder();
        ListNode current = header;
        while (current != null) {
            sb.append(current.val);
            if (current.next == null) {
                sb.append(" > null");
            } else {
                sb.append(" > ");
            }
            current = current.next;
        }

        System.out.println(sb.toString());
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode header = new ListNode(0);
        ListNode current = header;

        int val1;
        int val2;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            if (l1 == null) {
                val1 = 0;
            } else {
                val1 = l1.val;
                l1 = l1.next;
            }

            if (l2 == null) {
                val2 = 0;
            } else {
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1 + val2 + carry;
            int currentBitNumber = sum % 10;
            current.next = new ListNode(currentBitNumber);
            current = current.next;
            carry = sum / 10;
        }

        return header.next;
    }


    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
