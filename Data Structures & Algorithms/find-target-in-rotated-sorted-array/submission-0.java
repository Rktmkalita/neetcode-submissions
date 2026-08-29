class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int res = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid]==target){
                res=mid;
                break;
            }
            if(nums[mid]<=nums[r]){
                if(target>nums[mid] && target<=nums[r])
                    l=mid+1;
                else
                    r=mid-1;
            }else{
                if(target>=nums[l] && target<nums[mid])
                    r=mid-1;
                else
                    l=mid+1;
            }
        }
        return res;
    }
}
