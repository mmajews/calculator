package com.company;

import com.company.exceptions.DivideByZeroException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Implementation of {@link Calculator} supporting following operations:
 * ADD
 * MULTIPLY
 * DIVIDE
 * SUBTRACT
 * DISPLAY
 */
public class SimpleCalculator implements Calculator {
    private static final String DISPLAY_COMMAND = "DISPLAY";
    public static final String DIVIDE_COMMAND = "DIVIDE";

    private Map<String, BiFunction<Integer, Integer, Integer>> commandToOperation;

    public SimpleCalculator() {
        this.commandToOperation = new HashMap<>();
        commandToOperation.put("ADD", Integer::sum);
        commandToOperation.put("MULTIPLY", (integer, integer2) -> integer * integer2);
        commandToOperation.put("SUBTRACT", (integer, integer2) -> integer - integer2);
        commandToOperation.put(DIVIDE_COMMAND, (integer, integer2) -> integer / integer2);
    }

    @Override
    public List<Integer> calculate(List<String> instructions) throws DivideByZeroException {
        List<Integer> results = new ArrayList<>();
        int currentValue = 0;
        for (String instruction : instructions) {
            if (DISPLAY_COMMAND.equals(instruction)) {
                results.add(currentValue);
                continue;
            }

            String[] splitExpression = instruction.split("\\s+");
            String operation = splitExpression[0];
            int valueFromInstruction = Integer.parseInt(splitExpression[1]);

            if (DIVIDE_COMMAND.equals(operation) && valueFromInstruction == 0) {
                throw new DivideByZeroException("User tried to divided by 0, expr: " + instruction);
            }

            currentValue = commandToOperation.get(operation).apply(currentValue, valueFromInstruction);
        }

        return results;
    }
}
