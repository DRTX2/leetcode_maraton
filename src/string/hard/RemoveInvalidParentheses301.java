package string.hard;

import java.util.ArrayList;
import java.util.List;
/*
* Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
* Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.
* TODO: Check again, it's too crazy
*/
public class RemoveInvalidParentheses301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> output = new ArrayList<>();
        removeHelper(s,output, 0,0,'(',')');
        return output;
    }

    private void removeHelper(String s, List<String> output, int iStart, int jStart, char openParen, char closedParen){
        int numOpenParen=0, numClosedParen=0;
        for (int i = iStart; i < s.length(); i++) {

            if(s.charAt(i)==openParen) numOpenParen++;
            if(s.charAt(i)==closedParen) numClosedParen++;

            // check if we have an extra closed parentheses, that needs to be removed.
            if(numClosedParen>numOpenParen){
                // now try to removing one at each position, skipping duplicates
                for (int j = jStart; j <= i; j++)
                    if(s.charAt(j)==closedParen && (j==jStart || s.charAt(j-1)!= closedParen))
                        //* Recursion: iStart = i since we now have valid # closed parenthesis thru i. jStart = j prevents duplicates
                        removeHelper(s.substring(0,j) + s.substring(j+1, s.length() ), output, i, j, openParen,closedParen);
                    return; // stop, recursive calls from rest of the string needs to be handle

            }
        }
        // no invalid closedParentheses has been detected, so, at this time just check opposite direction, or reverse back to original direction
        String reversed = new StringBuilder(s).reverse().toString();
        if(openParen=='(')
            removeHelper(reversed, output, 0, 0, ')','(');// invert open caracter
        else
            output.add(reversed);
    }
}
