class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())   return "";
        int[] sArr = new int[256];
        int[] tArr = new int[256];
        int len = Integer.MAX_VALUE;
        int leftIdx=-1, rightIdx=-1;
        for(int i=0;i<t.length();i++){
            tArr[t.charAt(i)]++;
        }
        int l=0, r=0, matchCount = 0;
        while(r<s.length()){
            sArr[s.charAt(r)]++;
            if(sArr[s.charAt(r)]<=tArr[s.charAt(r)]){
                matchCount++;
            }
            while(l<=r && matchCount==t.length()){
                if(r-l+1<len){
                    len = r-l+1;
                    leftIdx = l;
                    rightIdx = r+1;
                }
                sArr[s.charAt(l)]--;
                if(sArr[s.charAt(l)]<tArr[s.charAt(l)]){
                    matchCount--;
                }
                l++;
            }
            r++;
        }
        if(leftIdx==-1 || rightIdx==-1) return "";
        return s.substring(leftIdx,rightIdx);
    }
}
