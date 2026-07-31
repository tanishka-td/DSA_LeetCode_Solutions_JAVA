# 3016. Minimum Number of Pushes to Type Word II

## Intuition
Unlike 3014, characters can appear multiple times. Therefore, not all letters are equally important.

To minimize the total number of pushes, the letters that appear more frequently should be assigned to the cheapest positions (1 push), while less frequent letters should occupy positions requiring more pushes.

There are:
    8 positions → 1 push
    8 positions → 2 pushes
    8 positions → 3 pushes
    ...

So after sorting the character frequencies in decreasing order, assign them to these positions.

## Approach
- Count the frequency of each character.
- Sort the frequencies in decreasing order.
- Traverse the sorted frequencies.
- The first 8 frequencies are multiplied by 1, the next 8 by 2, and so on.
- Sum the total pushes.

## Algorithm
1. Count the frequency of each letter.
2. Sort the frequency array.
3. Initialize:
      pushes = 0
      cost = 1
4. Traverse the frequencies from largest to smallest.
5. For each non-zero frequency:
      pushes += frequency × cost
6. After every 8 frequencies:
      cost++
7. Return pushes.

## Time Complexity
### O(n + 26 log 26)

Counting frequencies: O(n)
Sorting 26 letters: O(26 log 26), which is a constant.

Overall:
    O(n)

## Space Complexity
### O(1)

The frequency array always has size 26.

## Key Idea
Assign the most frequent letters to the cheapest key positions. Since there are only 8 positions for each push count, after filling the first 8, move to the next push count.

In short:

Count frequencies
        ↓
Sort in decreasing order
        ↓
First 8 → ×1
Next 8  → ×2
Next 8  → ×3
...