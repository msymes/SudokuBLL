package pkgHelper;

import static org.junit.Assert.*;

import org.junit.Test;

public class LatinSquareTest {

	@Test
	public void hasDuplicates_test1() {
		
		int [] arr = {1,2,3,4,5};
		LatinSquare lq = new LatinSquare();
		
		assertFalse(lq.hasDuplicates(arr));
	}
	@Test
	public void hasDuplicates_test2() {
		
		int [] arr = {1,2,3,4,1};
		LatinSquare lq = new LatinSquare();
		
		assertTrue(lq.hasDuplicates(arr));
}
	@Test
	public void hasDuplicates_test3() {
		
		int [] arr = {1,1,3,4,5};
		LatinSquare lq = new LatinSquare();
		
		assertTrue(lq.hasDuplicates(arr));
}
	@Test
	public void hasDuplicates_test4() {
		
		int [] arr = null;
		LatinSquare lq = new LatinSquare();
		
		assertFalse(lq.hasDuplicates(arr));
	}
	
	@Test
	public void doesElementExist_Test1() {
		int [] arr = {1,2,3,4,5};
		int iValue = 3;
		
		LatinSquare lq = new LatinSquare();
		
		assertTrue(lq.doesElementExist(arr,iValue));
	}
	
	@Test
	public void doesElementExist_Test2() {
		int [] arr = {1,2,3,4,5};
		int iValue = 99;
		
		LatinSquare lq = new LatinSquare();
		
		assertFalse(lq.doesElementExist(arr,iValue));
	}
	@Test
	public void doesElementExist_Test3() {
		int [] arr = null;
		int iValue = 1;
		
		LatinSquare lq = new LatinSquare();
		
		assertFalse(lq.doesElementExist(arr,iValue));
}
	@Test
	public void hasAllValues_Test1() {
		int[] arr1 = {1,2,3,4};
		int[] arr2 = {1,2};
		
		boolean bExpected = true;
		boolean bActual = LatinSquare.hasAllValues(arr1, arr2);
		assertEquals(bExpected,bActual);
	}
	@Test
	public void hasAllValues_Test2() {
		int[] arr1 = {1,2,3,4};
		int[] arr2 = {1,2,5};
		
		boolean bExpected = false;
		boolean bActual = LatinSquare.hasAllValues(arr1, arr2);
		assertEquals(bExpected,bActual);
	}
	@Test
	public void ContainsZero_Test1() {
		int[][] puzzle = {{1,2,3},{2,3,1},{3,1,2}};
		LatinSquare ls = new LatinSquare(puzzle);
		boolean bExpected = false;
		boolean bActual = ls.ContainsZero();
		assertEquals(bExpected,bActual);
	}
	@Test
	public void ContainsZero_Test2() {
		int[][] puzzle = {{1,2,3},{0,3,1},{3,1,2}};
		LatinSquare ls = new LatinSquare(puzzle);
		boolean bExpected = true;
		boolean bActual = ls.ContainsZero();
		assertEquals(bExpected,bActual);
	}
	}
	


