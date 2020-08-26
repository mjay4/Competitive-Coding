class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = add(l1,l2,0);
       // add(l,l1,l2,0);
        return l;
    }
    public ListNode add(ListNode l1, ListNode l2, int carry){
        if(l1==null && l2==null && carry==0)
            return null;
        if(l1==null && l2==null && carry==0)
            return new ListNode(1);
        ListNode ans = new ListNode();
        int val = 0;
        if(l1!=null)
            val = l1.val;
        if(l2!=null)
            val+=l2.val;
        val+=carry;
        ans.val = val%10;
        carry = val/10;
        ans.next = add( (l1==null ? null : l1.next), (l2==null ? null : l2.next) ,carry);
        return ans;
    }
    
}