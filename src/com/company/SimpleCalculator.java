package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

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
    public List<Integer> calculate(List<String> instructions) {
        List<Integer> results = new ArrayList<>();
        int currentValue = 0;
        for (String instruction : instructions) {
            String[] splitExpression = instruction.split("\\s+");
            int valueFromInstruction = Integer.parseInt(splitExpression[1]);
            String operation = splitExpression[0];
            if(DISPLAY_COMMAND.equals(operation)){
                results.add(currentValue);
                currentValue = 0;
            }

            if(DISPLAY_COMMAND.equals(operation)){
                //handle case with zero
            }

            currentValue = commandToOperation.get(operation).apply(currentValue, valueFromInstruction);
        }

        return results;
    }
}
