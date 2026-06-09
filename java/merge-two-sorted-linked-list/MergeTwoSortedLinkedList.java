public class MergeTwoSortedLinkedList {

    // Recursively splice the two sorted lists together: pick the smaller head,
    // then merge the rest behind it. Base case: one list is empty.
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.value <= list2.value) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    private static void print(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // list1: 1 -> 3 -> 5
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(5);
        a1.setNext(a2);
        a2.setNext(a3);

        // list2: 2 -> 4 -> 6
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(6);
        b1.setNext(b2);
        b2.setNext(b3);

        MergeTwoSortedLinkedList solution = new MergeTwoSortedLinkedList();
        ListNode merged = solution.mergeTwoLists(a1, b1);

        System.out.print("merged: ");
        print(merged);
    }
}
