class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())   return "";
        int[] sArr = new int[256];
        int[] tArr = new int[256];
        int len = Integer.MAX_VALUE;
        String result = "";
        for(int i=0;i<t.length();i++){
            tArr[t.charAt(i)]++;
        }
        int l=0, r=0;
        while(r<s.length()){
            sArr[s.charAt(r)]++;
            while(l<=r && checkEqual(sArr,tArr)){
                len = Math.min(r-l+1,len);
                result = s.substring(l,r+1);
                sArr[s.charAt(l)]--;
                l++;
            }
            r++;
        }
        return result;
    }

    private boolean checkEqual(int[] sArr, int[] tArr){
        for(int i=0;i<256;i++){
            if(tArr[i]!=0 && tArr[i]>sArr[i])
                return false;
        }
        return true;
    }
}
