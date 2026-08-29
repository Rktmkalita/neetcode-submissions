class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sbr = new StringBuilder();
        backtrack(result, sbr, 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder sbr, int countOpen, int countClose, int n){
        if(countOpen==n && countClose==n){
            result.add(sbr.toString());
            return;
        }
        if(countOpen<n){
            sbr.append('(');
            backtrack(result, sbr, countOpen+1, countClose, n);
            sbr.deleteCharAt(sbr.length()-1);
        }
        if(countClose<countOpen){
            sbr.append(')');
            backtrack(result, sbr, countOpen, countClose+1, n);
            sbr.deleteCharAt(sbr.length()-1);
        }
    }
}
