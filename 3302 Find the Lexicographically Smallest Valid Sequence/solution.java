class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] suffix = new int[m];
        Arrays.fill(suffix, -1);
        int j = m-1;
        for (int i=n-1; i>=0 && j>=0; i--){
                if (word1.charAt(i) == word2.charAt(j)) {
                suffix[j] = i;
                j--;
            }
        }
        int [] ans = new int[m];
        int size =0;
        boolean canSkip = true;
        j=0;
        for (int i=0; i<n && j<m; i++){
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[size++] = i;
                j++;
            } else if (canSkip && (j == m-1|| i<suffix[j+1])) {
                canSkip = false;
                ans[size++] = i;
                j++;
            }
        }
        if (j == m){
            return ans;
        }
        return new int[0];
    }
}