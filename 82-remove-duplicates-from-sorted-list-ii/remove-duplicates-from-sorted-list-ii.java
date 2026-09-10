class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        // Dummy node handles the case
        // where duplicates start from the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            // Skip all nodes having the same value
            while (curr.next != null &&
                   curr.val == curr.next.val) {
                curr = curr.next;
            }

            // No duplicate was found
            if (prev.next == curr) {
                prev = curr;
            }

            // Duplicate was found
            else {
                prev.next = curr.next;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}