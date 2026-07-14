# 739. Daily Temperatures

## Intuition
For each day's temperature, determine how many days must pass until a warmer temperature occurs.

A brute-force solution would compare each day with every future day, resulting in O(n²) time.

Instead, maintain a Monotonic Decreasing Stack of indices.

While traversing the array, whenever the current temperature is warmer than the temperature at the top of the stack, we've found the next warmer day for the top index.

## Approach

- Traverse the temperature array from left to right.
- Maintain a monotonic decreasing stack of indices.
- The temperatures corresponding to these indices remain in decreasing order.
- For each current temperature:
    While the stack is not empty and the current temperature is warmer than the temperature at the top index:
    - Pop the previous day's index.
    - The current day is its next warmer day.
    - Store the difference in indices as the answer.
- Push the current index onto the stack.
- Any indices remaining in the stack do not have a warmer day, so their answers remain 0..

## Algorithm

1. Initialize:
    - An empty stack.
    - An answer array initialized with 0s.
2. Traverse the array from left to right.
3. While:
    - The stack is not empty, and
    - temperatures[current] > temperatures[stack.peek()]
    - Pop the previous index.
    - Compute:
        answer[previous] = current - previous
4. Push the current index onto the stack.
5. Return the answer array.

## Time Complexity
### O(n)

Each index is pushed onto the stack exactly once and popped at most once.

## Space Complexity
### O(n)

The stack stores at most n indices.

## Key Idea

Maintain a Monotonic Decreasing Stack of temperatures.

Whenever a warmer temperature is encountered:
- It becomes the Next Greater Element for all colder temperatures popped from the stack.
- The number of waiting days is simply:
    Current Index − Previous Index

Instead of searching forward for every day, each day waits in the stack until its answer is found.

The stack doesn't store temperatures because we need the temperatures themselves—it stores indices because the final answer depends on the distance between two days.