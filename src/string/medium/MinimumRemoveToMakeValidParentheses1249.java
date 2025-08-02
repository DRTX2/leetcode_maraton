package string.medium;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses1249 {
    /*
    *
    * Given a string s of '(' , ')' and lowercase English characters.
    * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
    * Formally, a parentheses string is valid if and only if:
        It is the empty string, contains only lowercase characters, or
        It can be written as AB (A concatenated with B), where A and B are valid strings, or
        It can be written as (A), where A is a valid string.


    * First, the entire string is traversed. As long as the number of closing parentheses doesn't exceed the number of opening ones, the character is added to the stack. If there are more closing than opening at any point, that character is skipped because it’s considered extra.
    * Then, to rebuild the string, the stack is emptied from the last to the first character. During this, there’s an if-else: if the current character is an opening parenthesis and there are still more opening than closing parentheses, it's discarded and the opening count is reduced. Otherwise, the character is added to the result.
    * Since the characters come out in reverse order from the stack, the final result is reversed before returning it.
*
    * **/
    public String minRemoveToMakeValid(String s) {
        int leftCount =0, rightCount=0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if(cur=='(') leftCount++;
            else rightCount++;

            if(rightCount>leftCount){//skip current parentheses
                rightCount--;
                continue;
            }else{
                stack.push(cur);
            }
        }

        // reconstruct string from the stack and counters
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            char curChar = stack.pop();
            // if there are more left parentheses than right parentheses continue the way and reduce that quantity adjusting the minimum valid string
            // Si hay más paréntesis abiertos (leftCount > rightCount) y el carácter actual es '(' → ese '(' se descarta (no se añade al resultado), y se reduce el contador de abiertos.
            if(leftCount>rightCount && curChar=='('){
                leftCount--;
            }else{
                result.append(curChar);
            }
        }
        return result.reverse().toString();
    }

}
