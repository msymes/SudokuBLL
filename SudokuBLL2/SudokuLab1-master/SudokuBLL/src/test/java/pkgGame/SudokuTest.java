package pkgGame;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Arrays;

public class SudokuTest {

	@Test
	public void getRegion_test1() {
		int[][] sud = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
		Sudoku s = new Sudoku(sud);
		int[] region = s.getRegion(0);
		int[] expRegion = { 5, 3, 4, 6, 7, 2, 1, 9, 8 };
		assertTrue(Arrays.equals(expRegion, region));
	}

	@Test /*with column and row number*/
	public void getRegion_test2() {
		int[][] sud = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
		Sudoku s = new Sudoku(sud);
		int[] region = s.getRegion(4, 7);
		int[] expRegion = { 5, 3, 7, 4, 1, 9, 2, 8, 6 };
		assertTrue(Arrays.equals(expRegion, region));
	}
	
	@Test(expected = Exception.class) /*this test will be false if it doesn't throw an exception*/
	public void getRegion_test3() throws Exception {
		int[][] sud = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
		Sudoku s = new Sudoku(sud);
		int[] region = s.getRegion(9);
		int[] expRegion = null;/*doesnt matter what this is we are just testing the exception*/
	}

	@Test(expected = Exception.class) /*this test will be false if it doesn't throw an exception*/
	public void getRegion_test4() throws Exception {
		int[][] sud = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
		Sudoku s = new Sudoku(sud);
		int[] region = s.getRegion(0,9);
		int[] expRegion = null;/*doesnt matter what this is we are just testing the exception*/
	}
	
	@Test /* No Duplicate */
	public void hasDuplicates_test1() {
		int[][] sud = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
		Sudoku s = new Sudoku(sud);
		boolean bHasDuplicates = s.hasDuplicates();
		assertEquals(bHasDuplicates, false);
	}

	@Test /* Duplicate in row 0 */
	public void hasDuplicates_test2() {
		int[][] sud = { { 5, 3, 4, 6, 7, 5, 9, 1, 2 }, { 6, 7, 2, 1, 9, 0, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
		Sudoku s = new Sudoku(sud);
		boolean bHasDuplicates = s.hasDuplicates();
		assertEquals(bHasDuplicates, true);
	}

	@Test /* Duplicate in column 0 */
	public void hasDuplicates_test3() {
		int[][] sud = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 5, 0, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
		Sudoku s = new Sudoku(sud);
		boolean bHasDuplicates = s.hasDuplicates();
		assertEquals(bHasDuplicates, true);
	}

	@Test /* Duplicate in region 0 */
	public void hasDulicates_test4() {
		int[][] sud = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 5, 2, 1, 9, 0, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
		Sudoku s = new Sudoku(sud);
		boolean bHasDuplicates = s.hasDuplicates();
		assertEquals(bHasDuplicates, true);
	}
	
	@Test /*with a correct value*/
	public void isValueValid_test1() {
		int[][] sud = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 0/*the value of 6 should be here*/, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
		Sudoku s = new Sudoku(sud);
		boolean isValueValidActual = s.isValueValid(6,4,3);
		assertEquals(isValueValidActual, true);
	}
	
	@Test /*with a wrong value*/
	public void isValueValid_test2() {
		int[][] sud = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 0/*the value of 6 should be here*/, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
		Sudoku s = new Sudoku(sud);
		boolean isValueValidActual = s.isValueValid(7,4,3);
		assertEquals(isValueValidActual, false);
	}
	
	@Test
	public void isPartialSudoku_test1() {
		int[][] sud = { { 5, 3, 0, 6, 7, 8, 0, 1, 2 }, { 6, 7, 0, 1, 9, 5, 3, 4, 8 }, { 1, 0, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 0, 0 }, { 0, 2, 6, 0, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 0, 0, 8, 5, 6 },
				{ 9, 6, 0, 5, 3, 7, 0, 0, 4 }, { 2, 8, 7, 4, 1, 0, 6, 3, 5 }, { 0, 0, 5, 2, 8, 0, 1, 7, 9 } };
		Sudoku s = new Sudoku(sud);
		boolean isPartialSudoku = s.isPartialSudoku();
		assertEquals(isPartialSudoku, true);
	}
	
	@Test
	public void isPartialSudoku_test2() {
		int[][] sud = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
		Sudoku s = new Sudoku(sud);
		boolean isPartialSudoku = s.isPartialSudoku();
		assertEquals(isPartialSudoku, false);
	}
	
	@Test
	public void isPartialSudoku_test3() {
		int[][] sud = { { 5, 3, 4, 6, 7, 5, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 0, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
		Sudoku s = new Sudoku(sud);
		boolean isPartialSudoku = s.isPartialSudoku();
		assertEquals(isPartialSudoku, false);
	}
	
	@Test
	public void isSudoku_test1() {
		int[][] sud = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 }, { 6, 7, 2, 1, 9, 5, 3, 4, 8 }, { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
				{ 8, 5, 9, 7, 6, 1, 4, 2, 3 }, { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
				{ 9, 6, 1, 5, 3, 7, 2, 8, 4 }, { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
		Sudoku s = new Sudoku(sud);
		boolean isSudoku = s.isSudoku();
		assertEquals(isSudoku, true);
	}
	
	@Test (expected = Exception.class)
	public void sudoku_test1() throws Exception {
		Sudoku newSudoku = new Sudoku(5);
		/*Should cause an exception*/
	}
	
	@Test (expected= Exception.class)
	public void sudoku_test2() throws Exception{
		int[][] latinSquare = {{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4},{0,1,2,3,4}};
		Sudoku newSudoku = new Sudoku(latinSquare);
	}
	
}
