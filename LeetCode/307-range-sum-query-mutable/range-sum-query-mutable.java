class NumArray {

    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    SegmentTreeNode root = null;

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }

    public SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start>end) return null;

        SegmentTreeNode node = new SegmentTreeNode(start,end);
        if (start == end) node.sum = nums[start];
        else {
            int mid = start + (end-start)/2;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid+1, end);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }
    
    public void update(int index, int val) {
        updateTree(root, index, val);
    }

    public void updateTree(SegmentTreeNode node, int idx, int val) {
        if (node.start == node.end) node.sum = val;
        else {
            int mid = node.start + (node.end-node.start)/2;
            if (idx<=mid) updateTree(node.left, idx, val);
            else updateTree(node.right, idx, val);
            node.sum = node.left.sum+node.right.sum;
        }
    }
    
    public int sumRange(int left, int right) {
        return sumRange(root, left, right);
    }

    public int sumRange(SegmentTreeNode node, int start, int end) {
        if (node.end == end && node.start == start) return node.sum;
        int mid = node.start + (node.end-node.start)/2;
        if (end <=mid) return sumRange(node.left, start, end);
        else if (start>=mid+1) return sumRange(node.right, start, end);
        else return sumRange(node.left, start, mid) + sumRange(node.right, mid+1, end);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */