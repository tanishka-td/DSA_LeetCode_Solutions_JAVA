# 3518. Smallest Palindromic Rearrangement II

## Intuition
A palindrome is completely determined by its left half, optional middle character, and the reverse of the left half.

    LEFT + MIDDLE + reverse(LEFT)

Unlike 3517, we are not looking for the smallest palindrome—we need the k-th lexicographically smallest palindrome.

Instead of generating every possible palindrome, we build the left half one character at a time.

At each position:
- Try placing 'a', then 'b', then 'c', ...
- Count how many palindromes are possible with that choice.
- If the count is at least k, keep that character.
- Otherwise, skip all those palindromes by subtracting the count from k and try the next character.

## Approach
- Count the frequency of each character.
- Determine the middle character (if any).
- Divide every frequency by 2 to obtain the characters for the left half.
- Construct the left half one position at a time:
    - Try each available character in alphabetical order.
    - Temporarily use that character.
    - Count the number of distinct permutations of the remaining characters.
    - If k falls within those permutations, keep the character.
    - Otherwise, skip those permutations and restore the character.
- Reverse the completed left half to obtain the right half.
- Combine:
    left + middle + reverse(left)

## Algorithm
1. Count character frequencies.
2. Find the middle character (odd frequency).
3. Divide every frequency by 2.
4. For every position in the left half:
      Try characters from 'a' to 'z'.
      If character is unavailable:
            continue.
      Temporarily use it.
      Count remaining permutations.
      If k <= count:
            keep the character.
            move to next position.
      Otherwise:
            k -= count
            restore the character.
5. Reverse the left half.
6. Return:
      left + middle + right.

## Time Complexity
Let:
- n = length of the string
- m = n / 2 = length of the left half

For each position, we may try up to 26 characters, and each trial counts the remaining permutations.

Overall:
    O(26 × m × countCost)

Since the alphabet size (26) is constant, the practical complexity is dominated by the permutation-counting routine.

## Space Complexity
### O(26 + m)

- Frequency array
- Left-half builder
- Temporary variables

Overall:
    O(n)

## Key Idea
A palindrome is completely determined by its left half. Build the left half greedily in lexicographic order, using permutation counting to skip entire groups of candidates until the k-th palindrome is reached.

In short
    Count frequencies
            ↓
    Build LEFT one character at a time
            ↓
    Try smallest character
            ↓
    Count remaining permutations

    count >= k ?
         ↓
    YES → keep character

    NO  → k -= count
          try next character

Finally:
    LEFT + MIDDLE + reverse(LEFT)