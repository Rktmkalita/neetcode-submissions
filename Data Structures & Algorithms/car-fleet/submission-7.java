class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Stack<Double> stack = new Stack<>();
        double[][] cars = new double[n][2];
        for(int i=0;i<n;i++){
            cars[i][0]=position[i];
            cars[i][1]=(double)(target-position[i])/speed[i];
        }
        Arrays.sort(cars, Comparator.comparingDouble(a->-a[0]));
        for(int i=0;i<n;i++){
            if(stack.isEmpty() || stack.peek()<cars[i][1]){
                stack.push(cars[i][1]);
            }
        }
        return stack.size();
    }
}
