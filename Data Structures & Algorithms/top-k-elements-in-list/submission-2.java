class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
            Comparator.comparingInt(Map.Entry::getValue)
        );
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(Map.Entry es : map.entrySet()){
            pq.add(es);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] arr = new int[k];
        for(int i=0; i<k; i++){
            arr[i]=pq.poll().getKey();
        }
        return arr;
    }
}
