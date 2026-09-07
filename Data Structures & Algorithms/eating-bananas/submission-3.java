class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i:piles){
            max=Math.max(i,max);
        }
        int res=0;
        int l=1,r=max;
        while(l<=r){
            int mid = l+(r-l)/2;
            int count=0;
            for(int i : piles){
                int val = i/mid;
                count+=val;
                if(i%mid!=0){
                    count++;
                }
            }
            if(count<=h){
                res=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return res;
    }
}
