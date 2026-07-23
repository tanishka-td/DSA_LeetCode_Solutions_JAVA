class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0; i<n; i++) {
            int curr = asteroids[i];
            boolean alive = true;
            while (!stack.isEmpty() && stack.peek()>0 && curr<0){
                if (stack.peek() < -curr) {
                    stack.pop();
                } else if (stack.peek() > -curr) {
                    alive = false;
                    break;
                } else {
                    stack.pop();
                    alive = false;
                    break;
                }
            }
            if (alive) {
                stack.push(curr);
            }
        }
        int[] ans = new int[stack.size()];
        for (int i=ans.length-1; i>=0; i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
}