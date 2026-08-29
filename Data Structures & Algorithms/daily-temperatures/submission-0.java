class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        result[n-1]=0;
        for(int i=0;i<n-1;i++){
            int max = 0;
            for(int j=i+1;j<n;j++){
                if(temperatures[j]>temperatures[i]){
                    max = j-i;
                    break;
                }
            }
            result[i]=max;
        }
        return result;
    }
}
