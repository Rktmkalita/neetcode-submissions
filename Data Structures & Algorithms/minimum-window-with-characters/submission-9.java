class Solution {
    int[] tArr = new int[256];
    int[] sArr = new int[256];
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        String res="";
        int l=0;
        int r;
        int minLen=Integer.MAX_VALUE;
        for(char ch : t.toCharArray()){
            tArr[ch]++;
        }
        for(r=0;r<s.length();r++){
            if(tArr[s.charAt(r)]!=0){
                sArr[s.charAt(r)]++;
            }
            if(t.length()>r-l+1) continue;
            while(check()){
                int len = r-l+1;
                if(minLen>len){
                    res = s.substring(l,r+1);
                    minLen=len;
                }
                sArr[s.charAt(l)]--;
                l++;
            }
        }
        return res;
    }

    private boolean check(){
        for(int i=0;i<256;i++){
            if(tArr[i]!=0 && sArr[i]<tArr[i]){
                return false;
            }
        }
        return true;
    }
}
