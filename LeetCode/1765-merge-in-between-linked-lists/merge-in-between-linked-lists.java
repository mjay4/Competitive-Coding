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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur = list1;
        ListNode org = cur;
        for (int i=1; i<=b;i++){
            if (i<a) {
                cur = cur.next;
            } else if (i == a) {
                org = cur.next;
                cur.next = list2;
                org = org.next;
                if (a == b) {
                    while (list2.next !=null) list2 = list2.next;
                    list2.next = org;
                }
            } else if (i<b) {
                org = org.next;
            } else if (i == b){
                while (list2.next !=null) list2 = list2.next;
                list2.next = org.next;
            }
        }     
        return list1;
    }
}