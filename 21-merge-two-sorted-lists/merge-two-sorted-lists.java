class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        ListNode tempa = list1;
        ListNode tempb = list2;

        while (tempa != null && tempb != null) {
            
            if (tempa.val <= tempb.val) {
                temp.next = tempa;
                tempa = tempa.next;
            } else {
                temp.next = tempb;
                tempb = tempb.next;
            }

            temp = temp.next;
        }

        // Remaining nodes
        if (tempa != null) {
            temp.next = tempa;
        }

        if (tempb != null) {
            temp.next = tempb;
        }

        return dummy.next;
    }
}