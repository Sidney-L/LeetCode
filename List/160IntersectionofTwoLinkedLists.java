/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode pt1 = headA;
        ListNode pt2 = headB;
        while(pt1.next!=null||pt2.next!=null){
            if(pt1==pt2){
                return pt1;
            }
            else{
                if(pt1.next == null){
                    pt1 = headB;
                    pt2 = pt2.next;
                }
                else if(pt2.next == null){
                    pt2 = headA;
                    pt1 = pt1.next;
                }
                else{
                    pt1 = pt1.next;
                    pt2 = pt2.next;
                }
            }
        }
        if(pt1 == pt2)
            return pt1;
        else
            return null;
    }
}
