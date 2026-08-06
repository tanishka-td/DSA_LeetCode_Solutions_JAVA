# 3345. Smallest Divisible Digit Product I

## Intuition
Starting from n, check each number one by one until you find the first number whose product of digits is divisible by t.

For every number:
- Compute the product of all its digits.
- If the product is divisible by t, return that number.
- Otherwise, check the next number.

Since we need the smallest valid number, a simple sequential search guarantees the correct answer.

## Approach
- Start from n.
- For each number:
    - Calculate the product of its digits.
    - Check whether the product is divisible by t.
- If it is divisible, return the current number.
- Otherwise, increment the number and repeat.

## Algorithm
1. Start with the given number n.
2. Repeat:
      Compute the product of all digits
      of the current number.
3. If:
      product % t == 0
      return the current number.
4. Otherwise:
      increment the number by 1.
5. Continue until a valid number is found.

## Time Complexity
Let k be the number of numbers checked before finding the answer, and d be the number of digits.

    O(k × d)

Since each number requires traversing all of its digits.

## Space Complexity
### O(1)

Only a few variables are used.

## Key Idea
Starting from n, repeatedly compute the product of the digits of each number. The first number whose digit product is divisible by t is the required answer.

In short
    Start from n
            ↓
    Find product of digits
            ↓
    Divisible by t?

    YES → Return number

    NO → Check next number
            ↓
    Repeat