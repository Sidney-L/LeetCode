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
    public boolean hasCycle(ListNode head) {
        ListNode pt1 = head;
        ListNode pt2 = head;
        while(pt1!=null && pt2!=null){
            pt1 = pt1.next;
            pt2 = pt2.next;
            if(pt2!=null){
                pt2 = pt2.next;
                if(pt1 == pt2)
                    return true;
            }
            else
                break;
            
        }
        return false;
    }
}
