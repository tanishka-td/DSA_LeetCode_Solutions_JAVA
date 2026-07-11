# Approach
- Traverse the array from right to left while maintaining a monotonic decreasing stack of indices.
- For each person:
    - Pop every shorter person from the stack since they are directly visible.
    - Each popped person contributes 1 to the visible count.
    - If the stack is still not empty after popping, the first taller (or equal) person is also visible, so increment the count by 1.
    - Push the current index onto the stack.
- Store the visible count for each person in the answer array.

# Time Complexity
### O(n)
Each person is pushed onto the stack exactly once and popped at most once.

# Space Complexity
### O(n)
The stack stores at most n indices in the worst case.

# Key Idea
Maintain a monotonic decreasing stack of people to the right.

For each person:

- Every shorter person popped from the stack is visible.
- After removing all shorter people, if a taller (or equal) person remains, they are also visible and block everyone behind them.

Thus, each person's visible count equals:
***
(number of popped shorter people) + (1 if a taller/equal blocker exists)
***