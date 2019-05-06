package com.utils.converter;

import com.utils.converter.exception.InvalidInputException;

public interface NumConverter {
   public abstract String convert(int num) throws InvalidInputException;
}
