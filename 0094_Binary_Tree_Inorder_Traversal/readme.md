# 94. Binary Tree Inorder Traversal

## Intuition
Inorder traversal follows:
    LEFT → ROOT → RIGHT

We first keep moving left, but we need to remember the nodes we passed so we can return to them later.

The stack stores these nodes.

Once there is no more left child, pop the latest node, visit it, and then move to its right child.

## Approach
- Start curr at the root.
- Keep pushing nodes while moving left.
- When curr becomes null, we have reached the end of the left side.
- Pop a node from the stack and add its value to the answer.
- Move to its right child.
- Repeat until both curr is null and the stack is empty.

## Algorithm
1. Create an empty result list.
2. Create an empty stack of TreeNodes.
3. Set curr = root.
4. While curr != null OR stack is not empty:
      While curr != null:
          push curr
          curr = curr.left
      curr = stack.pop()
      add curr.val to result
      curr = curr.right
5. Return result.

## Time Complexity
### O(n)

Every node is pushed and popped exactly once.

## Space Complexity
### O(n) 

In the worst case because the stack may contain up to n nodes in a highly skewed tree.

## Key Idea

The stack remembers the nodes we need to return to after finishing their left subtree.

In short:
    go LEFT → push nodes
    can't go left → POP and visit ROOT
    then → go RIGHT

Which directly implements:
    LEFT → ROOT → RIGHT