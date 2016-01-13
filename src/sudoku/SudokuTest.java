package sudoku;

import static org.junit.Assert.*;
import org.junit.Test;

public class SudokuTest {
    
    @Test
    public void testNoSolution() {
        int[][] puzzle = new int[][] {
            { 5, 1, 6,  8, 4, 9,  7, 3, 2 },
            { 3, 0, 7,  6, 0, 5,  0, 0, 0 },
            { 8, 0, 9,  7, 0, 0,  0, 6, 5 },

            { 1, 3, 5,  0, 6, 0,  9, 0, 7 },
            { 4, 7, 2,  5, 9, 1,  0, 0, 6 },
            { 9, 6, 8,  3, 7, 0,  0, 5, 0 },

            { 2, 5, 3,  1, 8, 6,  0, 7, 4 },
            { 6, 8, 4,  2, 0, 7,  5, 0, 0 },
            { 7, 9, 1,  0, 5, 0,  6, 0, 8 },
        };
        Sudoku sudoku = new Sudoku(puzzle);
        assertFalse(sudoku.solve());
    }
    
    @Test
    public void testAlreadySolved() {
        int[][] puzzle = new int[][] {
            { 2, 4, 8,  3, 9, 5,  7, 1, 6 },
            { 5, 7, 1,  6, 2, 8,  3, 4, 9 },
            { 9, 3, 6,  7, 4, 1,  5, 8, 2 },

            { 6, 8, 2,  5, 3, 9,  1, 7, 4 },
            { 3, 5, 9,  1, 7, 4,  6, 2, 8 },
            { 7, 1, 4,  8, 6, 2,  9, 5, 3 },

            { 8, 6, 3,  4, 1, 7,  2, 9, 5 },
            { 1, 9, 5,  2, 8, 6,  4, 3, 7 },
            { 4, 2, 7,  9, 5, 3,  8, 6, 1 },
        };
        Sudoku sudoku = new Sudoku(puzzle);
        assertTrue(sudoku.solve());
        
        int[][] puzzleSolved = new int[][] {
            { 2, 4, 8,  3, 9, 5,  7, 1, 6 },
            { 5, 7, 1,  6, 2, 8,  3, 4, 9 },
            { 9, 3, 6,  7, 4, 1,  5, 8, 2 },

            { 6, 8, 2,  5, 3, 9,  1, 7, 4 },
            { 3, 5, 9,  1, 7, 4,  6, 2, 8 },
            { 7, 1, 4,  8, 6, 2,  9, 5, 3 },

            { 8, 6, 3,  4, 1, 7,  2, 9, 5 },
            { 1, 9, 5,  2, 8, 6,  4, 3, 7 },
            { 4, 2, 7,  9, 5, 3,  8, 6, 1 },
        };
        
        assertArrayEquals(puzzleSolved, sudoku.getPuzzle());
    }
    
    @Test
    public void testOneEmptyCell() {
        int[][] puzzle = new int[][] {
            { 2, 4, 8,  3, 9, 5,  7, 1, 6 },
            { 5, 7, 1,  6, 2, 8,  3, 4, 9 },
            { 9, 3, 6,  7, 4, 1,  5, 8, 2 },

            { 6, 8, 2,  0, 3, 9,  1, 7, 4 },
            { 3, 5, 9,  1, 7, 4,  6, 2, 8 },
            { 7, 1, 4,  8, 6, 2,  9, 5, 3 },

            { 8, 6, 3,  4, 1, 7,  2, 9, 5 },
            { 1, 9, 5,  2, 8, 6,  4, 3, 7 },
            { 4, 2, 7,  9, 5, 3,  8, 6, 1 },
        };
        Sudoku sudoku = new Sudoku(puzzle);
        assertTrue(sudoku.solve());
        
        int[][] puzzleSolved = new int[][] {
            { 2, 4, 8,  3, 9, 5,  7, 1, 6 },
            { 5, 7, 1,  6, 2, 8,  3, 4, 9 },
            { 9, 3, 6,  7, 4, 1,  5, 8, 2 },

            { 6, 8, 2,  5, 3, 9,  1, 7, 4 },
            { 3, 5, 9,  1, 7, 4,  6, 2, 8 },
            { 7, 1, 4,  8, 6, 2,  9, 5, 3 },

            { 8, 6, 3,  4, 1, 7,  2, 9, 5 },
            { 1, 9, 5,  2, 8, 6,  4, 3, 7 },
            { 4, 2, 7,  9, 5, 3,  8, 6, 1 },
        };
        assertArrayEquals(puzzleSolved, sudoku.getPuzzle());
    }
    
