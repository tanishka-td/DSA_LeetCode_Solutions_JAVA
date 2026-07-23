# 682. Baseball Game

## Intuition
Each operation depends on the previous valid scores, so a stack is useful for storing the score history.

Number → add a new score.
"C" → remove the previous score.
"D" → double the previous score.
"+" → add the previous two scores.

At the end, the sum of all scores remaining in the stack is the answer.

## Approach
- Maintain a stack of valid scores.
- Traverse through each operation.
- If it is a number, convert it to an integer and push it.
- For "C", pop the previous score.
- For "D", double the top score and push it.
- For "+", temporarily pop the latest score to access the second latest score, then restore it and push their sum.
- Finally, pop and sum all remaining scores.

## Algorithm
1. Create an empty stack.
2. For every operation:
   If "+":
       first = pop()
       second = peek()
       push first back
       push first + second
   Else if "D":
       push peek() * 2
   Else if "C":
       pop()
   Else:
       convert operation to integer
       push it
3. Initialize sum = 0.
4. While stack is not empty:
       sum += stack.pop()
5. Return sum.

## Time Complexity
### O(n)

Each operation takes constant time, and the final summation takes another O(n).

So:
    O(n + n) = O(n)

## Space Complexity
### O(n)

In the worst case, all operations add scores to the stack.

## Key Idea
Use the stack as the history of all currently valid scores, allowing each new operation to access or modify the most recent records easily.