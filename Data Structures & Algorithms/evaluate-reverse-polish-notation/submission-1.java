class Solution {
    public int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> numbers = new Stack<>();
        for(String str:tokens){
            switch(str){
                case "+":
                    int b = numbers.pop();
                    int a = numbers.pop();
                    res = b+a;
                    numbers.push(res);
                    break;
                case "-":
                    b = numbers.pop();
                    a = numbers.pop();
                    res = a-b;
                    numbers.push(res);
                    break;
                case "/":
                    b = numbers.pop();
                    a = numbers.pop();
                    res = a/b;
                    numbers.push(res);
                    break;
                case "*":
                    b = numbers.pop();
                    a = numbers.pop();
                    res = b*a;
                    numbers.push(res);
                    break;
                default:
                    numbers.push(Integer.parseInt(str));
                    res = Integer.parseInt(str);
            }
        }
        return res;
    }
}
