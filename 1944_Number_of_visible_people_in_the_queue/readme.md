# 1944. Number of Visible People in a Queue

## Intuition
A person can see everyone to their right until their view is blocked by the first person who is taller than or equal to them.

- Every shorter person before the blocker is visible.
- The first taller (or equal) person is also visible because they are the one blocking the view.
- Any person standing behind that taller person can never be seen, regardless of their height.

This naturally suggests maintaining only the people who can still affect future visibility, which can be done using a monotonic decreasing stack.

## Approach
- Traverse the array from right to left while maintaining a monotonic decreasing stack of indices.
- For each person:
    - Pop every shorter person from the stack since they are directly visible.
    - Each popped person contributes 1 to the visible count.
    - If the stack is still not empty after popping, the first taller (or equal) person is also visible, so increment the count by 1.
    - Do not continue beyond this person because they block the view of everyone standing behind them.
    - Push the current person's index onto the stack.
- Store the visible count for each person in the answer array.

## Algorithm
1. Initialize an empty stack and an answer array.
2. Traverse the heights array from right to left.
3. While the stack is not empty and the current person is taller than the person on top of the stack:
    - Pop the stack.
    - Increment the visible count.
4. If the stack is still not empty:
    - Increment the visible count once, since the first taller (or equal) person is also visible.
5. Push the current index onto the stack.
6. Return the answer array.

## Time Complexity
### O(n)
Each person is pushed onto the stack exactly once and popped at most once.

## Space Complexity
### O(n)
The stack stores at most n indices in the worst case.

## Key Idea
Maintain a monotonic decreasing stack of people to the right.

For each person:

- Every shorter person popped from the stack is visible.
- The first taller (or equal) person remaining on the stack is also visible.
- That taller person blocks the view of every shorter person standing behind them, so no further people can be seen

Thus, each person's visible count equals:
***
(number of popped shorter people) + (1 if a taller/equal blocker exists)
***
This problem is not a Next Greater Element problem.

The goal is not to find the first greater person, but to count everyone visible before the view is blocked. The monotonic stack efficiently removes people who can never block future views while counting everyone the current person can actually see.