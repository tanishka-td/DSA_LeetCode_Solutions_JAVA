# 1406. Stone Game III

## Intuition
Both players can take 1, 2, or 3 stones from the beginning of the array. Since both play optimally, every choice affects the opponent's future moves.

Instead of calculating each player's score separately, let the recursive function return the maximum score difference (current player − opponent) starting from a given index.

For each move:
- Take 1 stone.
- Take 2 stones.
- Take 3 stones.

After taking stones, the opponent plays optimally, so subtract the opponent's best score difference from the current sum.

## Approach

- Use recursion with memoization.
- Define solve(i) as the maximum score difference the current player can obtain starting from index i.
- At every index:
    - Try taking 1, 2, and 3 stones.
    - Maintain a running sum of the stones taken.
    - Compute:
        currentSum - solve(nextIndex)
- Choose the maximum score difference among all valid choices.
- If the final difference is:
    - positive → Alice wins
    - negative → Bob wins
    - zero → Tie

## Algorithm
1. Create a DP array for memoization.
2. Define solve(i):
      Returns the maximum score difference
      the current player can obtain
      starting from index i.
3. Base case:
      If i >= n:
          return 0
4. If already computed:
      return stored value.
5. Initialize:
      sum = 0
      best = -∞
6. Try taking 1, 2 and 3 stones:
      sum += stoneValue[i + k]
      best = max(best, sum - solve(i + k + 1))
7. Store:
      dp[i] = best
8. Return dp[i].
9. Compute:
      diff = solve(0)
10. If:
      diff > 0
          return "Alice"
      diff < 0
          return "Bob"
      otherwise
          return "Tie"

## Time Complexity
### O(n)

Each index is solved only once, and each state considers at most **3 moves**.

## Space Complexity
### O(n)

For the memoization array and recursion stack.

## Key Idea

At each position, the current player can take 1, 2, or 3 stones. Compute the score gained from the chosen stones, subtract the opponent's best possible score difference, and choose the move that gives the maximum advantage.

In short:

```text
Take 1 stone
        ↓
sum - solve(next)

Take 2 stones
        ↓
sum - solve(next)

Take 3 stones
        ↓
sum - solve(next)

Choose the maximum.
```

### Connection to 486

```text
486:
Choose LEFT or RIGHT.

1406:
Choose 1, 2 or 3 stones.

Both:
Current Gain
      -
Opponent's Best Result
      ↓
Choose the maximum score difference.
```
