class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int l=0, r=s.length()-1;
        while(l<r){
            while(l<r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
                // System.out.println(s.charAt(l));
            }
            while(l<r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
                // System.out.println(s.charAt(l) + " " + s.charAt(r));
            }
            if(s.charAt(l)!=s.charAt(r)){
                // System.out.println("comp "+s.charAt(l) + " " + s.charAt(r));
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
