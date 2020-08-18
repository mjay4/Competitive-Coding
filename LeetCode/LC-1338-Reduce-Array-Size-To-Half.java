class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++){ 
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        
        int size = arr.length;
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> -a.getValue() + b.getValue());
        pq.addAll(map.entrySet());
        int count = 0;
        int val =1;
        while(!pq.isEmpty()){
            Map.Entry<Integer,Integer> mp = pq.poll();
            //System.out.println(mp.getKey() + " " + mp.getValue());
            count += mp.getValue();
            if(size%2 ==0){
                if(count>=size/2)
                    break;
            }else{
                if(count > size/2)
                    break;
            }
            val++;
        }
        return val;
    }
}