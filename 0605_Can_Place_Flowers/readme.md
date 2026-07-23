# 605. Can Place Flowers

## Intuition
A flower can be planted at index i only when:
    flowerbed[i] == 0

and both its neighboring positions are also empty.

For the first and last positions, the missing neighbor can simply be considered empty.

Whenever we find a valid position, we can greedily plant the flower immediately, because planting at the earliest possible position leaves maximum space for future flowers.

## Approach
- Traverse the flowerbed from left to right.
- For every empty position, check whether:
    - the left neighbor is empty or doesn't exist.
    - the right neighbor is empty or doesn't exist.
- If both are empty, plant a flower by changing the current position to 1.
- Increase the count of planted flowers.
- If the count reaches n, return true.
- Otherwise, return false after traversal.

## Algorithm
1. Initialize count = 0.
2. Traverse every index i.
3. Check:
      flowerbed[i] == 0
      leftEmpty =
          i == 0 OR flowerbed[i-1] == 0
      rightEmpty =
          i == length-1 OR flowerbed[i+1] == 0
4. If current, left, and right are empty:
      flowerbed[i] = 1
      count++
5. If count >= n:
      return true
6. After traversal:
      return false

## Time Complexity
### O(n)

We traverse the flowerbed once.

## Space Complexity
### O(1)

No additional data structure is required; we modify the given array directly.

## Key Idea
Greedily plant a flower at the earliest available position whose left and right neighbors are empty. Planting as early as possible does not reduce the number of flowers that can be placed later.