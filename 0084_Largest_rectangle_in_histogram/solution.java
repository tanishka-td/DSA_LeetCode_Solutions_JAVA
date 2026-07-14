class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack <Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0; i<=heights.length; i++){
            int curr;
            if (i == heights.length){
                curr = 0;
            }else{
                curr = heights[i];
            }
            while (!stack.isEmpty() && curr<=heights[stack.peek()]){
                int index = stack.pop();
                int height = heights[index];
                int width;
                if (stack.isEmpty()){
                    width =i;
                }else{
                    width =i -stack.peek()-1;
                }
                int area = height * width;
                maxArea = Math.max(maxArea,area);
            }
            stack.push(i);
        }
        return maxArea;
    }
}