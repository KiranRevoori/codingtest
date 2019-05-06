package com.utils.converter;
import org.apache.log4j.Logger;
public class NumConverterClient  {
	final static Logger logger = Logger.getLogger(NumConverterClient.class);
	public static void main(String[] args) {
		NumConverter converter=new NumToWordsConverter();
		try {
			logger.info("1->"+converter.convert(1));
			logger.info("21->"+converter.convert(21));
			logger.info("105->"+converter.convert(105));
			logger.info("56945781->"+converter.convert(56945781));
		}catch(Exception e) {
			logger.error(e);
		}

	}

}
