class Solution {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] ans = new double[n];
        Arrays.fill(ans, -1.0);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i= n-1; i>=0; i--) {
            while (!stack.isEmpty()) {
                int j = stack.peek();
                if (cars[i][1] <= cars[j][1]){
                    stack.pop();
                    continue;
                }
                double time = (double)(cars[j][0] - cars[i][0])/ (cars[i][1] - cars[j][1]);
                if (ans[j] > 0 && time > ans[j]) {
                    stack.pop();
                    continue;
                }
                ans[i] = time;
                break;
            }
            stack.push(i);
        }
        return ans;
    }
}