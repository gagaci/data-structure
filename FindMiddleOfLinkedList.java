public class FindMiddleOfLinkedList {

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

    Node middleOfLinkedList = findMiddleOfLinkedList(head);
    System.out.println(" middle: " + middleOfLinkedList.value);
  }

}