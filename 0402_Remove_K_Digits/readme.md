# 402. Remove K Digits

## Intuition
To obtain the smallest possible number, the most significant digits should be as small as possible.

Whenever a smaller digit appears after a larger digit, removing the larger digit produces a smaller overall number.

Instead of deciding all removals at once, process the number from left to right while maintaining a Monotonic Increasing Stack of digits.

Whenever the current digit is smaller than the digit at the top of the stack, remove the larger digit (if removals remain). This greedily produces the smallest possible prefix of the final number.

## Approach
- Initialize an empty Monotonic Increasing Stack of digits.
- Traverse the number digit by digit.
- For each current digit:
    - While: The stack is not empty. The top digit is larger than the current digit. k > 0.
    - Pop the larger digit and decrement k.
- Push the current digit.
- If removals remain after traversal, remove digits from the end of the stack.
- Build the final number using a StringBuilder.
- Remove leading zeros.
- If the resulting string is empty, return "0".

## Algorithm
1. Initialize an empty stack.
2. Traverse every digit in the string.
3. While:

    stack not empty
    AND
    stack.peek() > currentDigit
    AND
    k > 0

    - Pop the stack.
    - Decrement k.
4. Push the current digit.
5. After traversal, while k > 0:
    - Pop from the stack.
    - Decrement k.
6. Build the number from the stack.
7. Remove leading zeros.
8. Return "0" if nothing remains; otherwise return the resulting string.

## Time Complexity
### O(n)

Each digit is pushed onto the stack once and popped at most once.

## Space Complexity
### O(n)

The stack stores at most n digits.

## Key Idea

Maintain a Monotonic Increasing Stack of digits.

Whenever a smaller digit appears:
- Any larger digit before it should be removed (if possible).
- This minimizes the most significant part of the number, which has the greatest effect on its overall value.

If removals are still available after processing all digits, remove them from the end since those digits contribute the least to reducing the number.