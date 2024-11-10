class MedianFinder {

    PriorityQueue<Integer> larger;
    PriorityQueue<Integer> smaller;
    private boolean even = true;

    public MedianFinder() {
        larger = new PriorityQueue<>();
        smaller = new PriorityQueue<>(Collections.reverseOrder());      
    }
    
    public void addNum(int num) {
        smaller.add(num);
        larger.add(smaller.poll());
        if (smaller.size() < larger.size()) {
            smaller.add(larger.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        return even ? (larger.peek()+smaller.peek())/2.0 : smaller.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */