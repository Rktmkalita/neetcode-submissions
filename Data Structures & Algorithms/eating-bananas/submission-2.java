class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxVal = Arrays.stream(piles).max().getAsInt();
        if(n==h){
            return maxVal;
        }
        int res = maxVal;
        int l=1, r=maxVal;
        while(l<=r){
            int k = (l+r)/2;
            long time=0;
            for(int pile:piles){
                time+=pile/k;
                if(pile%k!=0) time++;
            }
            if(time<=h){
                res=k;
                r=k-1;
            }else{
                l=k+1;
            }
        }
        return res;
    }
}
