
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class HowManyNumbersTest {
	
	
	@Test
	public void test27and3Scenario(){
		long[] expectedResult = {1,999,999};	
		List<Long> resultList = HowManyNumbers.findAll(27,3);	
		long[] actualresult = new long[3];
		
		for( int i = 0; i < resultList.size(); i++ ){
			actualresult[i] = resultList.get(i);
		}	
		Assert.assertArrayEquals(expectedResult,actualresult );
	}
	
	
	@Test
	public void test10and3Scenario(){
		long[] expectedResult = {8, 118, 334};
		List<Long> resultList = HowManyNumbers.findAll(10,3);	
		long[] actualresult = new long[3];
		
		
		for( int i = 0; i < resultList.size(); i++ ){
			actualresult[i] = resultList.get(i);
		}	
		Assert.assertArrayEquals(expectedResult,actualresult );		
	}
	
	@Test
	public void test32and7Scenario(){
		long[] expectedResult = {8, 118, 334};
		List<Long> resultList = HowManyNumbers.findAll(32,7);	
		long[] actualresult = new long[3];
		
		
		for( int i = 0; i < resultList.size(); i++ ){
			actualresult[i] = resultList.get(i);
		}	
		Assert.assertArrayEquals(expectedResult,actualresult );		
	}	
	
	@Test
	public void test28and8Scenario(){
		long[] expectedResult = {255, 11111599, 33334444};
		List<Long> resultList = HowManyNumbers.findAll(28,8);	
		long[] actualresult = new long[3];
		
		
		for( int i = 0; i < resultList.size(); i++ ){
			actualresult[i] = resultList.get(i);
		}	
		Assert.assertArrayEquals(expectedResult,actualresult );		
	}		
	
	@Test
	public void test10and4Scenario(){
		long[] expectedResult = {9, 1117, 2233};
		List<Long> resultList = HowManyNumbers.findAll(10,4);
		long[] actualresult = new long[3];
		
		for( int i = 0; i < resultList.size(); i++ ){
			actualresult[i] = resultList.get(i);
		}	
		Assert.assertArrayEquals(expectedResult,actualresult );			
		
	}	
	
	@Test
	public void test10and2Scenario(){
		long[] expectedResult = {5, 19, 55};
		List<Long> resultList = HowManyNumbers.findAll(10,2);
		long[] actualresult = new long[3];
		
		for( int i = 0; i < resultList.size(); i++ ){
			actualresult[i] = resultList.get(i);
		}	
		Assert.assertArrayEquals(expectedResult,actualresult );			
		
	}

	@Test
	public void test21and3Scenario(){
		long[] expectedResult = {7, 399, 777};
		List<Long> resultList = HowManyNumbers.findAll(21,3);
		long[] actualresult = new long[3];
		
		for( int i = 0; i < resultList.size(); i++ ){
			actualresult[i] = resultList.get(i);
		}	
		Assert.assertArrayEquals(expectedResult,actualresult );			
		
	}
	
	
	@Test
	public void test39and5Scenario(){
		long[] expectedResult = {10, 39999, 78888};
		List<Long> resultList = HowManyNumbers.findAll(39,5);
		long[] actualresult = new long[3];
		
		for( int i = 0; i < resultList.size(); i++ ){
			actualresult[i] = resultList.get(i);
		}	
		Assert.assertArrayEquals(expectedResult,actualresult );			
		
	}	
	
	@Test
	public void test34and2Scenario(){
		Object[] expectedResult = {};
		List<Long> resultList = HowManyNumbers.findAll(34,2);
		Object[] actualresult = resultList.toArray();
		
//		for( int i = 0; i < resultList.size(); i++ ){
//			actualresult[i] = resultList.get(i);
//		}	
		Assert.assertArrayEquals(expectedResult,actualresult );			
		
	}		
	

					
//	@Test
//	public void test36and6Scenario(){
//		long[] expectedResult = {123, 116999, 566666};
//		List<Long> resultList = HowManyNumbers.findAll(36,6);
//		long[] actualresult = new long[3];
//		
//		for( int i = 0; i < resultList.size(); i++ ){
//			actualresult[i] = resultList.get(i);
//		}	
//		Assert.assertArrayEquals(expectedResult,actualresult );			
//		
//	}	
}
