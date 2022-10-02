/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) 
            return null;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(ListNode list : lists) {
            while(list!=null) {
                minHeap.add(list.val);
                //System.out.println("Loop 1: " + list.val);
                list = list.next;
            }
        }
        
        if(minHeap.isEmpty()) return null;
        
        ListNode ans = new ListNode(minHeap.poll());
        
        if(minHeap.isEmpty()) return ans; 
        
        ListNode node = new ListNode();
        ans.next = node;
        
        while(!minHeap.isEmpty()) {
            int min = minHeap.poll();
            node.val = min;
            //System.out.println("Loop 2: " + node.val);
            if(minHeap.isEmpty()) break;
            node.next = new ListNode();
            node = node.next;
        }
        
        return ans;
    }
}