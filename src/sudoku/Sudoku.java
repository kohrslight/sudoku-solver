package sudoku;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

    private final int[][] puzzle;
    private final int blockSize;
    private final int puzzleSize;
    
    // Abstraction function:
    //   Represents a sudoku puzzle of dimensions puzzleSize x puzzleSize
    //      where a cell at row r and column c is a blank if puzzle[r][c] = 0
    //      or the number puzzle[r][c] otherwise
    // Rep invariant:
    //   blockSize * blockSize = puzzleSize
    //   blockSize > 0
    //   puzzleSize > 0
    //   puzzleSize = puzzle.length
    //   puzzleSize = puzzle[i].length for 0 <= i < puzzleSize
    //   for 0 <= i,j <= puzzleSize, 0 <= puzzle[i][j] <= puzzleSize
    //   a non-zero number appears at most once in a given row, column,
    //      or block
    // Safety from rep exposure:
    //   All fields are private and final.
    //   Defensive copies are made when creating the puzzle board
    //      and returning the puzzle board, so the client doesn't share
    //      references to puzzle.
    
    /**
     * Create a Sudoku object from a starting 2D array.
     * 
     * @param puzzle the starting puzzle of square dimensions
     *      in which any blank is represented as a 0 in the array
     *      and any number is that number in the array
     */
    public Sudoku(int[][] puzzle) {
        this.puzzleSize = puzzle.length;
        this.blockSize = (int) Math.sqrt(puzzleSize);
        this.puzzle = copyPuzzle(puzzle);
        
        checkRep();
    }
    
    /**
     * Assert the Rep invariant as stated above.
     */
    public void checkRep() {
        assert blockSize > 0;
        assert puzzleSize > 0;
        assert blockSize * blockSize == puzzleSize;
        assert puzzleSize == puzzle.length;
        for (int i = 0; i < puzzleSize; i++) {
            assert puzzleSize == puzzle[i].length;
        }
        for (int r = 0; r < puzzleSize; r++) {
            for (int c = 0; c < puzzleSize; c++) {
                int value = puzzle[r][c];
                assert value >= 0 && value <= puzzleSize;
            }
        }
    }
    
    /**
     * Get a copy of a puzzle board.
     * 
     * @param original a 2D array of dimensions
     *      puzzleSize x puzzleSize
     * @return a new 2D array of dimensions
     *      puzzleSize x puzzleSize which is an exact copy
     *      of the original
     */
    public int[][] copyPuzzle(int[][] original) {
        int[][] copy = new int[puzzleSize][puzzleSize];
        for (int r = 0; r < puzzleSize; r++) {
            for (int c = 0; c < puzzleSize; c++) {
                copy[r][c] = original[r][c];
            }
        }
        return copy;
    }
    
    /**
     * Get a set of all non-zero values in a specified row
     * of the puzzle.
     * 
     * @param row the row of interest, 0 <= row < puzzleSize
     * @return the set of all non-zero values in the row
     */
    public Set<Integer> getRowVals(int row) {
        Set<Integer> rowVals = new HashSet<>();
        for (int i = 0; i < puzzleSize; i++) {
            int val = puzzle[row][i];
            if (1 <= val && val <= puzzleSize) {
                rowVals.add(val);
            }
        }
        return rowVals;
    }
    
    /**
     * Get a set of all non-zero values in a specified column
     * of the puzzle.
     * 
     * @param col the column of interest, 0 <= col < puzzleSize
     * @return the set of all non-zero values in the column
     */
    public Set<Integer> getColVals(int col) {
        Set<Integer> colVals = new HashSet<>();
        for (int i = 0; i < puzzleSize; i++) {
            int val = puzzle[i][col];
            if (1 <= val && val <= puzzleSize) {
                colVals.add(val);
            }
        }
        return colVals;
    }
    
    /**
     * Get a set of all non-zero values in a specified block
     * of the puzzle.
     * 
     * @param row the row of the cell in which the block values
     *      are desired
     * @param col the column of the cell in which the block values
     *      are desired
     * @return the set of all non-zero values in the block that
     *      contains the cell at (row, col)
     */
    public Set<Integer> getBlockVals(int row, int col) {
        Set<Integer> blockVals = new HashSet<>();
        int startRow = row / blockSize * blockSize;
        int startCol = col / blockSize * blockSize;
        for (int r = startRow; r < startRow + blockSize; r++) {
            for (int c = startCol; c < startCol + blockSize; c++) {
                int val = puzzle[r][c];
                if (1 <= val && val <= puzzleSize) {
                    blockVals.add(val);
                }
            }
        }
        return blockVals;
    }
    
    /**
     * Solve the sudoku puzzle if it can be solved. If multiple solutions
     * are possible, solves the puzzle with a valid solution.
     * 
     * @return true if the puzzle is now solved
     */
    public boolean solve() {
        // find empty cell
        for (int r = 0; r < puzzleSize; r++) {
            for (int c = 0; c < puzzleSize; c++) {
                int val = puzzle[r][c];
                if (val < 1 || val > puzzleSize) {
                    Set<Integer> invalidVals = new HashSet<>();
                    invalidVals.addAll(getRowVals(r));
                    invalidVals.addAll(getColVals(c));
                    invalidVals.addAll(getBlockVals(r, c));
                    
                    // choose value not in invalidVals
                    for (int i = 1; i <= puzzleSize; i++) {
                        if (!invalidVals.contains(i)) {
                            puzzle[r][c] = i;
                            if (solve()) { 
                                // puzzle can be solved with this cell value
                                return true;
                            }
                            // puzzle can't be solved with this cell value
                            // clear selection and try different value
                            puzzle[r][c] = 0; // TODO is this needed 
                        }
                    }
                    return false;
                }
            }
        }
        // no empty cells --> puzzle already solved
        return true;
    }
    
    /**
     * Get the puzzle corresponding to this sudoku puzzle as a
     * 2D array.
     * 
     * @return the 2D array of this sudoku puzzle
     */
    public int[][] getPuzzle() {
        return copyPuzzle(this.puzzle);
    }
    
    @Override
    public String toString() {
        String result = "";
        for (int r = 0; r < puzzleSize; r++) {
            for (int c = 0; c < puzzleSize; c++) {
                int value = puzzle[r][c];
                if (value < 1 || value > puzzleSize) {
                    result += "-";
                } else {
                    result += value;
                }
            }
            result += "\n";
        }
        return result;
    }
    
}
