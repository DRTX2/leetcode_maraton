package string.medium;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses241 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res=new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char oper=expression.charAt(i);
            if(oper=='+' || oper=='-' || oper=='*'){// 2*3-4
                // the 2 sides
                List<Integer> s1 =diffWaysToCompute(expression.substring(0,i));// 2
                List<Integer> s2 =diffWaysToCompute(expression.substring(i+1));// 3*4
                for(int a:s1){
                    for(int b:s2) {
                        if(oper=='+') res.add(a+b);
                        else if(oper=='-') res.add(a-b);
                        else if(oper=='*') res.add(a*b);
                    }
                }
            }
        }

        if(res.isEmpty()) res.add(Integer.parseInt(expression));
        return res;
    }

    // TODO: revisar
    // mejor pero no entiendo xd
    public List<Integer> diffWaysToCompute2(String expression) {
        List<Integer> nums = new ArrayList<>();
        List<Character> exps = new ArrayList<>();
        int current = 0;
        for (char c: expression.toCharArray()) {
            int num = c-'0'; // now it's a number or an operation
            if (num < 0 || num > 9) {
                nums.add(current);
                exps.add(c);
                current = 0;
            } else {
                current = current*10+num;
            }
        }
        nums.add(current);
        int n = nums.size();
        List<Integer>[][] dp = new ArrayList[n][n];
        if (n != exps.size()+1) return new ArrayList<>();
        return helper(nums, exps, dp, 0, n-1);
    }
    private List<Integer> helper(List<Integer> nums, List<Character> exps, List<Integer>[][] dp, int start, int end) {
        if (start > end ) return new ArrayList<>();
        if (dp[start][end] != null) return dp[start][end];
        List<Integer> result = new ArrayList<>();
        dp[start][end] = result;
        if (start == end) {
            result.add(nums.get(start));
            return result;
        }
        for(int i=start; i<end; i++) {
            List<Integer> left = helper(nums, exps, dp, start, i);
            List<Integer> right = helper(nums, exps, dp, i+1, end);
            char exp = exps.get(i);
            for (int n1: left) {
                for (int n2: right) {
                    result.add(compute(n1, n2, exp));
                }
            }
        }
        return result;
    }
    private int compute(int num1, int num2, char exp) {
        if (exp == '+') return num1+num2;
        if (exp == '-') return num1-num2;
        if (exp == '*') return num1*num2;
        if (exp == '/') return num1/num2;
        throw new IllegalArgumentException("Invalid Expression");
    }

}
