class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int slow = 0;
        int fast = 0;
        while(true){
            slow=nums[slow];
            fast=nums[nums[fast]];
            if(slow==fast) break;
        }
        slow=0;
        while(true){
            slow = nums[slow];
            fast = nums[fast];
            if(slow==fast) return slow;
        }
    }
}
