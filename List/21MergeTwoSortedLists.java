/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pt1 = l1;
        ListNode pt2 = l2;
        if(l1 == null)
            return l2;
        if(l2 == null){
            return l1;
        }
        ListNode newl = null;
        ListNode newCur = newl;
        while(pt1!=null && pt2!=null){
            if(pt1.val > pt2.val){
                if(newCur == null){
                    ListNode temp = pt2.next;
                    pt2.next = null;
                    newl = pt2;
                    pt2 = temp;
                    newCur = newl;
                }
                else{
                    newCur.next = pt2;
                    ListNode temp = pt2.next;
                    pt2.next = null;
                    newCur = newCur.next;
                    pt2 = temp;
                }
            }
            else{
                if(newCur == null){
                    ListNode temp = pt1.next;
                    pt1.next = null;
                    newl = pt1;
                    pt1 = temp;
                    newCur = newl;
                }
                else{
                    newCur.next = pt1;
                    ListNode temp = pt1.next;
                    pt1.next = null;
                    newCur = newCur.next;
                    pt1 = temp;
                }
            }
        }
        if(pt1 == null){
            newCur.next = pt2;
        }
        else{
            newCur.next = pt1;
        }
        return newl;
    }
}
