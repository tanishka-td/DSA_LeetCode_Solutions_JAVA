# 42. Trapping Rain Water

## Intuition
Rainwater can only be trapped if there is a left boundary and a right boundary that are both taller than the ground between them.

Instead of checking every position separately (O(n²)), process the histogram while maintaining a Monotonic Decreasing Stack.

When a bar is popped from the stack, it becomes the bottom of a water container. At that moment:

The current bar is the right boundary.
The new top of the stack is the left boundary.

Since both boundaries are now known, the amount of water trapped above the popped bar can be calculated immediately.

## Approach

- Traverse the height array from left to right.
- Maintain a monotonic decreasing stack of indices.
- Whenever the current bar is taller than the bar at the top of the stack:
    - Pop the top index (the bottom of the container).
    - If the stack becomes empty, no left boundary exists, so stop processing this container.
    - Otherwise:
        - The new stack top is the left boundary.
        - The current index is the right boundary.
- Calculate:
    - Width of the container.
    - Water height using the shorter boundary.
    - Water trapped above the bottom.
- Add the trapped water to the answer.
- Push the current index onto the stack.

## Algorithm
1. Initialize an empty stack and water = 0.
2. Traverse the array from left to right.
3. While the stack is not empty and the current bar is taller than the top bar:
    - Pop the bottom index.
    - If the stack is empty, break.
    - Let:
        - left = stack.peek()
        - right = current index
    - Compute:
        width = right − left − 1
    - Compute:
        waterHeight = min(height[left], height[right]) − height[bottom]
    - Add:
        water += width × waterHeight
4. Push the current index.
5. Return the total trapped water.

## Time Complexity
### O(n)

Each index is pushed onto the stack exactly once and popped at most once.

## Space Complexity
### O(n)

The stack stores at most n indices.

## Key Idea

Maintain a Monotonic Decreasing Stack.

When a bar is popped:
- It represents the bottom of a pit.
- The new stack top becomes the left wall.
- The current bar becomes the right wall.

The trapped water above the popped bar is determined by:

    Water Height = min(Left Wall, Right Wall) − Bottom Height

and

    Water = Water Height × Width

where

    Width = Right Boundary − Left Boundary − 1