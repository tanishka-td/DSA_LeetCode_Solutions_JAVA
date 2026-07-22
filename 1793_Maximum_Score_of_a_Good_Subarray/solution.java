class Solution {
    public int maximumScore(int[] nums, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        int n= nums.length;
        for (int i = 0; i <= n; i++) {
            int curr;
            if (i == n) {
                curr = 0;
            } else {
                curr = nums[i];
            }
            while (!stack.isEmpty() && curr <= nums[stack.peek()]) {
                int index = stack.pop();
                int left;
                if (stack.isEmpty()) {
                    left = -1;
                } else {
                    left = stack.peek();
                }
                int right = i;
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = right - left - 1;
                }
               if (left < k && k < right) {
                    ans = Math.max(ans, nums[index] * width);
                }
            }
            stack.push(i);
        }
        return ans;
    }
}