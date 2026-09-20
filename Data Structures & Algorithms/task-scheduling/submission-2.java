class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for(char ch : tasks){
            arr[ch-'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Collections.reverseOrder()
        );
        for(int i=0; i<26; i++){
            if(arr[i]>0){
                pq.offer(arr[i]);
            }
        }
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(pq.isEmpty()){
                time = q.peek()[1];
            }else{
                int t = pq.poll()-1;
                if(t>0){
                    q.offer(new int[]{t, time+n});
                }
            }
            if(!q.isEmpty() && q.peek()[1]==time){
                pq.offer(q.poll()[0]);
            }
        }
        return time;
    }
}
