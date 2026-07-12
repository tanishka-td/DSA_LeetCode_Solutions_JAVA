# 84. Largest Rectangle in Histogram

## Intuition
For every bar we need to find:
- The first smaller bar on the left.
- The first smaller bar on the right.

The distance between these two smaller bars gives the maximum width for which the current bar remains the shortest.

Instead of checking left and right for every bar (O(n²)), we use a Monotonic Increasing Stack to find these boundaries in O(n).

## Approach
- Traverse the histogram while maintaining a monotonic increasing stack of indices.
- Whenever the current bar is shorter than the bar at the top of the stack:
    - Pop the taller bar.
    - The current index becomes its next smaller element.
    - The new top of the stack becomes its previous smaller element.
- Using these boundaries:
    - Compute the width where the popped bar remains the shortest.
    - Calculate the rectangle area.
- Update the maximum area.
- Continue until all bars are processed.
- Perform one extra iteration using a sentinel height (0) to pop any remaining bars.

## Algorithm
1. Initialize an empty stack and maxArea = 0.
2. Traverse the array from left to right (including one extra iteration).
3. Let the current height be:
    - heights[i] if i < n
    - 0 otherwise (sentinel)
4. While the stack is not empty and the current height is smaller than the height at the top index:
    - Pop the top index.
    - Let:
        - height = heights[poppedIndex]
        - right = i
        - left = stack.peek() (or -1 if empty)
    - Compute:
     width = right - left - 1 
    - Compute:
     area = height × width 
    - Update maxArea.
5. Push the current index.
6. Return maxArea.

## Time Complexity
### O(n)

Each index is pushed onto the stack exactly once and popped at most once.

## Space Complexity
### O(n)

The stack stores at most n indices.

## Key Idea

Maintain a Monotonic Increasing Stack.

When a bar is popped:
- The current index is its Next Smaller Element.
- The new stack top is its Previous Smaller Element.

Therefore, the popped bar is the shortest bar throughout the interval:

(previousSmaller, nextSmaller)

Its maximum rectangle is:
    Area = Height × Width

where
    Width = NextSmaller − PreviousSmaller − 1

Instead of asking:
    "What is the largest rectangle?"
think:
    "If this bar is the shortest, how far can it extend?"

## Personal Note
The biggest realization is that the stack does not directly find the largest rectangle.

Instead, every time a bar is popped, we have just discovered both boundaries where that bar can no longer be the minimum height.

Once both boundaries are known, the largest rectangle using that bar as the limiting height can be calculated immediately.