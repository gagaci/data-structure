public class FindMiddleOfLinkedList {

    // Two-pointer ("tortoise and hare"): fast moves twice as fast as slow,
    // so when fast reaches the end, slow sits at the middle node.
    static Node findMiddleOfLinkedList(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);

        Node middle = findMiddleOfLinkedList(head);
        System.out.println("middle: " + middle.value);
    }
}
