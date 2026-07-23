# 769. Max Chunks To Make Sorted

## Intuition
The array is a permutation of:
    [0, 1, 2, ..., n-1]

So in the final sorted array, each value is equal to its index.

While traversing, keep track of the maximum value seen so far.

Whenever:
    max == i

everything we've seen so far belongs within indices 0...i. Therefore, we can safely end a chunk there.

## Approach
- Traverse the array from left to right.
- Maintain max, the largest value encountered so far.
- At every index, update:
    ax = Math.max(max, arr[i]);
- If:
    max == i
then all values needed for positions 0...i are already inside this prefix.

- Therefore, this is a valid place to end a chunk.
- Increment the number of chunks.

## Algorithm
1. Initialize:
      max = 0
      chunks = 0
2. Traverse arr from left to right.
3. For every index i:
      max = max(max, arr[i])
4. If max == i:
      chunks++
5. Return chunks.

## Time Complexity
### O(n)

We traverse the array only once.

## Space Complexity
### O(1)

Only max and chunks are stored.

## Key Idea
Because the array contains exactly 0 to n-1, when the maximum value seen so far equals the current index, the entire prefix contains exactly the values that belong there and can form an independent chunk.

In short:
    max == i
       ↓
    everything needed for [0...i] has appeared
       ↓
    valid chunk boundary