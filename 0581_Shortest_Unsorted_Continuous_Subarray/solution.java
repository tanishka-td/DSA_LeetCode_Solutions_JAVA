class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        int right =0;
        int left =n;
        for (int i=0; i<n; i++){
            int curr = nums[i];
            while (!stack.isEmpty() && curr < nums[stack.peek()]){
                int index = stack.pop();
                left = Math.min(left, index);
            }
            stack.push(i);
        }
        stack.clear();
        for (int i=n-1; i>=0; i--){
            int curr = nums[i];
            while (!stack.isEmpty() && curr > nums[stack.peek()]){
                int index = stack.pop();
                right = Math.max(right, index);;
            }
            stack.push(i);
        }
        if (left == n) {
            return 0;
        }
        return right-left +1;
    }
}