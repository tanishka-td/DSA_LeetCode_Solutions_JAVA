# 486. Predict the Winner

## Intuition
Both players can pick only from the left or right end of the array, and both play optimally.

Instead of calculating each player's score separately, compute the maximum score difference the current player can achieve over the opponent.

If the current player picks the left number, the opponent will then play optimally on the remaining subarray. Therefore, the current player's final advantage is:
    nums[left] - opponent's advantage

The same idea applies if the current player picks the right number.

## Approach
- Use recursion with memoization.
- Define solve(left, right) as the maximum score difference (current player − opponent) for the subarray nums[left...right].
- At each state:
    - Pick the left number.
    - Pick the right number.
- Since the opponent also plays optimally, subtract the - - - opponent's best score difference.
- Choose the better option.
- If the final score difference is non-negative, Player 1 can win or tie.

## Algorithm
1. Create a DP table for memoization.
2. Define solve(left, right):
      Returns the maximum score difference
      the current player can obtain.
3. Base case:
      If left == right:
          return nums[left]
4. If already computed:
      return stored value.
5. Compute:
      takeLeft =
          nums[left]
          - solve(left + 1, right)
      takeRight =
          nums[right]
          - solve(left, right - 1)
6. Store:
      dp[left][right] =
          max(takeLeft, takeRight)
7. Return dp[left][right].
8. If solve(0, n-1) >= 0:
      return true
   else:
      return false

## Time Complexity
### O(n²)

There are n² possible (left, right) states, and each is computed only once.

## Space Complexity
### O(n²)

The memoization table stores one value for each subarray.

## Key Idea
Let the recursive function return the maximum score difference the current player can achieve. Every move gains the chosen number, but the opponent's optimal play reduces that advantage, so subtract the opponent's best result.

In short:
    Take LEFT
          ↓
    nums[left]
          -
    solve(left+1, right)

    Take RIGHT
          ↓
    nums[right]
          -
    solve(left, right-1)

    Choose the better option.