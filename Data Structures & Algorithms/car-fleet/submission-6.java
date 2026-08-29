class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        if(n<=1)
            return n;
        int[][] ps = new int[n][2];
        for(int i=0;i<n;i++){
            ps[i][0]=position[i];
            ps[i][1]=speed[i];
        }
        Arrays.sort(ps, (i,j)->Integer.compare(j[0],i[0]));
        int counter = 1;
        double prevTime = (double)(target-ps[0][0])/ps[0][1];
        for(int i=1;i<n;i++){
            double currTime = (double)(target-ps[i][0])/ps[i][1];
            if(prevTime<currTime){
                counter++;
                prevTime = currTime;
            }
        }
        return counter;
    }
}
