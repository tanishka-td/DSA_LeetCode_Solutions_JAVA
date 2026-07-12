# 2104. Sum of Subarray Ranges

## Intuition
The range of a subarray is:
    Maximum Element − Minimum Element

Instead of finding the maximum and minimum for every subarray (O(n²)), calculate the contribution of each element separately.

For every element:

- Count how many subarrays it is the maximum of.
- Count how many subarrays it is the minimum of.
- Its total contribution becomes:
    (element × number of times it is maximum) − (element × number of times it is minimum)

To count these subarrays efficiently, we use a Monotonic Stack to find the previous and next greater/smaller elements.

## Approach
- Create two helper functions:
    1. sumMaximums()
    2. sumMinimums()
- In each function:
    - Maintain a monotonic stack.
    - Traverse the array (including one extra iteration to empty the stack).
- When an element is popped:
    - The current index becomes its next greater/smaller element.
    - The new top of the stack becomes its previous greater/smaller element.
- Compute:
    - Number of valid starting positions.
    - Number of valid ending positions.
- Every combination of a valid start and end forms a subarray where the popped element is the maximum (or minimum).
- Its contribution is:
    element × leftChoices × rightChoices

- Compute:
    - Total contribution as maximum.
    - Total contribution as minimum.
- Return:
    Maximum Contribution − Minimum Contribution

## Algorithm
1. Initialize an empty monotonic stack.
2. Traverse the array while maintaining monotonic order.
3. Whenever the current element breaks the monotonic property:
    - Pop the stack.
    - Find:
        - Previous greater/smaller element.
        - Next greater/smaller element.
    - Compute:
        - left = index − previous
        - right = next − index
    - Add:
        element × left × right
    to the answer.
4. Repeat separately for:
    - Maximum contribution.
    - Minimum contribution.
5. Return:
    sumMaximums − sumMinimums

## Time Complexity
### O(n)
Each element is pushed and popped from the stack at most once

## Space Complexity
### O(n)
Used by the monotonic stack.

## Key Idea
Instead of iterating over every subarray, determine how many subarrays each element contributes to.

Using the Monotonic Stack:
- Previous and Next Smaller determine the subarrays where an element is the minimum.
- Previous and Next Greater determine the subarrays where an element is the maximum.

If an element has:
- left possible starts
- right possible ends

then it contributes to exactly
    left × right
subarrays.

Therefore,
    Contribution = element × left × right

The final answer is:
    Σ(Maximum Contributions) − Σ(Minimum Contributions)
