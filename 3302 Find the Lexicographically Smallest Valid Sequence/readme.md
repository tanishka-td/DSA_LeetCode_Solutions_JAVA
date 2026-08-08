# 3302. Find the Lexicographically Smallest Valid Sequence

## Intuition
We need to choose indices from word1 to form a sequence of length word2.length.

The selected characters must match word2 with at most one mismatch.

The important part is that we want the lexicographically smallest sequence of indices, so while traversing word1 from left to right, we should always choose the earliest possible index.

The difficulty is deciding whether choosing a particular index now will still allow us to finish matching the rest of word2.

To solve this, we use a right-to-left suffix scan to determine whether the remaining part of word2 can still be matched.

## Approach
- Build suffix information
- Traverse word1 and word2 from right to left.
- Keep track of the earliest position in word1 that can match each remaining part of word2.
- Traverse word1 from left to right
- Maintain:
    - j = current position in word2
    - canSkip = whether the one mismatch is still available
- For every character word1[i]:
    - Characters match, word1[i] == word2[j]
    - answer[size++] = i
    - j++
- if Characters don't match, I can use the mismatch only if:
    - I have not used the mismatch yet.
    - Either this is the last character of word2, or i < last[j + 1].

## Algorithm
1. Let:
    n = word1.length
    m = word2.length
2. Build suffix information by traversing
   word1 and word2 from right to left.
3. Initialize:
      answer = empty array
      j = 0
      canSkip = true
4. Traverse word1 from left to right.
5. If word1[i] == word2[j]:
    - take i
    - move j forward
6. Otherwise, if the mismatch is still available:
    - check whether word2[j+1...] can be matched using word1[i+1...], If yes:
        - take i
        - use the mismatch
        - move j forward
7. Continue until:
      - all of word2 is matched, or
      - word1 is exhausted.
8. If all m characters were matched:
      return answer
   Otherwise:
      return empty array.

## Time Complexity
### O(n + m)

- Right-to-left suffix traversal: `O(n)`
- Left-to-right greedy traversal: `O(n)`

## Space Complexity
### O(m)

For the suffix array and answer array.

## Key Idea
Look from the right to determine whether the remaining characters can be completed, then greedily scan from the left and take the earliest index that still allows a valid sequence.

The duplicate-character situation is handled naturally:

    candidate 1
        ↓
    Can the suffix still work?
        ↓
    YES → take it
    NO  → try candidate 2

So for duplicates, we do check which occurrence works, but we always prefer the earlier index if it is valid.