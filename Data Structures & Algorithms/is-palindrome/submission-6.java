class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int left=0, right=s.length()-1;
        while(left<=right){
            char chLeft = s.charAt(left);
            char chRight = s.charAt(right);
            if((chLeft<'a' || chLeft>'z') && !Character.isDigit(chLeft)){
                left++;
                continue;
            }
            if((chRight<'a' || chRight>'z') && !Character.isDigit(chLeft)){
                right--;
                continue;
            }
            if(chLeft!=chRight)
                return false;
            left++;
            right--;
        }
        return true;
    }
}
