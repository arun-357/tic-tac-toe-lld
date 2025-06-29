public class Board {
    private int size;
    private Cell[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new Cell[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                grid[i][j] = new Cell();
    }

    public boolean makeMove(int r, int c, char symbol) {
        if (r < 0 || c < 0 || r >= size || c >= size || !grid[r][c].isEmpty()) return false;
        grid[r][c].setValue(symbol);
        return true;
    }

    public boolean checkWin(char symbol) {
        for (int i = 0; i < size; i++)
        {
            boolean rowMatch = true;
            boolean colMatch = true;
            for (int j = 0; j < size; j++) {
                if(grid[i][j].getValue() != symbol) rowMatch = false;
                if(grid[j][i].getValue() != symbol) colMatch = false;
            }

            if (rowMatch || colMatch)
                return true;
        }

        // diag
        boolean diag1 = true;
        boolean diag2 = true;
        for (int i = 0; i < size; i++) {
            if(grid[i][i].getValue() != symbol) diag1 = false;
            if(grid[i][size-i-1].getValue() != symbol) diag2 = false;
        }

        return diag1 || diag2;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(grid[i][j].isEmpty()) return false;
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.print(grid[i][j].getValue() + " ");
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }
}
