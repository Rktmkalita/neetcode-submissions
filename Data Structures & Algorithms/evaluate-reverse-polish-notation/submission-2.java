class Solution {
    Set<String> set = new HashSet<>(List.of("*","-","+","/"));
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String t : tokens){
            if(set.contains(t)){
                int a=stack.pop();
                int b=stack.pop();
                stack.push(calculate(a,b, t));
            }else{
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }
    private int calculate(int a, int b, String t){
        if(t.equals("-")){
            return b-a;
        }else if(t.equals("+")){
            return a+b;
        }else if(t.equals("*")){
            return a*b;
        }else{
            return b/a;
        }
    }
}
