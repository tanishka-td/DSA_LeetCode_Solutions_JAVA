class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (matrix[i][j] == '1'){
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
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