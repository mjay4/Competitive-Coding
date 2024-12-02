class Solution {
    public int trap(int[] height) {
        int left =0;
        int len = height.length;
        int mxl[] = new int[len];
        int mxr[] = new int[len];
        int min[] = new int[len];
        int res=0;
        if(len==0)
             return res;
        mxl[0] = height[0];
        mxr[len-1] = height[len-1];
        
        for(int i =len-2;i>=0;i--)
            mxr[i] = height[i]>mxr[i+1]?height[i]:mxr[i+1];
        min[0] = Math.min(mxr[0],mxl[0]);
        res+= min[0]>height[0] ? min[0]-height[0] : 0;
        for(int i =1;i<len;i++){
            mxl[i] = height[i]>mxl[i-1]?height[i]:mxl[i-1];
            min[i] = Math.min(mxr[i],mxl[i]);
            res+= min[i]>height[i] ? min[i]-height[i] : 0;
        }
        
        return res;
    }
}