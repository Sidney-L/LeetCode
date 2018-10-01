/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        ListNode pt1 = head;
        ListNode pt2 = head;
        while(pt1!=null&&pt1.next!=null){
            pt1 = pt1.next;
            if(pt1.val == pt2.val)
                continue;
            else{
                pt2.next = pt1;
                pt2 = pt1;
            }
        }
        if(pt2.val==pt1.val)
            pt2.next = null;
        return head;
    }
}
