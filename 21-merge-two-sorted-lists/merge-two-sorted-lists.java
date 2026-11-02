/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tempa = list1;
        ListNode tempb = list2;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(tempa!=null && tempb!=null){
            if(tempa.val<=tempb.val){
                temp.next = tempa;
                tempa = tempa.next ; 
            }
            else if(tempa.val>tempb.val){
                temp.next = tempb;
                tempb = tempb.next ; 
            }
            
            temp = temp.next;
        }
        
        if(tempa!=null){
            temp.next = tempa;
        }
        if(tempb!=null){
            temp.next= tempb;
        }
        
        
        return dummy.next;
    }
}