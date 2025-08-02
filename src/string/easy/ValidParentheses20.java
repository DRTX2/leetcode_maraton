package string.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses20 {
    public boolean isValid(String s) {
        int capacity = s.length();
        if(capacity==0)   return true;
        if(capacity%2!=0)   return false;

        StringBuilder st= new StringBuilder(s);
        int i = 1 ;
        while(!st.isEmpty() && i<st.length()){
            char par= st.charAt(i);
            if(par ==')' || par=='}' || par == ']'){
                if(st.charAt(i-1)==getOposite(par)){
                    st.delete(i-1,i+1);
                    i=Math.max(i-1,1);
                }else{
                    return false;
                }
            }else{
                i++;
            }
        }
        return  st.isEmpty();
    }

    public char getOposite(char c) {
        switch (c) {
            case ')': return '(';
            case '}': return '{';
            case ']': return '[';
            default: return ' ';
        }
    }

    public boolean secondAttempt(String s){
        if(s.length()%2!=0) return false;
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping= new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');
        for (char c : s.toCharArray()){
            if(mapping.containsValue(c) ){
                stack.push(c);
            }else if (mapping.containsKey(c)){
                    if(stack.isEmpty() || mapping.get(c)!= stack.pop())
                        return  false;
            }
        }
        return stack.isEmpty();// ((( -> false
    }


    public boolean third(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!stack.isEmpty()) {
                char last = stack.peek();
                if (isPair(last, cur)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(cur);
        }

        return stack.isEmpty();
    }

    private boolean isPair(char last, char cur) {
        return (last == '(' && cur == ')') ||
                (last == '{' && cur == '}') ||
                (last == '[' && cur == ']');
    }
}

