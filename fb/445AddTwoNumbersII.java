/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        /*
         StringBuffer sb1 = new StringBuffer();
         while(l1!=null){
         sb1.append(""+l1.val);
         l1 = l1.next;
         }
         StringBuffer sb2 = new StringBuffer();
         while(l2!=null){
         sb2.append(""+l2.val);
         l2 = l2.next;
         }
         if(sb1.length() < sb2.length()){
         StringBuffer temp = sb1;
         sb1 = sb2;
         sb2 = temp;
         }
         
         int carry = 0;
         for(int i = 0; i < sb2.length(); i++){
         char s =(char)(((int)(sb1.charAt(sb1.length()-1-i) - '0' + sb2.charAt(sb2.length()-1-i) - '0') + carry) % 10 + '0');
         carry = ((int)(sb1.charAt(sb1.length()-1-i) - '0' + sb2.charAt(sb2.length()-1-i) - '0') + carry)/ 10;
         sb1.setCharAt(sb1.length()-1-i,s);
         }
         
         for(int i = 0; i < sb1.length() - sb2.length(); i++){
         char s =(char) (((int)(sb1.charAt(sb1.length()-sb2.length()-1-i) - '0') + carry)% 10 + '0');
         carry = ((int)(sb1.charAt(sb1.length()-sb2.length()-1-i) - '0') + carry)/ 10;
         sb1.setCharAt(sb1.length()-sb2.length()-1-i,s);
         }
         if(carry == 1)
         sb1.insert(0, '1');
         ListNode dummy = new ListNode(Integer.MIN_VALUE);
         ListNode cur = dummy;
         for(int i = 0; i < sb1.length(); i++){
         cur.next = new ListNode((int)(sb1.charAt(i) - '0'));
         cur = cur.next;
         }
         return dummy.next;
         */
        StringBuffer sb = new StringBuffer();
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();
        int carry = 0;
        while(l1!=null){
            st1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            st2.push(l2.val);
            l2 = l2.next;
        }
        while(!st1.isEmpty()&&!st2.isEmpty()){
            int d1 = st1.pop();
            int d2 = st2.pop();
            sb.insert(0,(char)((d1+d2+carry)%10+'0'));
            carry = (d1 + d2 + carry)/10;
        }
        while(!st1.isEmpty()){
            int d = st1.pop();
            //System.out.println(d);
            sb.insert(0,(char)((d+carry)%10+'0'));
            carry = (d + carry)/10;
        }
        while(!st2.isEmpty()){
            int d = st2.pop();
            sb.insert(0,(char)((d+carry)%10+'0'));
            carry = (d + carry)/10;
        }
        if(carry == 1)
            sb.insert(0, '1');
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;
        for(int i = 0; i < sb.length(); i++){
            cur.next = new ListNode((int)(sb.charAt(i) - '0'));
            cur = cur.next;
        }
        return dummy.next;
    }
}
