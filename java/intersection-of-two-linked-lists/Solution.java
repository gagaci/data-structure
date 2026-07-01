public class Solution {

    // Two-pointer "walk both lists" trick (LeetCode 160).
    //
    // tempA walks list A then continues into list B.
    // tempB walks list B then continues into list A.
    // By the time either pointer has crossed over, both have travelled the
    // exact same number of steps (lenA + lenB), so they line up:
    //   - if the lists intersect, they meet at the first shared node;
    //   - if they don't, they both reach null at the same time and the loop
    //     exits with tempA == tempB == null.
    // Either way the meeting point IS the answer. O(m + n) time, O(1) space.
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB) {
            tempA = (tempA == null) ? headB : tempA.next;
            tempB = (tempB == null) ? headA : tempB.next;
        }
        return tempA;
    }

    public static void main(String[] args) {
        // Shared tail: 8 -> 4 -> 5  (this is the intersection)
        ListNode c1 = new ListNode(8);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);
        c1.setNext(c2);
        c2.setNext(c3);

        // List A: 4 -> 1 -> [8 -> 4 -> 5]
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        a1.setNext(a2);
        a2.setNext(c1);

        // List B: 5 -> 6 -> 1 -> [8 -> 4 -> 5]
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(1);
        b1.setNext(b2);
        b2.setNext(b3);
        b3.setNext(c1);

        Solution solution = new Solution();
        ListNode intersection = solution.getIntersectionNode(a1, b1);

        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.value);
        } else {
            System.out.println("No intersection.");
        }

        // Sanity check with two non-intersecting lists.
        ListNode x1 = new ListNode(2);
        x1.setNext(new ListNode(6));
        ListNode y1 = new ListNode(1);
        y1.setNext(new ListNode(5));
        ListNode none = solution.getIntersectionNode(x1, y1);
        System.out.println("Second test result: " + (none == null ? "No intersection." : none.value));
    }
}
