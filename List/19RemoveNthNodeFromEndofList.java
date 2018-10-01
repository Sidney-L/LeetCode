/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pt1 = dummy;
        ListNode pt2 = dummy;
        int count = 0;
        while(pt1.next!=null){
            pt1 = pt1.next;
            count++;
            if(count > n)
                pt2 = pt2.next;
        }
        pt2.next = pt2.next.next;
        return dummy.next;
    }
}
