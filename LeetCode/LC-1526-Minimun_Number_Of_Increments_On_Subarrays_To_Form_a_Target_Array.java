class Solution {
    public int minNumberOperations(int[] target) {
        if(target.length==0)
            return 0;
        if(target.length==1)
            return target[0];
        int ans = target[target.length-1];
        int cur = 0;
        int low = target[0];
        for(int i =0;i<target.length;i++){
            if(target[i]<cur)
                ans+=cur-target[i];
            if(target[i]>low)
                low = target[i];
            cur = target[i];
        }
        return ans;
    }
}