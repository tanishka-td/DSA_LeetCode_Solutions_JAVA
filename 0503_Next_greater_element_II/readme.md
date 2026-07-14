# 503. Next Greater Element II

## Intuition
For every element, find the first greater element to its right.

Unlike 496, the array is circular, meaning that after reaching the last element, the search continues from the beginning until it returns to the starting position.

A brute-force solution would check every element twice, resulting in O(n²) time.

Instead, simulate the circular traversal by iterating through the array twice while maintaining a Monotonic Decreasing Stack of indices.

## Approach
- Initialize an answer array filled with -1.
- Maintain a Monotonic Decreasing Stack storing indices whose - next greater element has not yet been found.
- Traverse the array from 0 to 2 × n - 1.
- Access the current element using:
    nums[i % n]

to simulate circular traversal.
- While the current element is greater than the element at the top index of the stack:
    - Pop the index.
    - Store the current element as its next greater element.
- Push indices onto the stack only during the first pass.
- During the second pass, only resolve remaining indices without pushing new ones.

## Algorithm
1. Initialize:
    - An empty stack.
    - An answer array filled with -1.
2. Traverse from 0 to 2 × n - 1.
3. Let:
    current = nums[i % n]
4. While:
    - Stack is not empty.
    - current > nums[stack.peek()]
    - Pop the index.
    - Store:
        answer[index] = current
5. If i < n, push the current index onto the stack.
6. Return the answer array.

## Time Complexity
### O(n)

Although the loop runs 2n times, each index is:
- Pushed once.
- Popped at most once.
Therefore, the overall complexity remains O(n).

## Space Complexity
### O(n)

Used by:
- Monotonic Stack
- Answer array

## Key Idea
Maintain a Monotonic Decreasing Stack of indices whose next greater element has not yet been found.

The circular nature of the array is simulated by traversing it twice using:

    current = nums[i % n]

The first pass adds all indices to the stack.

The second pass does not push new indices—it only gives the remaining elements another opportunity to find their next greater element