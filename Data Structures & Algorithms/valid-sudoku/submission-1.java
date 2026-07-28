class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Track seen numbers (0-8) for each of the 9 rows, 9 columns, and 9 sub-boxes
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        // Loop through every row on the 9x9 board
        for (int r = 0; r < 9; r++) {
            // Loop through every column in the current row
            for (int c = 0; c < 9; c++) {
                // Get the character value at the current cell
                char curr = board[r][c];

                // Skip empty cells since they don't violate Sudoku rules
                if (curr == '.') {
                    continue;
                }

                // Convert char '1'-'9' to 0-based index 0-8 ('1' -> 0, '9' -> 8)
                int val = curr - '1';

                // Map current (r, c) coordinates to a 3x3 sub-box index (0 to 8)
                int b = ((r / 3) * 3) + (c / 3);

                // Check if this digit has already appeared in the same row, col, or box
                if (rows[r][val] || cols[c][val] || boxes[b][val]) {
                    return false; // Duplicate found; invalid board
                }

                // Mark this digit as seen in the respective row, col, and sub-box
                rows[r][val] = true;
                cols[c][val] = true;
                boxes[b][val] = true;
            }
        }

        // Return true if all filled cells pass without any duplicates
        return true;
    }
}