class Solution {
    public int characterReplacement(String s, int k) {
        int l=0,r=0;
        int maxFrq = 0;
        int res = 0;
        int[] charMap = new int[26];
        while(r<s.length()){
            char ch = s.charAt(r);
            int len = r-l+1;
            charMap[ch-'A']++;
            maxFrq = findMax(charMap);
            if(len - maxFrq <= k){
                res = Math.max(res,len);
            }else{
                charMap[s.charAt(l)-'A']--;
                l++;
            }
            r++;
        }
        return res;
    }

    private int findMax(int[] arr){
        int max = 0;
        for(int n : arr){
            if(n>max) max=n;
        }
        return max;
    }
}
