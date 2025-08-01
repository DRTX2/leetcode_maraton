package string.medium;

import java.util.Stack;
/*
* Given a balanced parentheses string s, return the score of the string.
* The score of a balanced parentheses string is based on the following rule:
* "()" has score 1.
* AB has score A + B, where A and B are balanced parentheses strings.
* (A) has score 2 * A, where A is a balanced parentheses string.
* **/
public class ScoreOfParentheses856 {
    public static int scoreOfParentheses(String s) {
        int count = 0 , ans = 0;
        for (int j = 0; j < s.length(); j++) {
            if(s.charAt(j)=='(' && s.charAt(j+1)==')'){
                ans+=Math.pow(2, count);
                j++;
            }else if(s.charAt(j)=='(')
                count++;
            else
                count--;
        }
        return ans;
    }

    public int secondAttemp(String s){
        Stack<Integer> st = new Stack<>();
        int score = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if(ch=='('){
                st.push(score);
                score = 0;
            }else {
                score= st.pop() + Math.max(2*score,1);
            }
        }
        return score;
    }
}
