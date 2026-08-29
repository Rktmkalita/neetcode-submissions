class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int[][] ps = new int[n][2];
        for(int i=0;i<n;i++){
            ps[i][0]=position[i];
            ps[i][1]=speed[i];
        }
        Arrays.sort(ps, (i,j)->Integer.compare(j[0],i[0]));
        Stack<Double> times = new Stack<>();
        for(int i=0;i<n;i++){
            double time = (double)(target-ps[i][0])/ps[i][1];
            times.push(time);
            if(times.size()>=2 && times.get(times.size()-2)>=time){
                times.pop();
            }
        }
        return times.size();
    }
}
