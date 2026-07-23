# 768. Max Chunks To Make Sorted II

## Intuition
Unlike 769, the array can contain arbitrary values and duplicates, so we cannot use:

max == i

Instead, use a monotonically increasing stack, where each value in the stack represents the maximum value of one possible chunk.

If the current value is smaller than the previous chunk's maximum, those chunks cannot remain separate and must be merged.

## Approach
- Maintain an increasing stack of chunk maximums.
- If curr >= stack.peek(), it can start a new chunk, so push it.
- If curr < stack.peek(), the current value conflicts with previous chunk(s).
- Save the top as max, because this remains the maximum of the merged chunk.
- Pop all previous chunk maximums that are greater than curr.
- Push max back to represent the newly merged chunk.
- At the end, each value remaining in the stack represents one valid chunk.

## Algorithm
1. Create an empty monotonic increasing stack.
2. Traverse every value curr in arr.
3. If stack is empty OR curr >= stack.peek():
      push curr.
4. Otherwise:
      max = stack.pop()
      while stack is not empty
      AND stack.peek() > curr:
          stack.pop()
      push max back.
5. Return stack.size().

## Time Complexity
### O(n)

Each element is pushed and popped at most once.

## Space Complexity
### O(n)

In the worst case, every element represents its own chunk and remains in the stack.

## Key Idea
The stack stores the maximum value of each potential chunk. If a smaller value appears that violates the increasing order of chunk maximums, the conflicting chunks must be merged while preserving the maximum value of the merged chunk.

In short:
    curr >= top
         ↓
    can stay separate
         ↓
    new chunk

    curr < top
         ↓
    order is violated
         ↓
    merge conflicting chunks
         ↓
    preserve their maximum