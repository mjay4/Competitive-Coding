class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        
        for(int i = 0; i<gifts.length; i++){
            pq.add(gifts[i]);
        }
        
        long sum = 0;
        while(k-->0){
            pq.add((int)Math.sqrt(pq.remove()));
        }
        
        while(pq.size()>0){
            sum+=pq.remove();
        }

        return sum;
    }
}