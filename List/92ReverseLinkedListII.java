/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        for(int i = 0; i < m - 1; i++){
            start = start.next;
        }
        ListNode pt1 = start.next;
        ListNode pt2 = start.next.next;
        for(int i = 0; i < n-m; i++){
            ListNode temp = pt2.next;
            pt2.next = pt1;
            pt1 = pt2;
            pt2 = temp;
        }
        start.next.next = pt2;
        start.next = pt1;
        return dummy.next;
        
    }
}
