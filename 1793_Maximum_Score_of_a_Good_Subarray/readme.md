# 1793. Maximum Score of a Good Subarray

## Intuition
The score of a subarray is:

    minimum value in subarray × length of subarray

This is almost the same idea as Largest Rectangle in Histogram (84):
    height × width

For every nums[i], consider it as the minimum value of a possible subarray.

We want to expand that subarray as far left and right as possible while all elements remain at least nums[i].

A monotonic increasing stack helps us find these boundaries.

However, unlike question 84, a subarray is valid only if it contains index k.

So after finding the maximum range for each minimum element, we calculate its score only if:
    left <= k <= right

## Approach
Use a monotonically increasing stack of indices.

While traversing the array:
- Keep indices whose corresponding values are in increasing order.
- When the current value becomes smaller than or equal to the value at the stack top, pop the top.
- The popped element becomes the minimum value of the subarray we're evaluating.
- The current index i gives its right boundary.
- The new stack top gives its left boundary.
- Calculate the width of this subarray.
- If this range contains k, calculate:
    score = minimum × width

and update the maximum score.

Use an extra iteration with a sentinel value 0 at the end so that all remaining elements in the stack are processed.

## Algorithm
1. Create an empty monotonic increasing stack storing indices.
2. Initialize maxScore = 0.
3. Traverse from i = 0 through i = nums.length.
4. For the extra iteration (i == nums.length), consider the current value as 0.
5. While the stack is not empty and:
    curr <= nums[stack.peek()]

    - Pop an index from the stack.
    - Let:
        minValue = nums[index]
    - Find the left boundary:
        - If the stack is empty, left = 0.
        - Otherwise, left = stack.peek() + 1.
    - The right boundary is:
        right = i - 1
    - Check whether the range contains k:
        left <= k && k <= right
    - If yes, calculate:
        score = minValue × (right - left + 1)
    - Update maxScore.
6. Push the current index onto the stack.
7. Return maxScore.

## Time Complexity
### O(n)

Although there is a while loop inside the for loop, every index is:
- pushed onto the stack once
- popped from the stack at most once

Therefore the total number of stack operations is linear.

## Space Complexity
### O(n)
In the worst case, all indices can remain in the monotonic stack.

## Key Idea

Treat every element as the minimum value of a subarray and use a monotonic increasing stack to find the largest range where it remains the minimum. Calculate its score only when that range contains k.