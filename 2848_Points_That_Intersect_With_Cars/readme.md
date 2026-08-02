# 2848. Points That Intersect With Cars

## Intuition
Each car covers an interval of integer points:
    [start, end]

The same point may be covered by multiple cars, but it should be counted only once.

A HashSet is ideal because it automatically stores only unique points.

## Approach
- Create a HashSet to store all covered points.
- Traverse each car's interval.
- For every integer point from start to end, insert it into the set.
- Since duplicate points are ignored by the set, the final answer is simply the size of the set.

## Algorithm
1. Create an empty HashSet.
2. Traverse every car.
3. Extract:
      start = car.get(0)
      end = car.get(1)
4. For every point from start to end:
      add the point to the HashSet.
5. Return:
      HashSet.size()

## Time Complexity
Let:
n = number of cars
m = total number of integer points covered

Overall:
    O(m)

Since the constraints are small (points are at most 100), this is efficient.

## Space Complexity
O(m)

The HashSet stores all unique covered points.

## Key Idea
Insert every covered integer point into a HashSet. Since a set stores only unique values, overlapping intervals are automatically handled.

In short:
    Traverse each interval
            ↓
    Add every point to HashSet
            ↓
    Duplicates ignored
            ↓
    Return HashSet.size()