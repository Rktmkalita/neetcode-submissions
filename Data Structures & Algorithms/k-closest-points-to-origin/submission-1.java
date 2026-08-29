class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<double[]> pq = new PriorityQueue<>((i,j)->Double.compare(j[0],i[0]));
        for(int i=0;i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];
            double distance = x*x + y*y;
            System.out.println(distance);
            pq.offer(new double[]{distance,i});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int i = 0;
        while(!pq.isEmpty()){
            int idx = (int)pq.poll()[1];
            result[i][0]=points[idx][0];
            result[i][1]=points[idx][1];
            i++;
        }
        return result;
    }
}
