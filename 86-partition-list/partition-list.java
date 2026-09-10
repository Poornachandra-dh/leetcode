class Solution {
    public ListNode partition(ListNode head, int x) {

        // Dummy nodes
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);

        // Tail pointers
        ListNode less = lessHead;
        ListNode greater = greaterHead;

        // Traverse original list
        while (head != null) {

            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }

            head = head.next;
        }

        // End the greater list
        greater.next = null;

        // Connect less list to greater list
        less.next = greaterHead.next;

        return lessHead.next;
    }
}