/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
        int count = 0;
        ListNode cur = head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        cur = head;
        for(int i = 0; i < (count+1)/2-1; i++){
            cur = cur.next;
        }
        ListNode pt1 = cur;
        ListNode pt2 = cur.next;
        while(pt2!=null){
            ListNode temp = pt2.next;
            pt2.next = pt1;
            pt1 = pt2;
            pt2 = temp;
        }
        cur.next = null;
        while(head!=null&&pt1!=head){
            pt2 = head.next;
            head.next = pt1;
            cur = pt1.next;
            pt1.next = pt2;
            head = pt2;
            pt1 = cur;
        }
    }
}
