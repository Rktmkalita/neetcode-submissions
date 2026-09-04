class Solution {
    int[] tArr = new int[52];
    int[] sArr = new int[52];
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        String res="";
        int l=0;
        int r;
        int minLen=Integer.MAX_VALUE;
        for(char ch : t.toCharArray()){
            tArr[index(ch)]++;
        }
        for(r=0;r<s.length();r++){
            char c = s.charAt(r);
            int idx = index(c);
            if(tArr[idx]!=0){
                sArr[idx]++;
            }
            while(check()){
                int len = r-l+1;
                if(minLen>len){
                    res = s.substring(l,r+1);
                    minLen=len;
                }
                idx = index(s.charAt(l));
                sArr[idx]--;
                l++;
            }
        }
        return res;
    }

    private boolean check(){
        for(int i=0;i<52;i++){
            if(tArr[i]!=0 && sArr[i]<tArr[i]){
                return false;
            }
        }
        return true;
    }

    private int index(char c){
        if(c>='a'){
            return c-'a';
        }
        return c-'A'+26;
    }
}
