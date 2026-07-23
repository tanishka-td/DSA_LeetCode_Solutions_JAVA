# 1776. Car Fleet II

## Intuition
Unlike 853, there is no fixed target. Each car may collide with another car ahead of it.

For a car i, we need to find the first car j ahead that it can actually collide with.

We traverse right → left so that when processing i, we already know when every car ahead will collide.

The stack stores indices of possible collision targets.

## Approach
- Traverse cars from right to left.
- Maintain a stack of car indices.
- For the current car i, let j = stack.peek().
- j is invalid in two cases:
    - speed[i] <= speed[j] → i can never catch j.
    - i would reach j only after j has already collided with another car.
- Pop invalid cars until a valid collision target is found.
- Store the collision time in ans[i].
- If no valid car remains, ans[i] stays -1.
- Push i for cars further behind to consider.

## Algorithm
1. Create ans[] and fill it with -1.
2. Create an empty stack of car indices.
3. Traverse i from n-1 → 0.
4. While stack is not empty:
      j = stack.peek()
      If speed[i] <= speed[j]:
          pop j
          continue
      Calculate:
          time =
          (position[j] - position[i])
          /
          (speed[i] - speed[j])
      If ans[j] > 0 AND time > ans[j]:
          pop j
          continue
      Otherwise:
          ans[i] = time
          break
5. Push i onto the stack.
6. Return ans.

## Time Complexity
### O(n)

Each car is pushed onto the stack once and popped at most once.

## Space Complexity
### O(n)

The stack and answer array can contain up to n elements.

## Key Idea
Traverse right to left and keep only cars that can still be valid collision targets. Pop a car if the current car cannot catch it, or if that car will collide with someone else before the current car reaches it.