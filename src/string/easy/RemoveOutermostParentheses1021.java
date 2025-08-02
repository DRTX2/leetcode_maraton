package string.easy;

public class RemoveOutermostParentheses1021 {
    public String removeOuterParentheses(String s) {
        if(s.length()<=1) return s;
        StringBuilder st = new StringBuilder();
        int start= 0, end=0, sum=0;
         while(end<s.length()){
            char c= s.charAt(end);
            if(c=='(') sum++;
            else sum--;

            if(sum==0) {
                st.append(s.substring(start+1,end));
                start =end+1;
            }
            end++;
        }
        return st.toString();
    }
}
