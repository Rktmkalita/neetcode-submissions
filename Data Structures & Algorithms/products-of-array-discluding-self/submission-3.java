class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n+1];
        int[] right = new int[n+1];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        int j=0;
        for(int i=0;i<n;i++){
            left[j+1]=nums[i]*left[j];
            j++;
        }
        // Arrays.stream(left).forEach(System.out::println);
        j=n;
        for(int i=n-1;i>=0;i--){
            right[j-1]=nums[i]*right[j];
            j--;
        }
        System.out.println("split");
        // Arrays.stream(right).forEach(System.out::println);
        for(int i=0;i<n;i++){
            nums[i] = left[i] * right[i+1];
        }
        return nums;
    }
}  
