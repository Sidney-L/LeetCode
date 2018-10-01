/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while(head!=null){
            ListNode next = head.next;
            ListNode pt = dummy;
            while(pt.next!=null && pt.next.val <= head.val){
                pt = pt.next;
            }
            head.next = pt.next;
            pt.next = head;
            
            head = next;
        }
        return dummy.next;
    }
}
