class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        for (int i=0; i<2*nums.length; i++){
            int idx = i%nums.length;
            while (!stack.isEmpty() && nums[idx]>nums[stack.peek()]){
                int index = stack.pop();
                ans[index] = nums[idx];
            }
            if (i<nums.length){
                stack.push(idx);
            }
        }
        return ans;
    }
}