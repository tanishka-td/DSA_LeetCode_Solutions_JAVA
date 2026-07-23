class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : operations){
            if (op.equals("+")){
                int first = stack.pop();
                int second = stack.peek();
                stack.push(first);
                stack.push(first + second);
            } else if (op.equals("D")){
                int db = stack.peek() *2;
                stack.push(db);
            } else if (op.equals("C")){
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            int record = stack.pop();
            sum += record;
        }
        return sum;
    }
}