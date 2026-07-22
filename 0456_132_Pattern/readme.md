# 456. 132 Pattern

## Intuition
We need three values:
    nums[i] < nums[k] < nums[j]

in the order:
    i < j < k

Instead of trying to find all three, traverse right to left. Use a decreasing stack to keep possible 3s, while popped values become candidates for 2.

If we later find a value smaller than our stored 2, we have found the 1, completing the 132 pattern.

## Approach
- Traverse from right to left.
- Maintain a monotonically decreasing stack.
- Keep val2 as the best candidate for the 2 in the pattern.
- If curr > stack.peek(), pop smaller values. These popped values can act as 2, while curr acts as 3.
- Store the latest popped value in val2.
- If we later find:
    curr < val2
then:

    curr  = 1
    val2  = 2
    larger previous stack element = 3
so return true.

## Algorithm
1. Create a decreasing monotonic stack.
2. Set val2 = -∞.
3. Traverse nums from right to left.
4. If nums[i] < val2:
      return true.
5. While stack is not empty
   AND nums[i] > stack.peek():
      val2 = stack.pop().
6. Push nums[i] onto the stack.
7. If traversal finishes, return false.

## Time Complexity
### O(n) 

every element is pushed and popped at most once.

## Space Complexity
### O(n)

the stack may contain all elements.

## Key Idea

Traverse right-to-left and maintain possible 3s in a decreasing stack. Popped smaller values become candidates for 2. Once a value smaller than 2 appears, we have found 1 < 2 < 3 in the required 132 order.