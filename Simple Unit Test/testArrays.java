import org.junit.Assert;
import org.junit.Test;

public class testArrays {
	MergeUniqueArrays mergeUniqueArrays = new MergeUniqueArrays();

	//tests for arrays of same length
	@Test
	public void testMergedArrays() {
		int [] firstArr = {200,40,201,105,1,35,45};
		int [] secondArr = {2,4,500,20,10,50,1000};
		int []  merge = {1,2,4,10,20,35,40,45,50,105,200,201,500,1000};
		Assert.assertArrayEquals(merge, MergeUniqueArrays.mergeArrays(firstArr,secondArr));	
		Assert.assertArrayEquals(merge, MergeUniqueArrays.mergeArrays(secondArr,firstArr));

	}
	

	@Test
	public void testEmptyFirstArray() {
		int [] firstArr = null ;
		int [] secondArr = {2,4,500,20,10,50};
		int []  merge = {2,4,500,20,10,50};
		Assert.assertArrayEquals(merge, MergeUniqueArrays.mergeArrays(firstArr,secondArr));
		
		
	}
	
	@Test
	public void testEmptyFirstArray2() {
		int [] firstArr = {};
		int [] secondArr = {2,4,500,20,10,50};
		int []  merge = {2,4,500,20,10,50};
		Assert.assertArrayEquals(merge, MergeUniqueArrays.mergeArrays(firstArr,secondArr));
		
		
		
		
	}
	@Test
	public void testEmptyArrays() {
		int [] firstArr = null;
		int [] secondArr = null;
		int []  merge = null;
		Assert.assertArrayEquals(merge, MergeUniqueArrays.mergeArrays(firstArr,secondArr));
		
		
	}
	
	@Test
	public void testEmptySecondArray() {
		int [] firstArr = {200,40,201,105,1,35};
		int [] secondArr = null;
		int []  merge = {200,40,201,105,1,35};
		Assert.assertArrayEquals(merge, MergeUniqueArrays.mergeArrays(firstArr,secondArr));
		
		
		
	}
	
	@Test
	public void testEmptySecondArray2() {
		int [] firstArr = {200,40,201,105,1,35};
		int [] secondArr = {};
		int []  merge = {200,40,201,105,1,35};
		Assert.assertArrayEquals(merge, MergeUniqueArrays.mergeArrays(firstArr,secondArr));
		
		
		
	}

	
	
	
	

	
	
	
	
	
	

}