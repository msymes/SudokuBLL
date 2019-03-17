package pkgHelper;

import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang.ArrayUtils;

public class LatinSquare {
	private boolean bIgnoreZero;
	private ArrayList<PuzzleViolation> PV;
	
	private int[][] LatinSquare;

	public LatinSquare() {
	}

	public LatinSquare(int[][] puzzle) {
		this.LatinSquare = puzzle;
	}

	public int[][] getLatinSquare() {
		return LatinSquare;
	}
	
	public void setLatinSquare(int[][] latinSquare) {
		LatinSquare = latinSquare;
	}
	
	public int[] getColumn(int iCol) {

		// TODO: Return a given column from LatinSquare

		int[] Col = new int[this.LatinSquare.length];

		for (int row = 0; row < this.LatinSquare.length; row++) {
			Col[row] = LatinSquare[row][iCol];
		}
		return Col;
	}
	
	public int[] getRow(int iRow) {
		// TODO: Return a given row from LatinSquare

		int[] Row = new int[this.LatinSquare.length];

		Row = this.LatinSquare[iRow];

		return Row;
	}
	
	public boolean isbIgnoreZero() {
		return this.bIgnoreZero;
	}
	
	protected void setbIgnoreZero(boolean bIgnoreZero) {
		this.bIgnoreZero = bIgnoreZero;
	}
	
	public boolean ContainsZero() {
		for (int i = 0; i < LatinSquare.length; i++) {
			for (int j = 0; j < LatinSquare.length; j++) {
				if (LatinSquare[i][j] == 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public int[] RemoveZeros(int[] arr) {
		int[] noZeroArray = Arrays.copyOf(arr, arr.length);
		while (ArrayUtils.contains(noZeroArray,0)); {
			noZeroArray = ArrayUtils.removeElement(noZeroArray,0);
		}
		return noZeroArray;
	}

	protected final boolean hasDuplicates(int[] arr) {
		if (isbIgnoreZero()) {
			arr = RemoveZeros(arr);
		}

		// TODO: Return 'true' if any element in arr is duplicate

		boolean hasDuplicates = false;
		int[] sortedArray = Arrays.copyOf(arr, arr.length);
		Arrays.sort(sortedArray);

		for (int i = 0; i < sortedArray.length - 1; i++) {
			if (sortedArray[i] == sortedArray[i + 1]) {
				hasDuplicates = true;
				break;
			}
		}
		return hasDuplicates;
	}
	
	protected boolean hasDuplicates() {
		boolean hasDuplicates = false;
		
		for (int i = 0; i < LatinSquare.length; i++) {
			if (hasDuplicates(getRow(i))) {
				hasDuplicates=true;
			}
		}
		for (int j = 0; j < LatinSquare.length; j++) {
			if (hasDuplicates(getColumn(j))) {
				hasDuplicates=true;
			}
		}
		return hasDuplicates;

	}
	
	public boolean doesElementExist(int[] arr, int iValue) {
		// TODO: Return 'true' if iValue is found in arr

		boolean doesElementExist = false;
		for (int i = 0; i < arr.length; i++) {
			if (iValue == arr[i]) {
				doesElementExist = true;
				break;
			}
		}
		return doesElementExist;
	}

	public boolean hasAllValues(int[] arr1, int[] arr2) {
		// TODO: Return 'true' if every element from arr2 is in arr1

		boolean hasAllValues = true;
		for (int j = 0; j < arr2.length; j++) {

			boolean bFound = false;

			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i] == arr2[j]) {
					bFound = true;
					break;
				}

			}
			if (bFound == false) {
				hasAllValues = false;
				break;
			}
		}
		return hasAllValues;

	}

	public boolean isLatinSquare() {

		boolean isLatinSquare = true;
		// TODO: Return 'true' if...
		// Each row and column doesn't contain duplicates
		// If each element in the first row is found in every other row
		// If each element in the first column is found in every other column

		// Check to see if the any row or column has duplicates. If they do, return
		// false;
		for (int i = 0; i < LatinSquare.length; i++) {
			if (hasDuplicates(getRow(i)))
				return false;
		}

		for (int j = 0; j < LatinSquare.length; j++) {
			if (hasDuplicates(getColumn(j)))
				return false;
		}

		for (int i = 1; i < LatinSquare.length; i++) {

			if (!hasAllValues(getRow(0), getRow(i))) {
				return false;
			}
		}

		for (int j = 1; j < LatinSquare.length; j++) {

			if (!hasAllValues(getColumn(0), getColumn(j))) {
				return false;
			}
		}

		return isLatinSquare;
	}

	protected void AddPuzzleViolation(PuzzleViolation pv) {
		PV.add(pv);
	}
	
	protected void ClearPuzzleViolation() {
		PV.clear();
	}
	
	protected ArrayList<PuzzleViolation> getPV(){
		return PV;
	}
	
}
