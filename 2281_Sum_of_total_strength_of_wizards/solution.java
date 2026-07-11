class Solution {
    static final int MOD = 1_000_000_007;
    public int totalStrength(int[] strength) {
        Stack <Integer> stack = new Stack<>();
        long ans = 0;
        long[] prefix = new long[strength.length+1];
        long[] prefixprefix = new long[strength.length+2];
        for (int i=0; i<strength.length; i++){
            prefix[i+1] = prefix[i] + strength[i];
        }
        for (int i=0; i<=strength.length; i++){
            prefixprefix[i+1] = prefixprefix[i] + prefix[i];
        }
        for (int i=0; i<=strength.length; i++){
            while (!stack.isEmpty() && (i == strength.length || strength[stack.peek()] >= strength[i])){
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                long leftcount = mid - left;
                long rightcount = right - mid;
                long rightsum = (prefixprefix[right+1]-prefixprefix[mid+1]+MOD) % MOD;
                long leftsum = (prefixprefix[mid+1]-prefixprefix[left+1]+MOD) % MOD;
                long total = (rightsum * leftcount %MOD - leftsum * rightcount %MOD + MOD) % MOD;
                ans = (ans + total * strength[mid]) % MOD;
            }
            stack.push(i);
        }
        return (int)ans;
    }
}