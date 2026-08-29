class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int stone:stones){
            pq.offer(stone);
        }
        while(!pq.isEmpty() && pq.size()>=2){
            int x=pq.poll();
            int y=pq.poll();
            int z = Math.abs(x-y);
            if(z!=0){
                pq.offer(z);
            }
        }
        if(pq.isEmpty())
            return 0;
        return pq.peek();
    }
}
