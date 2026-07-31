# 3014. Minimum Number of Pushes to Type Word I

## Intuition
There are 8 keys (2–9), and each key has positions that require increasing pushes:

    1st position → 1 push
    2nd position → 2 pushes
    3rd position → 3 pushes
    ...

Since we are free to assign letters to any key, we should always place letters in the cheapest available positions.

There are:

8 positions costing 1 push
8 positions costing 2 pushes
8 positions costing 3 pushes
...

Because every character in the word is unique, all letters are equally important. So we simply fill the cheapest positions first.

## Approach
- Traverse the letters of the word.
- The first 8 letters are assigned to the first position of each key.
- The next 8 letters are assigned to the second position.
- Continue similarly for the remaining letters.
- The push count for the i-th letter is:
    i / 8 + 1
using integer division.

## Algorithm
1. Initialize pushes = 0.
2. Traverse every character in the word.
3. For the i-th character:
      pushes += i / 8 + 1
4. Return pushes.

## Time Complexity
### O(n)

We traverse the word only once.

## Space Complexity
### O(1)

Only the answer variable is used.

## Key Idea

There are only 8 cheapest positions (one on each key). Since every letter appears exactly once, assign the first 8 letters to these positions, the next 8 letters to the second positions, and so on.

In short:

    First 8 letters   → 1 push each
    Next 8 letters    → 2 pushes each
    Next 8 letters    → 3 pushes each
    ...

    Pushes for i-th letter = i / 8 + 1