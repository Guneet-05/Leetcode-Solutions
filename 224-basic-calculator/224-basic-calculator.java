class Solution {
    
    public int precedence(char op) {
        if(op == '*' || op == '/') return 2;
        else if(op == '+' || op == '-') return 1;
        return 0;
    }
    
    public int operation(int a, char op, int b) {
        if(op == '+') {
            return a+b;
        } else if(op == '-') {
            return a-b;
        } else if(op == '*') {
            return a*b;
        }
        
        return a/b;
    }
    
    public String refine(String exp) {
        StringBuilder str = new StringBuilder("");
        
        for(int i=0;i<exp.length();i++) {
            char ch = exp.charAt(i);
            
            if(ch == '+') {
                if(str.length() == 0 || str.charAt(str.length() -1) == '(') {
                    str.append("0+");
                } else if(str.charAt(str.length() -1) == '+' || str.charAt(str.length() -1) == '-') continue;
                
                else str.append("+");
            } else if(ch == '-') {
                if(str.length() == 0 || str.charAt(str.length() -1) == '(') {
                    str.append("0-");
                } else if(str.charAt(str.length() -1) == '-') {
                    str.setCharAt(str.length()-1,'+');
                } else if(str.charAt(str.length() -1) == '+') {
                    str.setCharAt(str.length()-1,'-');
                } else str.append("-");
            } else str.append(ch);
        }
        
        return str.toString();
    }
    
    public int calculate(String s) {
        s = refine(s);
        
        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            
            if(ch >= '0' && ch<='9') {
                int num = 0;
                while(i < s.length() && s.charAt(i) >='0' && s.charAt(i) <= '9') {
                    num = num * 10 + (s.charAt(i) -'0');
                    i++;
                }
                operands.push(num);
                i--;
            } else if(ch == ' ') {
                
            } else if(ch == '(') {
                operators.push(ch);
            } else if(ch == ')') {
                while(operators.size() > 0 && operators.peek() != '(') {
                    int B = operands.pop();
                    int A = operands.pop();
                    char op = operators.pop();
                    int res  = operation(A,op,B);
                    operands.push(res);
                }
                operators.pop();
            } else {
                if(operators.size() == 0) {
                    operators.push(ch);
                    continue;
                }
                
                if(precedence(ch) > precedence(operators.peek())) {
                    operators.push(ch);
                } else {
                    while(operators.size() > 0 && precedence(ch) <= precedence(operators.peek())) {
                        int B = operands.pop();
                        int A = operands.pop();
                        char op = operators.pop();
                        int res  = operation(A,op,B);
                        operands.push(res);
                    }
                    operators.push(ch);
                }
            }
        }
        
        while(operators.size() > 0) {
            int B = operands.pop();
            int A = operands.pop();
            char op = operators.pop();
            int res  = operation(A,op,B);
            operands.push(res);
        }
        
        return operands.peek();
    }
}