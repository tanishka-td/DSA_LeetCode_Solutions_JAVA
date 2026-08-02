# 1464. Maximum Product of Two Elements in an Array

## Intuition
To maximize the expression:
    (nums[i] - 1) × (nums[j] - 1)

we need the two largest elements in the array.

Subtracting 1 from every number does not change their relative order, so the maximum product will always be obtained from the largest and second largest numbers.

## Approach
- Traverse the array once.
- Keep track of:
    - the largest element (max1)
    - the second largest element (max2)
- Whenever a larger number is found:
    - Update max2 to the previous max1.
    - Update max1 to the current number.
- Otherwise, if the current number is larger than max2, update max2.
- Return:
    (max1 - 1) × (max2 - 1)

## Algorithm
1. Initialize:
      max1 = 0
      max2 = 0
2. Traverse the array.
3. If current > max1:
      max2 = max1
      max1 = current
4. Else if current > max2:
      max2 = current
5. Return:
      (max1 - 1) × (max2 - 1)

## Time Complexity
### O(n)

The array is traversed only once.

## Space Complexity
### O(1)

Only two variables are used to store the largest elements.

## Key Idea
The maximum product is always formed by the largest and second largest elements. Track these two values in a single traversal and compute the required expression.

In short:
    Find largest element
            ↓
    Find second largest element
            ↓
    (max1 - 1) × (max2 - 1)