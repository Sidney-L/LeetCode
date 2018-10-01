
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode pt1 = head;
        ListNode pt2 = head;
        int count = 0;
        while(pt1.next != null){
            count++;
            pt1 = pt1.next;
        }
        count++;
        pt1 = head;
        for(int i = 0; i<k%count; i++){
            pt1 = pt1.next;
        }
        while(pt1.next!=null){
            pt1=pt1.next;
            pt2=pt2.next;
        }
        pt1.next = head;
        head = pt2.next;
        pt2.next = null;
        return head;
    }
}
