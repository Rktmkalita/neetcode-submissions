class Solution {
    Map<Character, List<Character>> chars;
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")) return new ArrayList<>();
        initialiseMap();
        List<String> res = new ArrayList<>();
        backtrack(res, digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(List<String> res, String digits, int i, StringBuilder sbr){
        if(sbr.length()==digits.length()){
            res.add(sbr.toString());
            return;
        }
        
        for(char ch : chars.get(digits.charAt(i))){
            sbr.append(ch);
            backtrack(res, digits, i+1, sbr);
            sbr.setLength(sbr.length()-1);
        }
    }

    private void initialiseMap(){
        chars = new HashMap<>();
        chars.put('2', List.of('a','b','c'));
        chars.put('3', List.of('d','e','f'));
        chars.put('4', List.of('g','h','i'));
        chars.put('5', List.of('j','k','l'));
        chars.put('6', List.of('m','n','o'));
        chars.put('7', List.of('p','q','r','s'));
        chars.put('8', List.of('t','u','v'));
        chars.put('9', List.of('w','x','y','z'));
    }
}
