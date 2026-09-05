class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temp.length];
        for(int i=0;i<temp.length;i++){
            while(!stack.isEmpty() && stack.peek()[0]<temp[i]){
                int[] t = stack.peek();
                res[t[1]]=i-t[1];
                stack.pop();
            }
            int[] t = new int[2];
            t[0]=temp[i];
            t[1]=i;
            stack.add(t);
        }
        return res;
    }
}
