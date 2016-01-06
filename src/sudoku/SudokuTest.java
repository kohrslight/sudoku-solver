package sudoku;

import static org.junit.Assert.*;
import org.junit.Test;


public class SudokuTest {

//    @Test
//    public void test() {
//        int[][] puzzle = {{0, 0, 0, 2, 6, 0, 7, 0, 1},
//                {6, 8, 0, 0, 7, 0, 0, 9, 0},
//                {1, 9, 0, 0, 0, 4, 5, 0, 0},
//                {8, 2, 0, 1, 0, 0, 0, 4, 0},
//                {0, 0, 4, 4, 0, 2, 9, 0, 0},
//                {0, 5, 0, 0, 0, 3, 0, 2, 8},
//                {0, 0, 9, 3, 0, 0, 0, 7, 4},
//                {0, 4, 0, 0, 5, 0, 0, 3, 6},
//                {7, 0, 3, 0, 1, 8, 0, 0, 0}};
//        Sudoku sudoku = new Sudoku(puzzle);
//        sudoku.solve();
//        
//        System.out.println(sudoku.toString());
//    }
    
    @Test
    public void testAlreadySolved() {
        int[][] puzzle = new int[][] {
            { 2, 4, 8,  3, 9, 5,  7, 1, 6, },
            { 5, 7, 1,  6, 2, 8,  3, 4, 9, },
            { 9, 3, 6,  7, 4, 1,  5, 8, 2, },

            { 6, 8, 2,  5, 3, 9,  1, 7, 4, },
            { 3, 5, 9,  1, 7, 4,  6, 2, 8, },
            { 7, 1, 4,  8, 6, 2,  9, 5, 3, },

            { 8, 6, 3,  4, 1, 7,  2, 9, 5, },
            { 1, 9, 5,  2, 8, 6,  4, 3, 7, },
            { 4, 2, 7,  9, 5, 3,  8, 6, 1, },
        };
        Sudoku sudoku = new Sudoku(puzzle);
        assertTrue(sudoku.solve());
        
        assertEquals(puzzleSolved, sudoku.getPuzzle());
    }
    
    @Test
    public void testOneEmptyCell() {
        int[][] puzzle = new int[][] {
            { 2, 4, 8,  3, 9, 5,  7, 1, 6, },
            { 5, 7, 1,  6, 2, 8,  3, 4, 9, },
            { 9, 3, 6,  7, 4, 1,  5, 8, 2, },

            { 6, 8, 2,  0, 3, 9,  1, 7, 4, },
            { 3, 5, 9,  1, 7, 4,  6, 2, 8, },
            { 7, 1, 4,  8, 6, 2,  9, 5, 3, },

            { 8, 6, 3,  4, 1, 7,  2, 9, 5, },
            { 1, 9, 5,  2, 8, 6,  4, 3, 7, },
            { 4, 2, 7,  9, 5, 3,  8, 6, 1, },
        };
        Sudoku sudoku = new Sudoku(puzzle);
        sudoku.solve();
        
        int[][] puzzleSolved = new int[][] {
            { 2, 4, 8,  3, 9, 5,  7, 1, 6, },
            { 5, 7, 1,  6, 2, 8,  3, 4, 9, },
            { 9, 3, 6,  7, 4, 1,  5, 8, 2, },

            { 6, 8, 2,  5, 3, 9,  1, 7, 4, },
            { 3, 5, 9,  1, 7, 4,  6, 2, 8, },
            { 7, 1, 4,  8, 6, 2,  9, 5, 3, },

            { 8, 6, 3,  4, 1, 7,  2, 9, 5, },
            { 1, 9, 5,  2, 8, 6,  4, 3, 7, },
            { 4, 2, 7,  9, 5, 3,  8, 6, 1, },
        };
        assertEquals(puzzleSolved, sudoku.getPuzzle());
    }

}
