class Solution {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int val2 = Integer.MIN_VALUE;
        for (int i=nums.length-1; i>=0; i--){
            int curr = nums[i];
            if (curr < val2){
                return true;
            }
            while (!stack.isEmpty() && curr>stack.peek()){
                val2 = stack.pop();
            }
            stack.push(curr);
        }
        return false;
    }
}