class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a,b)->Double.compare(b[2],a[2])
        );
        for(int i=0;i < points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            double distance = Math.sqrt(x*x + y*y);
            double[] point = new double[3];
            point[0]=x;
            point[1]=y;
            point[2]=distance;
            pq.offer(point);
            if(pq.size()>k){
                pq.poll();
            }
        }
        if(pq.isEmpty()) return new int[1][1];
        int[][] res = new int[pq.size()][2];
        int i=0;
        while(!pq.isEmpty()){
            double[] point = pq.poll();
            res[i][0] = (int)point[0];
            res[i][1] = (int)point[1];
            i++;
        }
        return res;
    }
}
