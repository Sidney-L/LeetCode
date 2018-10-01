/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        int n = 0;
        for(ListNode pt = head; pt != null; pt = pt.next){
            n++;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for(int i = 1; i < n; i *= 2){
            ListNode begin = dummy;
            for(int j = 0; j + i < n; j += 2*i) {
                ListNode first = begin.next;
                ListNode second = first;
                for(int k = 0; k < i; k++){
                    second = second.next;
                }
                int f = 0;
                int s = 0;
                while(f < i && s < i && second != null){
                    if(first.val < second.val){
                        begin.next = first;
                        begin = begin.next;
                        first = first.next;
                        f++;
                    }
                    else{
                        begin.next = second;
                        begin = begin.next;
                        second = second.next;
                        s++;
                    }
                }
                while(f < i){
                    begin.next = first;
                    begin = begin.next;
                    first = first.next;
                    f++;
                }
                while(s < i && second != null){
                    begin.next = second;
                    begin = begin.next;
                    second = second.next;
                    s++;
                }
                begin.next = second;
            }
        }
        return dummy.next;
    }
}
