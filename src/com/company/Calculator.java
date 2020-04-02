package com.company;

import java.util.List;

/**
 * General interface for calculator
 */
public interface Calculator {

    /**
     * Evaluate instruction to list of outputs.
     * @return list of outputs
     */
    List<Integer> calculate(List<String> instructions);
}
