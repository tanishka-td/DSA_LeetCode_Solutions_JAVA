lass Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();;
        int ans = 0;
        for (int i=0; i<height.length; i++){
            int curr = height[i];
            while (!stack.isEmpty() && curr>height[stack.peek()]){
                int bottom = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int width = i-stack.peek() -1;
                int wheight = Math.min(height[stack.peek()], height[i]) - height[bottom];
                ans += width * wheight;
            }
            stack.push(i);
        }
        return ans;
    }
}