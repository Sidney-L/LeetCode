/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode pt1 = head;
        ListNode pt2 = head;
        while(true){
            if(pt1 == null || pt2 == null || pt1.next == null || pt2.next == null || pt2.next.next == null)
                return null;
            pt1 = pt1.next;
            pt2  = pt2.next.next;
            if(pt1 == pt2){
                pt1 = head;
                break;
            }
        }
        while(pt1!=pt2){
            pt1 = pt1.next;
            pt2 = pt2.next;
        }
        return pt1;
    }
}
