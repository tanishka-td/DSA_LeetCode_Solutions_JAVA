# 654. Maximum Binary Tree

## Intuition
The maximum value of the array becomes the root, and smaller values around it become its descendants.

Instead of repeatedly searching for the maximum, we can use a monotonically decreasing stack of TreeNodes.

When a larger value appears, all smaller nodes on top of the stack must come under this new node.

## Approach
- Traverse the array from left to right.
- Create a TreeNode for every value.
- Maintain a decreasing stack of nodes.
- While the current node is greater than the stack top:
    - Pop the smaller node.
    - Make it the left child of the current node.
- If the stack is still not empty:
    - The stack top is greater than the current node.
    - Make the current node its right child.
- Push the current node.
- At the end, the node at the bottom of the stack is the root.

## Algorithm
1. Create an empty Deque<TreeNode>.
2. For every value in nums:
      Create curr = new TreeNode(value).
3. While stack is not empty
   AND stack.peek().val < curr.val:
      curr.left = stack.pop().
4. If stack is not empty:
      stack.peek().right = curr.
5. Push curr onto the stack.
6. After processing all values:
      return stack.peekLast().

## Time Complexity
### O(n)

Every node is pushed once and popped at most once.

## Space Complexity
### O(n)

In the worst case, all nodes can remain in the stack.

## Key Idea
Maintain a decreasing stack of tree nodes. When a larger node appears, smaller nodes are popped and become part of its left subtree; if a larger node remains on the stack, the current node becomes its right child.

In short:
    smaller nodes popped → curr.left
    larger node remaining → larger.right = curr
    bottom of stack       → root