# 3731. Find Missing Elements

## Intuition
The missing elements are the integers that lie between the minimum and maximum values of the array but are not present in the array.

To efficiently check whether an integer exists, store all elements in a HashSet, which provides O(1) average lookup time.

## Approach
- Traverse the array once to:
    - Find the minimum element.
    - Find the maximum element.
    - Store every element in a HashSet.
- Traverse all integers from min + 1 to max - 1.
- If an integer is not present in the HashSet, add it to the answer list.
- Return the list of missing integers.

## Algorithm
1. Initialize:
      min = nums[0]
      max = nums[0]
      HashSet
2. Traverse the array:
      Add every element to the HashSet.
      Update min and max.
3. Create an empty answer list.
4. Traverse every integer from:
      min + 1
      to
      max - 1
5. If the current integer is not present
   in the HashSet:
      Add it to the answer list.
6. Return the answer list.

## Time Complexity
### O(n + (max − min))

Finding the minimum, maximum, and building the HashSet: O(n)
Checking every integer between min and max: O(max − min)
Space Complexity

## O(n)
The HashSet stores all the elements of the array.

## Key Idea
Store every array element in a HashSet for constant-time lookup, then iterate through every integer between the minimum and maximum values. Any integer not found in the set is a missing element.

In short
    Find min & max
            ↓
    Store all elements in HashSet
            ↓
    Traverse from min+1 to max−1
            ↓
    If not in HashSet → add to answer
            ↓
    Return answer