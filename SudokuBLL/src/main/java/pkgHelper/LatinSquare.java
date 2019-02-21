package pkgHelper;

import java.util.Arrays;

public class LatinSquare {

	private int[][] LatinSquare;//first number is row, second is column

	public LatinSquare()
	{
	}
	
	public LatinSquare(int[][] puzzle) {
		super();
		this.LatinSquare = puzzle;
	}
	
	public int[][] getLatinSquare() {
		return LatinSquare;
	}
	
	public void setLatinSquare(int[][] latinSquare) {
		LatinSquare = latinSquare;
	}
	
	public boolean hasDuplicates(int [] arr){
		boolean hasDuplicates = false;
		
		if (arr == null)
			return false;
		Arrays.sort(arr);
		
		for (int i = 0; i< arr.length -1; i++)
		{
			if (arr[i] == arr[i+1])
			{
				hasDuplicates = true;
				break;
			}
		}
		return hasDuplicates;
	}
		
	public static boolean doesElementExist(int[] arr, int iValue) {
		if(arr == null) 
			return false;
		
		for (int i: arr) {
			if (i == iValue) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean hasAllValues(int[] arr1, int[] arr2) {
		/*go through each value in arr2
		 * check that each value is in arr1*/
		boolean hasAllValues = false;
		boolean bFound = false;
		for (int j = 0; j < arr2.length; j++) {
			for (int i = 0; i < arr1.length; i++) {
				if (arr1[i]==arr2[j]) {
					bFound = true;
				}
				else {
					bFound = false;
					break;
				}
			}
		}
		hasAllValues = bFound;
		return hasAllValues;
	}
	
	public int[] getColumn(int iColumn) {
		int[] getColumn = {};
		
		return getColumn;
	}
	
	public int[] getRow(int iRow) {
		int[] getRow = {};
		
		return getRow;
	}
	
	public boolean isLatinSquare() {
		boolean isLatinSquare = false;
		
		return isLatinSquare;
	}
	
	public boolean ContainsZero() {
		boolean ContainsZero = false;
		for (int iRow=0; iRow < this.LatinSquare.length; iRow++) {
			for (int iColumn=0; iColumn < this.LatinSquare.length; iColumn++) {
				if (LatinSquare[iRow][iColumn]==0){
					return true;
				}
			}
		}
		return ContainsZero;
	}
	}
	
