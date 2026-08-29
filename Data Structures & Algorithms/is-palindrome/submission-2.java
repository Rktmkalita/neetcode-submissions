class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        System.out.println(s);
        int left=0, right=s.length()-1;
        while(left<=right){
            char chLeft = s.charAt(left);
            char chRight = s.charAt(right);
            System.out.println(chLeft + " = " + chRight);
            if((chLeft<'a' || chLeft>'z') && !Character.isDigit(chLeft)){
                System.out.println("Skipping "+chLeft);
                left++;
                continue;
            }
            if((chRight<'a' || chRight>'z') && !Character.isDigit(chLeft)){
                System.out.println("Skipping "+chRight);
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
