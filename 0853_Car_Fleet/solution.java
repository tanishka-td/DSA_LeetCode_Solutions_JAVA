class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int ans=0;
        Deque<Double> stack = new ArrayDeque<>();
        Integer[] indices = new Integer[n];
        for (int i=0; i<n; i++){
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> position[b] - position[a]);
        for (int i: indices){
            double time = (double)(target - position[i]) / speed[i];
            if (stack.isEmpty() || time > stack.peek()){
                stack.push(time);
                ans++;
            }
        }
        return ans;
    }
}