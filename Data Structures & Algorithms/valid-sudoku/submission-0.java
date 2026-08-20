class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.')
                    continue;

                int val = 1 << (ch - '1');

                int boxIdx = (r / 3) * 3 + (c / 3);

                if ((rows[r] & val) != 0 || (cols[c] & val) != 0 || (boxes[boxIdx] & val) != 0) {
                    return false;
                }

                rows[r] |= val;
                cols[c] |= val;
                boxes[boxIdx] |= val;
            }
        }

        return true;
    }
}
