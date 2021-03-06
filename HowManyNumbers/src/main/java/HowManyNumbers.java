import java.util.ArrayList;
import java.util.List;

public class HowManyNumbers {
	
	public static List<Long> findAll(int sumDesired, int numDigits) {
		
		long startTime = System.currentTimeMillis();
		System.out.println("Program start, startime = " + startTime);
		System.out.println("Program start, sumDesired = " + sumDesired);
		System.out.println("Program start, numDigits = " + numDigits);

		StringBuffer strTopNumberToIterateTo = new StringBuffer();
		StringBuffer strNumberToIterateFrom = new StringBuffer();
		for (int i =0; i<numDigits;i++) {
			strTopNumberToIterateTo.append(9);
			if(i==0) {
				strNumberToIterateFrom.append(1);	
			}
			if (i>0) {
				strNumberToIterateFrom.append(0);	
			}		
		}
		
		System.out.println("the string representation of the max number we will iterate too is = " + strTopNumberToIterateTo.toString());
		System.out.println("the string representation of the number we will iterate from is = " + strNumberToIterateFrom.toString());
		
		long topNumberToIterateTo = Long.parseLong(strTopNumberToIterateTo.toString());
		long numberToIterateFrom = Long.parseLong(strNumberToIterateFrom.toString());
		
		long countOfQualifyingNumbers = 0;
		long minQuantifyingNumber = 0;
		long maxQuantifyingNumber = 0;
		
		char[] numberCharArray = new char[numDigits];
		
		List<Long> qualifyingNumbersList = new ArrayList<Long>();
		

		
		long i = numberToIterateFrom;
		long counter = 0;	
		numberEval:
		while (i<=topNumberToIterateTo) {
			counter++;
//			System.out.println("examining this number = " + i);		
			//analyze the current number
			//get the integer into a array of char for each digit
			numberCharArray = getDigits(i);
			int sumOfDigits = 0;
			
			for (int j = 0;j< numDigits;j++){
							
				if(j>0) {//if we on the second or third digit
					int currentDigit = Integer.parseInt(Character.toString(numberCharArray[j]));
					int previousDigit = Integer.parseInt(Character.toString(numberCharArray[j-1]));
					
//					System.out.println("we are on the " + j + " digit of the analyzed number ("+i+"), current digit is " + currentDigit + " and the previous digit is " + previousDigit );
						
					if (currentDigit < previousDigit ) {
//						System.out.println("Since this number ("+i+") is not ascending in order, we need to break out of this number's analysis - it in invalid");
						
						
						
						//set the next number we will jump to
						StringBuffer remainingDigitsToBumpUp = new StringBuffer();
						for (int k=0;k<numDigits-j;k++) {
							remainingDigitsToBumpUp.append(previousDigit);
						}
						
						String strCurrentNumber = Long.toString(i);
						String strBeginningOfCurrentNumber = strCurrentNumber.substring(0, j);
						
						StringBuffer strNextNumberToAnalyze = new StringBuffer();
						strNextNumberToAnalyze.append(strBeginningOfCurrentNumber);
						strNextNumberToAnalyze.append(remainingDigitsToBumpUp);
						
						i=Long.parseLong(strNextNumberToAnalyze.toString());
//						System.out.println("Let's also bump current number up to something that will not be descending, like " + i);
						
						
						continue numberEval;
					}
					
				}

//				System.out.println("as we examining this number = " + i);
				sumOfDigits = sumOfDigits + Integer.parseInt(Character.toString(numberCharArray[j]));
//				System.out.println("We have the current running total of this number's digits = " + sumOfDigits);				
				if (j==(numDigits-1)) {
//					System.out.println("We have just finished summing all the digits, and we have = " + sumOfDigits + ", and the sumDesired is = " + sumDesired);
					if (sumOfDigits == sumDesired) {
//						System.out.println("a qualifying number is = " + i);
						countOfQualifyingNumbers++;
						qualifyingNumbersList.add(i);
						if (minQuantifyingNumber==0) {
							minQuantifyingNumber = i;
						}						
						maxQuantifyingNumber = i;						
					}
				}				
			}			
			i++;
		}

		List<Long> result = new ArrayList<Long>();
		
		if (countOfQualifyingNumbers!=0) {
			result.add(countOfQualifyingNumbers);
			result.add(minQuantifyingNumber);
			result.add(maxQuantifyingNumber);
		}
			
		System.out.println("The list of qualifying numbers is = " +qualifyingNumbersList.toString() );
		
		
		long endTime   = System.currentTimeMillis();
		System.out.println("Program start, endtime = " + endTime);
		long totalTime = endTime - startTime;
		System.out.println("Program start, elapsed time = " + totalTime);
		
		System.out.println("we made " + counter + " iterations");
		if (!result.isEmpty()) {
			System.out.println("the returned result is " + result.get(0) + ", " + result.get(1) + ", " + result.get(2));	
		}
		
		System.out.println("starting at number = " + numberToIterateFrom + ", going to number = " + topNumberToIterateTo);
		
		return result;
	}
	
	private static char[] getDigits(long number) {
		
		String strNumber = String.valueOf(number);
		
		char[] digits1 = strNumber.toCharArray();
		
		
		return digits1;
	}

}
