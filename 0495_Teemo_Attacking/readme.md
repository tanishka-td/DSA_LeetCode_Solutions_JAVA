# 495. Teemo Attacking

## Intuition
Each attack poisons the enemy for duration seconds. However, if another attack happens before the previous poison ends, the poison duration resets.

So we should only count the non-overlapping contribution of each attack.

For two consecutive attacks, the current attack contributes either: duration

or the time until the next attack:
    timeSeries[i + 1] - timeSeries[i]
whichever is smaller.

## Approach
- Traverse consecutive attacks.
- Calculate the gap between the current and next attack.
- Add:
    Math.min(duration, gap)
- This automatically handles both overlapping and non-overlapping poison intervals.
- After the loop, add the full duration for the last attack because no later attack interrupts it.

## Algorithm
1. Initialize total = 0.
2. Traverse from i = 0 to n - 2.
3. Calculate:
      gap = timeSeries[i + 1] - timeSeries[i]
4. Add:
      total += min(duration, gap)
5. After traversal:
      total += duration
6. Return total.

## Time Complexity
### O(n)

We traverse timeSeries once.

## Space Complexity
### O(1)

Only a few variables are required.

## Key Idea
For every attack except the last, add only the time until either the poison expires or the next attack occurs — whichever comes first.