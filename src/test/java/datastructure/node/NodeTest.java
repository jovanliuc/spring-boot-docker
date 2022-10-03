package datastructure.node;

public class NodeTest {

    public static void main(String[] args) {
        Node header = new Node();

        header.data = "A";
        header.next = new Node();

        header.next.data = "B";
        header.next.next = new Node();

        header.next.next.data = "C";
        header.next.next.next = new Node();

        header.next.next.next.data = "D";
        header.next.next.next.next = new Node();

        header.next.next.next.next.data = "E";
        header.next.next.next.next.next = null;

        traverseListNode(header);
    }

    public static void traverse(Node header) {
        for (Node p = header; p != null; p = p.next) {
            System.out.print(p.data + " > ");
        }
    }

    public static void traverseListNode(Node header) {
        if (header == null) {
            return;
        } else {
            System.out.print(header.data + " > ");
            traverseListNode(header.next);
        }
    }

    public static String get(Node header, int index) {
        Node current = header;
        for (int i = 0; i < index; i++) {
            if (current.next == null) {
                return null;
            }

            current = current.next;
        }

        return current.data;
    }

    public static void printNodes(Node header) {
        if (header == null) {
            System.out.println("null");
        }
        StringBuilder sb = new StringBuilder();
        Node current = header;
        while (current != null) {
            sb.append(current.data);
            if (current.next == null) {
                sb.append(" > null");
            } else {
                sb.append(" > ");
            }
            current = current.next;
        }

        System.out.println(sb.toString());
    }

    public static Node add(Node header, Node newNode, int index) {
        if (index == 0) {
            Node newHeader = newNode;
            newHeader.next = header;

            return newHeader;
        }

        Node current = header;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        Node currentNextNode = current.next;
        current.next = newNode;
        newNode.next = currentNextNode;

        return header;
    }

    public static Node remove(Node header, int index) {
        if (index == 0) {
            return header.next;
        }

        Node current = header;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;

        return header;
    }
}
