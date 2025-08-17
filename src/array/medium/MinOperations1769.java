package array.medium;


public class MinOperations1769 {
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        for(int i=0;i<boxes.length();i++){
            int count = 0;
            // check both sites
            for (int j = 0; j < boxes.length(); j++) {
                if(i!=j && boxes.charAt(j)=='1') count+=Math.abs(i-j);
            }
            ans[i]=count;
        }
        return ans;
    }
    public int[] minOperations2(String boxes) {
        int n = boxes.length();
        int[] distances = new int[n];

        int prefixCount= 0;
        int prefixSum=0;

        for(int i = 0 ; i< n ; i++){
            distances[i] = prefixCount*i -prefixSum;
            if(boxes.charAt(i)=='1'){
                ++prefixCount;
                prefixSum+=i;
            }
        }

        int suffixCount = 0;
        int suffixSum=0;
        for (int i = n-1; i >= 0 ; i--) {
            distances[i]+=suffixSum-suffixCount*i;
            if(boxes.charAt(i)=='1'){
                ++suffixCount;
                suffixSum+=i;
            }
        }
        return distances;
    }
}
