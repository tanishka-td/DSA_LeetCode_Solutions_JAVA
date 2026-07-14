class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<num.length(); i++){
            char curr = num.charAt(i);
            while (!stack.isEmpty() && stack.peek()>curr && k > 0){
                stack.pop();
                k--;
            }
            stack.push(curr);
        }
        while (k>0 && !stack.isEmpty()){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (char digit : stack) {
            sb.append(digit); 
        }
        int index=0;
        while (index < sb.length() && sb.charAt(index) == '0') {
            index++;
        }
        if(index == sb.length()){
            return "0";
        }
        return sb.substring(index);
    }
}