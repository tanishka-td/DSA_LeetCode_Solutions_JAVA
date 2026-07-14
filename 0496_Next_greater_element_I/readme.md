# 496. Next Greater Element I

## Intuition
For each element in nums1, find the first greater element to its right in nums2.

A brute-force approach would search to the right for every element, resulting in O(n²) time.

Instead, traverse nums2 while maintaining a Monotonic Decreasing Stack.

Whenever the current element is greater than the element at the top of the stack, it becomes the Next Greater Element for that stack element. Record this relationship in a HashMap for quick lookup later.

## Approach
- Initialize an empty Monotonic Decreasing Stack and a HashMap.
- Traverse nums2 from left to right.
- For each current element, While the stack is not empty and the current element is greater than the top element:
    - Pop the stack.
    - Store in the HashMap that the popped element's next greater element is the current element.
- Push the current element onto the stack.
- After traversal, all remaining elements in the stack have no greater element, so map them to -1.
- Traverse nums1 and use the HashMap to build the answer array.

## Algorithm
- Initialize:
    - An empty stack.
    - A HashMap.
- Traverse nums2.
- While, Stack is not empty and current > stack.peek()
    - Pop the top element.
    - Store:
        map[popped] = current
- Push the current element onto the stack.
- After traversal, assign:
    map[remainingElement] = -1

for all elements left in the stack.
- Traverse nums1:
    - Answer for each element is simply:
        answer[i] = map.get(nums1[i])
- Return the answer array.

## Time Complexity
### O(n + m)
- Traverse nums2 once → O(n)
- Traverse nums1 once → O(m)
Each element is pushed and popped from the stack at most once.

## Space Complexity
### O(n)

Used by:
- Monotonic Stack
- HashMap

## Key Idea
Maintain a Monotonic Decreasing Stack.

Each element remains in the stack until a greater element appears.

When a greater element is found:
- The current element is the Next Greater Element.
- Record this mapping immediately.

The HashMap stores:

    Element → Next Greater Element

allowing every query from nums1 to be answered in O(1) time.