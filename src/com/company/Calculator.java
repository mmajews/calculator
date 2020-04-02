package com.company;

import com.company.exceptions.DivideByZeroException;

import java.util.List;

/**
 * General interface for calculator
 */
public interface Calculator {

    /**
     * Evaluate instruction to list of outputs.
     * @return {@link List} of outputs being {@link Integer}
     * @throws DivideByZeroException when user tries to divided by zero
     */
    List<Integer> calculate(List<String> instructions) throws DivideByZeroException;
}
