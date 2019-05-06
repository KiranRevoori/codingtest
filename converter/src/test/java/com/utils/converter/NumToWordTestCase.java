package com.utils.converter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.utils.converter.exception.InvalidInputException;

public class NumToWordTestCase {

	private NumConverter numConverter;
	
	@Before
	public void setUp() throws Exception {
		numConverter=new NumToWordsConverter();
	}

	@Test(expected = InvalidInputException.class)
	public void testNagativeNum() throws InvalidInputException {
		assertEquals("one", numConverter.convert(-1));
	}
	
	@Test
	public void testConvertZeros() throws InvalidInputException {
		assertEquals("zero", numConverter.convert(000));
	}
		
	@Test
	public void testConvertOneDigitNum() throws InvalidInputException {
		assertEquals("one", numConverter.convert(1));
	}
	
	@Test
	public void testConvertTwoDigitNum() throws InvalidInputException {
		assertEquals("twenty one", numConverter.convert(21));
	}
	
	@Test
	public void testConvertThreeDigitNum() throws InvalidInputException {
		
		assertEquals("one hundred and five", numConverter.convert(105));
	}
	
	@Test
	public void testConvertEightDigitNum() throws InvalidInputException {
		
	assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one", numConverter.convert(56945781));
		
	}
	
}
