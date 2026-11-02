
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode a = head.next;
        ListNode newnode = reverseList(a);
        a.next = head;
        head.next=null;
        return newnode;
        
        
        }
}