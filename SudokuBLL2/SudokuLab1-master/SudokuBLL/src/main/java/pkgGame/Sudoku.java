package pkgGame;

import java.util.Arrays;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare {
	private int iSize; /*the length of the hieght of the puzzle*/
	private int iSqrtSize; /*the square root of iSize*/
	
	
	public Sudoku() {
		super();
	}
	
	public Sudoku(int iSize) {
		if ((int)Math.sqrt(iSize)!=Math.sqrt(iSize)){
			/* idk how to do this the exception */
		}
		else {
			this.iSize=iSize;
			this.iSqrtSize=(int)Math.sqrt(iSize);
		}
	}
	
	public Sudoku(int[][] latinSquare) {
		super(latinSquare);
		if ((int)Math.sqrt(latinSquare.length)!=Math.sqrt(latinSquare.length)) {
			/*dont know how to do exception*/
		}
		else {
			this.iSize=latinSquare.length;
			this.iSqrtSize=(int)Math.sqrt(latinSquare.length);
		}
	}
	
	protected int[][] getPuzzle(){
		return super.getLatinSquare();
	}
	
	protected int[] getRegion(int iRegionNbr) {
		return null;
	}
	
	protected int[] getRegion(int Col, int Row) {
		return null;
	}
	
	/**
	 * If the puzzle is a LatinSquare... and each value of each region exists in the first row
	 * of the puzzle
	 * 
	 * @return true, if its a complete Sudoku
	 */
	protected boolean isSudoku() {
		return false;
	}
	
	/**
	 * If the puzzle is a Sudoku...and any of the values is zero
	 * 
	 * @return true
	 */
	protected boolean isPartialSudoku() {
		return false;
	}
	
	/**
	 * 
	 * @param iValue - value youre attempting
	 * @param Col - column in the puzzle
	 * @param Row - row in the puzzle
	 * @return - true if the given value is possible
	 */
	protected boolean isValueValid(int iValue, int Col, int Row) {
		return false;
	}

}
