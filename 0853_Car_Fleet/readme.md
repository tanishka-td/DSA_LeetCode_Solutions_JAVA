# 853. Car Fleet

## Intuition
Cars starting at different positions may meet before reaching the target and form a fleet.

For each car, calculate the time it would take to reach the target:
    time = (target - position) / speed

We process cars from closest to the target → farthest from the target.

If a car behind takes less than or equal time compared to the fleet ahead, it will catch that fleet. Otherwise, it forms a new fleet.

## Approach
- Sort the cars by position in descending order.
- Calculate the arrival time of each car.
- Maintain a stack containing the arrival times of existing fleets.
- If the current car's time is:
    - <= stack.peek() → it catches the fleet ahead, so don't push it.
    - (> stack.peek()) → it cannot catch the fleet ahead, so it forms a new fleet.
- The number of values in the stack is the number of fleets.

## Algorithm
1. Create an array of indices.
2. Sort the indices according to position
   from largest → smallest.
3. Create an empty stack of arrival times.
4. For each car in sorted order:
      time = (target - position[i]) / speed[i]
      If stack is empty OR time > stack.peek():
          push time
      Otherwise:
          current car joins the fleet ahead.
5. Return stack.size().

## Time Complexity
### O(n log n)

Sorting takes:
    O(n log n)

and traversing all cars takes:
    O(n)

Therefore:
    O(n log n)

## Space Complexity
### O(n)

We store the indices and, in the worst case, all fleet arrival times in the stack.

## Key Idea
Process cars from nearest to farthest from the target and compare their arrival times. A car with a smaller or equal arrival time catches the fleet ahead; a larger arrival time creates a new fleet.