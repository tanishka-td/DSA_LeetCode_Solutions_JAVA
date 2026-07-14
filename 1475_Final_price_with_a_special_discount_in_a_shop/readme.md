# 1475. Final Prices With a Special Discount in a Shop

## Intuition
For each item's price, find the first item to its right whose price is less than or equal to the current price.

That item's price becomes the discount.

A brute-force solution would search to the right for every item, resulting in O(n²) time.

Instead, maintain a Monotonic Increasing Stack of indices.

Whenever the current price is smaller than or equal to the price at the top of the stack, it becomes the discount for that previous item.

## Approach
- Initialize an empty Monotonic Increasing Stack storing indices.
- Traverse the prices array from left to right.
- For each current price, While the stack is not empty and the current price is less than or equal to the price at the top index:
    - Pop the previous index.
    - Apply the current price as the discount.
- Push the current index onto the stack.
- Any indices remaining in the stack do not have a valid discount, so their prices remain unchanged.

## Algorithm
1. Initialize an empty stack.
2. Traverse the array from left to right.
3. While:
    - Stack is not empty.
    - prices[current] <= prices[stack.peek()]
    - Pop the previous index.
    - Update:
        prices[index] = prices[index] - prices[current]
4. Push the current index.
5. Return the modified prices array.

## Time Complexity
### O(n)

Each index is pushed onto the stack exactly once and popped at most once.

## Space Complexity
### O(n)

The stack stores at most n indices.

## Key Idea
Maintain a Monotonic Increasing Stack.

Each item's index waits in the stack until a price that is smaller than or equal to it appears.

When such a price is found:
- It is the first valid discount.
- Apply the discount immediately.
- Remove that item from the stack since its answer is finalized.

Here:
- Every price waits for its first valid discount.
- The moment a smaller (or equal) price appears, that waiting item has found its answer.
- It is popped immediately because it will never need to be processed again.

The stack simply represents items waiting for their discount.