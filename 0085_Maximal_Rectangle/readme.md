# 85. Maximal Rectangle

## Intuition
The matrix itself is difficult to process directly.

Instead, observe that every row can be treated as the base of a histogram.

For each row:
- Every consecutive '1' in a column increases that column's height.
- A '0' resets the height to 0.

After updating the heights for a row, the problem becomes identical to 84. Largest Rectangle in Histogram.

Thus, by repeatedly converting each row into a histogram and solving Histogram for that row, we obtain the largest rectangle in the entire matrix.

## Approach
- Initialize a heights array of size equal to the number of columns.
- Traverse the matrix row by row.
- For each cell:
    - If the cell is '1', increment the corresponding histogram height.
    - Otherwise, reset that height to 0.
- After updating the entire row:
    - Treat the heights array as a histogram.
    - Compute the largest rectangle using the Histogram algorithm (Question 84).
- Update the global maximum area.
- Return the maximum area.

## Algorithm
1. Initialize:
    - heights[] with all zeros.
    - maxArea = 0.
2. Traverse every row.
3. For every column:
    - If:

        matrix[i][j] == '1'

    increase:

        heights[j]++

    otherwise:

        heights[j] = 0
4. Compute:
    
    argestRectangleArea(heights)
5. Update:

    maxArea = max(maxArea, histogramArea)
6. Return maxArea.

## Time Complexity
Let:
- m = rows
- n = columns

Updating histogram heights:

    O(n)

Histogram computation:

    O(n)

Performed for every row:

    O(m × n)

## Space Complexity
### O(n)

Used by:
- Histogram heights array
- Monotonic Stack

## Key Idea
Instead of solving a 2D rectangle problem, transform it into multiple 1D Histogram problems.

Each row represents the bottom of a histogram.

The histogram height of each column equals the number of consecutive '1's ending at the current row.

Once the histogram is built, reuse the Largest Rectangle in Histogram algorithm to find the largest rectangle ending at that row.

2D Matrix
      ↓
Build Histogram
      ↓
Apply Histogram Algorithm (84)
      ↓
Repeat for every row

## Personal Note
Every consecutive '1' increases the column's height.

For example:

    1 0 1 0 0

becomes

    1 0 1 0 0

Next row:

    1 0 1 1 1

updates the histogram to

    2 0 2 1 1

Next row:

    1 1 1 1 1

becomes

    3 1 3 2 2

Each updated row is simply another histogram.

The only thing that changes is the histogram heights—the Histogram algorithm itself never changes.