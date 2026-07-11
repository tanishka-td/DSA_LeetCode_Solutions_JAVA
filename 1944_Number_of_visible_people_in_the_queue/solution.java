class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[heights.length];
        for (int i=heights.length-1; i>=0; i--){
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]){
                stack.pop();
                ans[i]++;
            }
            if (!stack.empty()){
                ans[i]++;
            }
            stack.push(i);
        }
        return ans;
    }
}