/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null)
            return null;
        if(lists.length == 0)
            return null;
        if(lists.length <= 1)
            return lists[0];
        while(lists.length > 1){
            LinkedList<ListNode> temp = new LinkedList<ListNode>();
            for(int i = 0; i < lists.length; i+=2) {
                if(i+1<lists.length)
                    temp.add(merge(lists[i], lists[i+1]));
                else
                    temp.add(lists[i]);
            }
            lists = temp.toArray(new ListNode[0]);
        }
        return lists[0];
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode curN1 = l1;
        ListNode curN2 = l2;
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode cur = dummy;
        while(curN1 != null && curN2 != null) {
            if(curN1.val < curN2.val) {
                cur.next = curN1;
                curN1 = curN1.next;
                cur.next.next = null;
                cur = cur.next;
            }
            else {
                cur.next = curN2;
                curN2 = curN2.next;
                cur.next.next = null;
                cur = cur.next;
            }
        }
        if(curN1 == null) {
            cur.next = curN2;
        }
        else
            cur.next = curN1;
        return dummy.next;
    }
}
