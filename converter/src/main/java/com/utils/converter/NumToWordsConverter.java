package com.utils.converter;

import org.apache.log4j.Logger;

import com.utils.converter.exception.InvalidInputException;

public class NumToWordsConverter implements NumConverter {
	final static Logger logger = Logger.getLogger(NumToWordsConverter.class);
	// variable to hold string representation of number 
	private static String[] lowNames= {"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	private static String[] tenNames= {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
	private static String[] bigNames= {"hundred","thousand","million"};
	private static int ONE_HUNDRED=100;
	private static int ONE_THOUSAND=1000;
	private static int TEN=10;
	private static int TWENTY=20;
	private static int TWO =2;
	private static String SPACE=" ";
	private static String AND=" and ";
	private static int TWO_DIGIT_MAX_VALUE=99;
	private static int THREE_DIGIT_MAX_VALUE=999;
	private static int ZERO=0;
	
	 /*
	 * convert the number entered in digits to its word representation
	 */
 	public String convert(int num) throws InvalidInputException {
 		//Validate input number
		validateInput(num);
		
		//check if number is less than or equals to 999
		if(num <= THREE_DIGIT_MAX_VALUE) {
			return convert999(num);
		}
		
		//store the result
		StringBuilder str=new StringBuilder("");
		
		int t=0;
		
		//  Iterate while num is not zero
		while(num > ZERO) {
			
			// check if number is divisible by 1 thousand
			if(num % ONE_THOUSAND != ZERO) {
				StringBuilder temp = new StringBuilder("");
				temp.append(convert999(num % ONE_THOUSAND));
				
				//execute below block if number is >=1000
				if(t>0) {
					temp.append(SPACE+bigNames[t]);
				}
				
				if(str.length()==0) {
					str=temp;
				}else {
					temp.append(SPACE+str);
					str=temp;
				}
			}
			
		num/= ONE_THOUSAND;
		t++;
		
		}
		
		return str.toString();
	}
	
 	 /*
     * It will convert the number which is in the range from  0 to 999 into words,
     * 
     */
    private String convert999(int num) {
    	//return a number which is in 100th position
    	StringBuilder str1= new StringBuilder(lowNames[num / ONE_HUNDRED]);
    	str1.append(SPACE);
    	str1.append(bigNames[0]);
    	str1.append(AND);
    	
    	StringBuilder str2=new StringBuilder(convert99(num % ONE_HUNDRED));
    	
		if(num <= TWO_DIGIT_MAX_VALUE) {//check if number is lessthan or equal 99
			return str2.toString();
		}else if(num % ONE_HUNDRED == ZERO) { //check if number is divisible by 100 and remainder is zero
			return str1.toString();
		}
		
		return str1.append(str2).toString();
		
	}
    
    
    /*
     * It will convert the number which is in the range from  0 to 99 into words,
     * 
     */
	private String convert99(int num) {
		
		//check if number is within 20
		if(num<TWENTY) {
			return lowNames[num];
		}
		
		// fetch the appropriate value from tenNames array
		StringBuilder str=new StringBuilder(tenNames[num / TEN - TWO]);
		
		//check if number is divisible by 10 and remainder is zero
		if(num % TEN == ZERO) {
			return str.toString();
		}
		
		//number is neither below 20 nor divisible by 10 and remainder is zero
		str.append(SPACE);
		return str.append(lowNames[num % TEN]).toString();
	}
	
	public void validateInput(int num) throws InvalidInputException {
				
		if(num < ZERO) {
			throw new InvalidInputException("Input is less than zero");
		}
	}

}
