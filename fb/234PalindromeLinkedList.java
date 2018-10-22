/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        int n = 0;
        ListNode p = head;
        while(p!=null){
            n++;
            p = p.next;
        }
        if(n<=1)
            return true;
        p = head;
        for(int i = 0; i < ((n%2==0)?n/2-1:n/2); i++){
            p = p.next;
        }
        ListNode cur = p.next;
        ListNode p2 = cur.next;
        while(p2!=null){
            cur.next = p;
            p = cur;
            cur = p2;
            p2 = p2.next;
        }
        cur.next = p;
        p2 = head;
        if(n==2)
            return p2.val==cur.val;
        for(int i = 0; i < n/2; i++){
            if(p2.val != cur.val)
                return false;
            p2 = p2.next;
            cur = cur.next;
        }
        return true;
    }
}
