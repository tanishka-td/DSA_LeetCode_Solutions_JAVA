class Solution {
    public long subArrayRanges(int[] nums) {    
            return sumMaximums(nums) - sumMinimums(nums);
    }
    long sumMinimums(int[] nums){
        Stack <Integer> stack = new Stack<>();
        long sumMin = 0;
        for(int i=0; i<=nums.length; i++){
            int curr;
            if(i == nums.length){
                curr = Integer.MIN_VALUE;
            }else{
                curr = nums[i];
            }
            while (!stack.isEmpty() && nums[stack.peek()] >= curr){
                int index = stack.pop();
                int left;
                if(stack.isEmpty()){
                    left = index + 1;
                }else{
                    left = index - stack.peek();
                }
                int right = i - index;
                sumMin += (long) nums[index] * left * right;
            }
            if(i < nums.length){
                stack.push(i);
            }
        }  
        return sumMin;
    }  
    long sumMaximums(int[] nums){
        Stack <Integer> stack = new Stack<>();
        long sumMax = 0;
        for(int i=0; i<=nums.length; i++){
            int curr;
            if(i == nums.length){
                curr = Integer.MAX_VALUE;
            }else{
                curr = nums[i];
            }
            while (!stack.isEmpty() && nums[stack.peek()] <= curr){
                int index = stack.pop();
                int left;
                if(stack.isEmpty()){
                    left = index + 1;
                }else{
                    left = index - stack.peek();
                }
                int right = i - index;
                sumMax += (long) nums[index] * left * right;
            }
            if(i < nums.length){
                stack.push(i);
            }
        }
        return sumMax;
    }
}