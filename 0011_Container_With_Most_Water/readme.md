# 11. Container With Most Water

## Intuition
The amount of water stored between two lines depends on:
- The shorter of the two heights.
- The distance between them.

So the area formed by two lines is:
    Area = min(leftHeight, rightHeight) × width

where:
    width = right - left

To maximize the area, use two pointers starting from both ends. After calculating the current area, move the pointer with the smaller height, since the shorter line limits the water that can be stored.

## Approach
- Place one pointer at the beginning and one at the end of the array.
- Calculate the area formed by the two lines.
- Update the maximum area.
- Move the pointer with the smaller height inward.
- Repeat until both pointers meet.

## Algorithm
1. Initialize:
      left = 0
      right = n - 1
      maxArea = 0
2. While left < right:
      height = min(height[left], height[right])
      width = right - left
      area = height × width
      Update maxArea.
3. If height[left] < height[right]:
      left++
   Else:
      right--
4. Return maxArea.

## Time Complexity
### O(n)

Each pointer moves at most n times.

## Space Complexity
### O(1)

Only a few variables are used.

## Key Idea
The shorter line always limits the water that can be stored. Keeping the shorter line while moving the taller one can only decrease the width without increasing the height, so always move the pointer at the shorter line.

In short:
    Calculate area
            ↓
    Save maximum
            ↓
    Move the shorter line
            ↓
    Repeat until pointers meet