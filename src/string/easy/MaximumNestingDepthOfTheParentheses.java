package string.easy;

public class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        int max = 0, open=0, close=0, sum=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('){
                open++;
                if(open>max){
                    max=open;
                }
            }else if(c==')'){
                open--;
            }
        }
        return max;
    }
}
