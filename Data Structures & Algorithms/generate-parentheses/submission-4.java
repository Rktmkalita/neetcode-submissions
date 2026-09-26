class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), n, 0, 0);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder sbr, int n, int closeBracket, int openBracket){
        if(openBracket+closeBracket==2*n){
            res.add(sbr.toString());
            return;
        }
        if(openBracket<n){
            sbr.append("(");
            backtrack(res, sbr, n, closeBracket, openBracket+1);
            sbr.setLength(sbr.length()-1);
        }
        if(closeBracket < openBracket){
            sbr.append(")");
            backtrack(res, sbr, n, closeBracket+1, openBracket);
            sbr.setLength(sbr.length()-1);
        }
    }
}
