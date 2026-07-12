# 2281. Sum of Total Strength of Wizards

## Intuition
For every subarray, the total strength is calculated as:
    minimum element × sum of all elements in that subarray

Instead of iterating through every possible subarray (O(n²)), consider the contribution of each element individually.

For every element:

- Find all subarrays where it is the minimum.
- Compute the sum of all those subarray sums.
- Multiply that total by the element's value.
- Add the contribution to the final answer.

The problem is therefore divided into three parts:

1. Find the range where an element remains the minimum (Monotonic Stack).
2. Compute the sum of any subarray quickly (Prefix Sum).
3. Compute the sum of many subarray sums efficiently (Prefix of Prefix Sum).

## Approach
- Build a Prefix Sum array to compute any subarray sum in O(1).
- Build a Prefix of Prefix Sum array to compute the sum of multiple prefix sums in O(1).
- Traverse the array using a monotonic increasing stack.
- When an element is popped:
    - The current index becomes its next smaller element.
    - The new top of the stack becomes its previous smaller element.
- These boundaries determine every subarray in which the popped element is the minimum.
- Count:
    - Number of possible starting positions.
    - Number of possible ending positions.
- Using the Prefix of Prefix array:
    - Compute the total contribution of all ending prefixes.
    - Compute the total contribution of all starting prefixes.
- The total sum of all valid subarrays is:
    (rightPrefixSum × leftCount) − (leftPrefixSum × rightCount)

- Multiply this value by the current minimum and add it to the answer.

## Algorithm
1. Compute the Prefix Sum array.
2. Compute the Prefix of Prefix Sum array.
3. Initialize an empty monotonic increasing stack.
4. Traverse the array (including one extra iteration to empty the stack).
5. While the stack is not empty and the current element is smaller than the top of the stack:
    - Pop the stack.
    - Determine:
        - Previous smaller index.
        - Next smaller index.
    - Compute:
        - Left choices.
        - Right choices.
    - Use Prefix of Prefix sums to calculate the sum of all valid subarray sums.
    - Multiply by the current element.
    - Add the contribution to the answer.
6. Push the current index onto the stack.
7. Return the answer modulo 10⁹ + 7.

## Time Complexity
### O(n)
- Prefix Sum construction → O(n)
- Prefix of Prefix construction → O(n)
- Each element is pushed and popped at most once → O(n)

## Space Complexity
### O(n)
Used for:
- Prefix Sum array
- Prefix of Prefix Sum array
- Monotonic Stack

## Key Idea
Instead of calculating every subarray independently:

Count each element's contribution as the minimum.
Use a Monotonic Stack to determine exactly which subarrays it is the minimum of.
Use Prefix Sums to compute one subarray sum in O(1).
Use Prefix of Prefix Sums to compute the sum of many subarray sums in O(1).

The contribution of every minimum becomes:
    minimum × ((rightPrefixSum × leftCount) − (leftPrefixSum × rightCount))
