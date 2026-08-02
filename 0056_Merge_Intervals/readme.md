# 56. Merge Intervals

## Intuition
Two intervals overlap if the start of the next interval is less than or equal to the end of the current interval.

To efficiently merge intervals, first sort them by their starting point. Then traverse the sorted intervals, continuously merging overlapping intervals into a single interval.

## Approach
- Sort the intervals in ascending order of their start value.
- Initialize the first interval as the current interval.
- Traverse the remaining intervals:
    - If the next interval overlaps with the current one, extend the current interval by updating its ending point.
    - Otherwise, add the current interval to the result and make the next interval the new current interval.
- After traversal, add the last current interval to the result.

## Algorithm
1. Sort the intervals by their starting value.
2. Initialize:
      current = first interval
3. Traverse the remaining intervals.
4. If:
      next.start <= current.end
      Merge:
      current.end =
      max(current.end, next.end)
5. Otherwise:
      Add current to the result.
      current = next.
6. After the loop,
      add the final current interval.
7. Convert the result list to an array and return it.

## Time Complexity
### O(n log n)

Sorting: O(n log n)
Traversing the intervals: O(n)

Overall:
    O(n log n)

## Space Complexity
### O(n)

The result list may store all intervals if no intervals overlap.

## Key Idea
After sorting, overlapping intervals always appear next to each other. Maintain one current interval, merge whenever possible, and store it only when no further overlap exists.

In short:
    Sort intervals
            ↓
    Compare current and next
    
    Overlap?
          ↓
    YES → Extend current

    NO  → Save current
          Current = next

    After loop
          ↓
    Save final current