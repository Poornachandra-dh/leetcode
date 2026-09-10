class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        // Dummy node handles the case when left = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Move prev to the node before left
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // First node of the section to reverse
        ListNode curr = prev.next;

        // Reverse from left to right
        for (int i = 0; i < right - left; i++) {

            ListNode next = curr.next;

            // Remove next from its current position
            curr.next = next.next;

            // Insert next at the beginning of the reversed section
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }
}