    @Test
    public void testMultipleEmptyCells() {
        int[][] puzzle = new int[][] {
            { 2, 4, 8,  3, 9, 5,  7, 1, 6 },
            { 5, 7, 1,  6, 2, 8,  3, 4, 9 },
            { 9, 3, 6,  7, 4, 1,  5, 8, 2 },

            { 6, 8, 2,  0, 3, 9,  1, 7, 4 },
            { 3, 5, 9,  1, 7, 4,  6, 2, 8 },
            { 7, 1, 4,  8, 6, 2,  9, 5, 3 },

            { 8, 6, 3,  4, 1, 7,  0, 9, 5 },
            { 1, 9, 5,  0, 8, 6,  4, 3, 0 },
            { 4, 2, 7,  9, 5, 3,  8, 6, 1 },
        };
        Sudoku sudoku = new Sudoku(puzzle);
        assertTrue(sudoku.solve());
        
        int[][] puzzleSolved = new int[][] {
            { 2, 4, 8,  3, 9, 5,  7, 1, 6 },
            { 5, 7, 1,  6, 2, 8,  3, 4, 9 },
            { 9, 3, 6,  7, 4, 1,  5, 8, 2 },

            { 6, 8, 2,  5, 3, 9,  1, 7, 4 },
            { 3, 5, 9,  1, 7, 4,  6, 2, 8 },
            { 7, 1, 4,  8, 6, 2,  9, 5, 3 },

            { 8, 6, 3,  4, 1, 7,  2, 9, 5 },
            { 1, 9, 5,  2, 8, 6,  4, 3, 7 },
            { 4, 2, 7,  9, 5, 3,  8, 6, 1 },
        };
        assertArrayEquals(puzzleSolved, sudoku.getPuzzle());
    }
    
    @Test
    public void testNewspaperSudokuEasy() {
        int[][] puzzle = new int[][] {
            { 0, 0, 2,  0, 3, 0,  7, 8, 5 },
            { 0, 7, 0,  5, 0, 0,  0, 0, 2 },
            { 0, 0, 5,  0, 8, 0,  0, 0, 0 },

            { 0, 0, 4,  8, 5, 0,  6, 9, 0 },
            { 1, 0, 0,  9, 0, 4,  0, 0, 7 },
            { 0, 5, 9,  0, 2, 7,  4, 0, 0 },

            { 0, 0, 0,  0, 9, 0,  3, 0, 0 },
            { 2, 0, 0,  0, 0, 5,  0, 4, 0 },
            { 9, 6, 8,  0, 7, 0,  5, 0, 0 },
        };
        Sudoku sudoku = new Sudoku(puzzle);
        assertTrue(sudoku.solve());
        
        int[][] puzzleSolved = new int[][] {
            { 4, 9, 2,  1, 3, 6,  7, 8, 5 },
            { 8, 7, 6,  5, 4, 9,  1, 3, 2 },
            { 3, 1, 5,  7, 8, 2,  9, 6, 4 },

            { 7, 2, 4,  8, 5, 1,  6, 9, 3 },
            { 1, 8, 3,  9, 6, 4,  2, 5, 7 },
            { 6, 5, 9,  3, 2, 7,  4, 1, 8 },

            { 5, 4, 1,  2, 9, 8,  3, 7, 6 },
            { 2, 3, 7,  6, 1, 5,  8, 4, 9 },
            { 9, 6, 8,  4, 7, 3,  5, 2, 1 },
        };
        assertArrayEquals(puzzleSolved, sudoku.getPuzzle());
    }

    @Test
    public void testNewspaperSudokuHard() {
        int[][] puzzle = new int[][] {
            { 7, 0, 0,  0, 6, 4,  0, 0, 0 },
            { 0, 0, 3,  0, 0, 0,  6, 0, 4 },
            { 0, 0, 8,  0, 0, 0,  5, 0, 0 },

            { 0, 3, 0,  0, 1, 8,  7, 0, 0 },
            { 6, 0, 0,  2, 0, 5,  0, 0, 3 },
            { 0, 0, 9,  7, 3, 0,  0, 2, 0 },

            { 0, 0, 7,  0, 0, 0,  9, 0, 0 },
            { 2, 0, 6,  0, 0, 0,  4, 0, 0 },
            { 0, 0, 0,  1, 7, 0,  0, 0, 8 },
        };
        Sudoku sudoku = new Sudoku(puzzle);
        assertTrue(sudoku.solve());
        
        int[][] puzzleSolved = new int[][] {
            { 7, 9, 5,  8, 6, 4,  3, 1, 2 },
            { 1, 2, 3,  9, 5, 7,  6, 8, 4 },
            { 4, 6, 8,  3, 2, 1,  5, 7, 9 },

            { 5, 3, 2,  4, 1, 8,  7, 9, 6 },
            { 6, 7, 1,  2, 9, 5,  8, 4, 3 },
            { 8, 4, 9,  7, 3, 6,  1, 2, 5 },

            { 3, 8, 7,  6, 4, 2,  9, 5, 1 },
            { 2, 1, 6,  5, 8, 9,  4, 3, 7 },
            { 9, 5, 4,  1, 7, 3,  2, 6, 8 },
        };
        assertArrayEquals(puzzleSolved, sudoku.getPuzzle());
    }
    
}
