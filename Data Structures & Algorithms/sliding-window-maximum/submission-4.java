class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n= nums.length;
        int result[] = new int[n-k+1];
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Integer,Integer>>(){
            public int compare(Pair<Integer,Integer> a, Pair<Integer,Integer> b){
                return b.getKey()-a.getKey();
            }
        });
        int idx = 0;
        for(int i=0;i<n;i++){
            pq.offer(new Pair(nums[i],i));
            if(i>=k-1){
                while(pq.peek().getValue()<=i-k){
                    pq.poll();
                }
                result[idx++]=pq.peek().getKey();
            }
        }
        return result;
    }

}
