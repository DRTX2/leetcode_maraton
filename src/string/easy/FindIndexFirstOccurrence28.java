package string.easy;

public class FindIndexFirstOccurrence28 {
    public int strStr(String haystack, String needle) {
     int left =0;
     int right =0;
     int start = 0;
     while(left <haystack.length() && right < needle.length()){
        if (haystack.charAt(left)== needle.charAt(right)){
            left++;
            right++;
        }else{
            left=++start;
            right=0;
        }
     }
     if(right==needle.length()) return left-needle.length();
     return -1;
    }

}
