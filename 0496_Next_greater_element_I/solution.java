class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums2.length; i++){
            while (!stack.isEmpty() && nums2[i]>stack.peek()){
                int val = stack.pop();
                map.put(val, nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()){
            int val = stack.pop();
            map.put(val, -1);
        }
        int[] ans = new int[nums1.length];
        for (int i=0; i<nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}