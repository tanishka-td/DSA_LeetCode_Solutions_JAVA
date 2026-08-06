class Solution {
    public int smallestNumber(int n, int t) {
        while (true) {
            int temp = n, p = 1;
            while (temp > 0) {
                p *= temp%10;
                temp /= 10;
            }
            if (p%t == 0) {
                return n;
            }
            n++;
        }
    }
}