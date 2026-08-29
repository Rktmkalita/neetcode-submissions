class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch:s.toCharArray()){
            switch(ch){
                case ')':
                    if(stack.isEmpty() || stack.peek()!='(') return false;
                    stack.pop();
                    break;
                case '}':
                    if(stack.isEmpty() || stack.peek()!='{') return false;
                    stack.pop();
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek()!='[') return false;
                    stack.pop();
                    break;
                default:
                    stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
