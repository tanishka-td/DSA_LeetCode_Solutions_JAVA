# 735. Asteroid Collision

## Intuition
Asteroids collide only when they are moving toward each other:
    positive →   ← negative

So a collision happens only when:
    stack.peek() > 0 && curr < 0

The stack stores asteroids that have survived so far.

When a collision occurs, compare their absolute sizes. The smaller asteroid is destroyed, while the larger one may continue and collide again.

## Approach
- Traverse the asteroids from left to right.
- Maintain a stack of surviving asteroids.
- For every current asteroid, mark it as alive.
- While:
    - the stack is not empty,
    - the stack top is positive,
    - and the current asteroid is negative,
a collision occurs.

- Compare their sizes:
    - Stack top smaller → pop it; current asteroid continues.
    - Stack top larger → current asteroid is destroyed.
    - Equal → both are destroyed.
- If the current asteroid survives all collisions, push it.
- Finally, convert the stack into an array in the correct order.
,
## Algorithm
1. Create an empty stack.
2. For every asteroid curr:
      alive = true
3. While stack is not empty
   AND stack.peek() > 0
   AND curr < 0:
      If stack.peek() < |curr|:
          pop stack top
      Else if stack.peek() > |curr|:
          alive = false
          break
      Else:
          pop stack top
          alive = false
          break
4. If curr is still alive:
      push curr
5. Create answer array of stack.size().
6. Pop elements into the answer array
   from right → left to restore original order.
7. Return answer.

## Time Complexity
### O(n)

Each asteroid is pushed once and can be popped at most once.

Even though there is a while inside the loop, the total number of stack operations is linear.

## Space Complexity
### O(n)

In the worst case, no asteroids collide, so all remain in the stack.

## Key Idea
The stack contains asteroids that have survived so far. A collision is possible only when a positive asteroid is already on the stack and the current asteroid is negative. Keep destroying the smaller asteroid until the current asteroid dies or no collision is possible.