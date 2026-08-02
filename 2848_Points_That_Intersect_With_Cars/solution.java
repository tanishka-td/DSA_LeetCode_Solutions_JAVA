class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> points = new HashSet<>();
        for (List<Integer> car : nums) {
            int start = car.get(0);
            int end = car.get(1);
            for (int i = start; i <= end; i++) {
                points.add(i);
            }
        }
        return points.size();
    }
}