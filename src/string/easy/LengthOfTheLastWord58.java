package string.easy;

public class LengthOfTheLastWord58 {
    public int lengthOfLastWord(String s) {
        s =s.trim();
        String words[] = s.split(" ");
        return words[words.length-1].length();
    }

    public int lengthOfLastWord2(String s) {
        int length=0;
        boolean counting =false;
        for(char c: s.toCharArray()){
            if(c!=' '){
                if(!counting){
                    counting=true;
                    length=1;
                }else{
                    length++;
                }
            }else{
                counting=false;
            }
        }
        return length;
    }
}
