# 628. Maximum Product of Three Numbers
## Intuition
The maximum product of three numbers can be obtained in two possible ways:
- The three largest numbers, or
- The two smallest (most negative) numbers and the largest number.

This is because the product of two negative numbers is positive, which can produce a larger result than using the second and third largest positive numbers.

## Approach
- Sort the array in ascending order.
- Compute:
    - Product of the three largest elements.
    - Product of the two smallest elements and the largest element.
- Return the larger of the two products.

## Algorithm

1. Sort the array.
2. Let n be the array length.
3. Compute:
      product1 =
      nums[n-1] × nums[n-2] × nums[n-3]
      product2 =
      nums[0] × nums[1] × nums[n-1]
4. Return:
      max(product1, product2)

## Time Complexity
### O(n log n)

Sorting the array dominates the running time.

## Space Complexity
### O(1)

Ignoring the space used by the sorting algorithm.

## Key Idea
After sorting, only two combinations can produce the maximum product:
- the three largest numbers, or
- the two smallest (most negative) numbers with the largest positive number.

In short:
    Sort array
          ↓
    Three largest
          OR
    Two smallest + largest
          ↓
    Return the larger product