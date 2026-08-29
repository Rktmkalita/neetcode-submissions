class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && stack.peek()[0]<temperatures[i]){
                int idx = stack.pop()[1];
                result[idx]=i-idx;
            }
            stack.push(new int[]{temperatures[i],i});
        }
        return result;
    }
}
