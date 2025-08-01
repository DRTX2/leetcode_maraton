package string.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    //Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    public List<String> generateParenthesis(int n) {
        var ans = new ArrayList<String>();
        genParentheses(0, 0, n, "", ans);
        return ans;
    }

    private void genParentheses(int open, int close, int n, String par, List<String> ans){
        if(open==close && open+close==n*2){// 1===1 but you require 2 open parentheses not just a pair
            ans.add(par);
            return;
        };
        // left
        if(open<n)
            genParentheses(open+1, close, n, par+"(", ans);
        if(close<open)
        // right
            genParentheses(open, close+1, n, par+")", ans);
    }

}
