/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode root = new RandomListNode(head.label);
        map.put(head, root);
        while(head.next != null){
            if(!map.containsKey(head.next)) {
                map.put(head.next, new RandomListNode(head.next.label));
            }
            (map.get(head)).next = (map.get(head.next));
            
            if(head.random!=null && !map.containsKey(head.random)) {
                map.put(head.random, new RandomListNode(head.random.label));
            }
            (map.get(head)).random = map.get(head.random);
            head = head.next;
        }
        if(head.random!=null && !map.containsKey(head.random)) {
            map.put(head.random, new RandomListNode(head.random.label));
        }
        (map.get(head)).random = map.get(head.random);
        return root;
    }
}
