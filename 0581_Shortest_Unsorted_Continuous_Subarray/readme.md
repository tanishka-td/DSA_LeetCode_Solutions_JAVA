# 581. Shortest Unsorted Continuous Subarray

## Intuition
We need to find the smallest subarray which, if sorted, makes the entire array sorted.

The unsorted region begins where an element violates the increasing order from the left, and ends where an element violates the order from the right.

A monotonic stack helps find these two boundaries.

## Approach
- First traverse left → right using a monotonically increasing stack.
- Whenever nums[i] < nums[stack.peek()], pop indices because those elements are out of their correct order.
- The smallest popped index gives the left boundary.
- Clear the stack.
- Traverse right → left using a monotonically decreasing stack.
- Whenever nums[i] > nums[stack.peek()], pop indices.
- The largest popped index gives the right boundary.
- The required length is:
    right - left + 1

If no boundary was found, the array is already sorted, so return 0.

## Algorithm
1. Initialize:
      left = n
      right = 0
2. Traverse left → right:
      While stack is not empty
      AND nums[i] < nums[stack.peek()]:
          index = stack.pop()
          left = min(left, index)

      Push i.
3. Clear the stack.
4. Traverse right → left:
      While stack is not empty
      AND nums[i] > nums[stack.peek()]:
          index = stack.pop()
          right = max(right, index)

      Push i.
5. If left == n:
      return 0
6. Return:
      right - left + 1

## Time Complexity
### O(n)

There are two traversals, O(2n), which simplifies to O(n). Each index is pushed and popped at most once per traversal.

## Space Complexity
### O(n)

The monotonic stack can contain up to n indices.

## Key Idea
Use an increasing stack from the left to find how far the unsorted region extends left, and a decreasing stack from the right to find how far it extends right. The range between those boundaries is the shortest subarray that must be sorted.