class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char curr = board[r][c];
                if (curr == '.') {
                    continue;
                }
                int val = curr - '1';

                int b = ((r/3)*3 )+(c/3);

                if (rows[r][val] || cols[c][val] || boxes[b][val]) {
                    return false;
                }

                rows[r][val] = true;
                cols[c][val] = true;
                boxes[b][val] =true;

            }
        }
        return true;
    }
}
