class MedianFinder {

    PriorityQueue<Integer> pq;

    public MedianFinder() {
        pq = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        pq.offer(num);
    }
    
    public double findMedian() {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> temp = new PriorityQueue<>(pq);
        while(!temp.isEmpty()){
            list.add(0,temp.poll());
        }
        int n = list.size();
        if(n==1)    return list.get(0);
        if(n%2!=0){
            return list.get(n/2);
        }else{
            // System.out.println(list.get(n/2) + "," + list.get(n/2 - 1));
            return (double)(list.get(n/2) + list.get(n/2 - 1))/2;
        }
    }
}
