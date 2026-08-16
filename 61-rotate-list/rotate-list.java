
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int n=0;
        ListNode temp = head ;
        if(head == null) return null ; 
        if(head.next ==null) return head ;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        k=k%n;
        if(k==0) return head ;
        ListNode slow =head ;
        ListNode fast = head;

        for(int i=1;i<=k;i++){
            fast = fast.next;
        }
        while(fast.next!=null){
            slow= slow.next ; 
            fast=fast.next ; 

        }
        ListNode newNode = slow.next ; 
        slow.next = null ;
        fast.next = head;
        return newNode ;
         
    }
    
}