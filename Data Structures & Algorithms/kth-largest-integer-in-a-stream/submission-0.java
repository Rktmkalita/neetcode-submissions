class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>((a,b)->Integer.compare(a,b));
        this.k = k;
        for(int n : nums){
            pq.offer(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
}
