class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] alphabets = new int[26];
        for(char ch : tasks){
            alphabets[ch-'A']++;
        } 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : alphabets){
            if(i==0)
                continue;
            pq.offer(i);
        }
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        while(!pq.isEmpty() || !queue.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                int taskCount = pq.poll();
                taskCount--;
                if(taskCount>0){
                    queue.offer(new int[]{taskCount, time+n});
                }
            }
            if(!queue.isEmpty() && queue.peek()[1]==time){
                pq.offer(queue.poll()[0]);
            }
        }
        return time;
    }
}
