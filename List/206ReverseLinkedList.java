/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        else {
            ListNode cur = head.next;
            ListNode pt1 = head;
            ListNode pt2 = head.next.next;
            head.next = null;
            while(pt2 != null){
                cur.next = pt1;
                pt1 = cur;
                cur = pt2;
                pt2 = cur.next;
            }
            cur.next = pt1;
            return cur;
        }
        
    }
}
