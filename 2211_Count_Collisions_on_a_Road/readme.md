# 2211. Count Collisions on a Road

## Intuition
Only two groups of cars can completely escape without colliding:
- L cars at the beginning keep moving left.
- R cars at the end keep moving right.

After removing these cars, every moving car (L or R) remaining in the middle will eventually collide.

Stationary cars S are not counted because they don't themselves move into a collision.

## Approach
- Use a left pointer to skip all leading Ls.
- Use a right pointer to skip all trailing Rs.
- Traverse the remaining section.
- Count every character that is not S.
- This count is the total number of collisions.

## Algorithm
1. Set:
      left = 0
      right = n - 1
2. While directions[left] == 'L':
      left++
3. While directions[right] == 'R':
      right--
4. Initialize collisions = 0.
5. Traverse from left to right:
      If directions[i] != 'S':
          collisions++
6. Return collisions.

## Time Complexity
### O(n)

The string is traversed at most a constant number of times.

## Space Complexity
### O(1)

Only pointers and the collision counter are stored.

## Key Idea
Ignore the cars that can escape: leading Ls and trailing Rs. Every remaining moving car must eventually collide, so simply count the remaining Ls and Rs.