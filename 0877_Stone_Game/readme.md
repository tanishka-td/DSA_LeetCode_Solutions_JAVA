# 877. Stone Game

## Intuition
Alice and Bob can only pick stones from either end of the array. Since both play optimally, every choice affects the opponent's future choices.

Instead of tracking each player's score separately, let the recursive function return the maximum score difference the current player can achieve over the opponent.

## Approach
- Use recursion with memoization.
- Let solve(left, right) return the maximum score difference (current player − opponent) for the subarray piles[left...right].
- At each step:
    - Take the left pile.
    - Take the right pile.
- Since the opponent also plays optimally, subtract their best possible score difference.
- Choose the better option.

## Algorithm
1. Create a DP table.
2. Define solve(left, right):
      Returns the maximum score difference
      the current player can obtain.
3. Base case:
      If left == right:
          return piles[left]
4. If already computed:
      return stored value.
5. Compute:
      takeLeft =
          piles[left]
          - solve(left + 1, right)
      takeRight =
          piles[right]
          - solve(left, right - 1)
6. Store:
      dp[left][right] =
          max(takeLeft, takeRight)
7. Return dp[left][right].
8. If solve(0, n-1) > 0:
      Alice wins.

## Time Complexity
### O(n²)

There are n² possible (left, right) states, each solved once.

## Space Complexity
### O(n²)

For the memoization table.

## Key Idea
At every turn, choose the left or right pile to maximize your score difference over the opponent. Since the opponent also plays optimally, subtract their best possible advantage from your current choice.


But here's the twist:
- Number of piles is even.
- Total number of stones is odd.
- So a tie is impossible.
In fact, there's a famous mathematical proof that Alice always wins under these constraints.

So the official LeetCode solution is literally:
    class Solution {
        public boolean stoneGame(int[] piles) {
            return true;
        }
    }