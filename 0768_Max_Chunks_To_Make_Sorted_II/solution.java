class Solution {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int curr : arr){
            if (stack.isEmpty() || curr >= stack.peek()){
                stack.push(curr);
            }else {
                int max = stack.pop();
                while (!stack.isEmpty() && stack.peek()> curr){
                    stack.pop();
                }
                stack.push(max);
            }
        }
        return stack.size();
    }
}