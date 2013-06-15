package io.seal.calculator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Calculator, which is able to perform operations SUM, MIN, MAX and AVERAGE with given operands.
 * Input data are read from file given in first argument. Each operation takes one line.
 */
public class Calculator {

    public static void main(String[] args) {
        if (args == null || args.length != 1) {
            printMessage("file not entered");
            printUsage();
            return;
        }
        String fileName = args[0];
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // empty line, proceed next lines
                int colonIndex = line.indexOf(":");
                if (colonIndex == -1) {
                    printMessageOnLine("wrong operation format", line);
                    continue; // proceed next lines
                }
                Operation operation;
                try {
                    operation = Operation.valueOf(line.substring(0, colonIndex).trim());
                } catch (IllegalArgumentException e) {
                    printMessage("unknown operation");
                    continue; // proceed next lines
                }
                String[] numbers = line.substring(colonIndex + 1).split(",");
                if (numbers.length == 0) {
                    printMessageOnLine("no operands", line);
                    continue; // proceed next lines
                }
                AbstractCalc calc;
                switch (operation) {
                    case SUM:
                        calc = new SumCalc();
                        break;
                    case MIN:
                        calc = new MinCalc();
                        break;
                    case MAX:
                        calc = new MaxCalc();
                        break;
                    case AVERAGE:
                        calc = new AverageCalc();
                        break;
                    default:
                        throw new IllegalArgumentException("unknown operation");
                }
                boolean malformed = false;
                for (int i = 0; i < numbers.length; i++) {
                    String number = numbers[i].trim();
                    try {
                        calc.addOperand(Integer.parseInt(number));
                    } catch (NumberFormatException e) {
                        printMessageOnLine("malformed number", line);
                        malformed = true;
                        break;
                    }
                }
                if (malformed) continue; // proceed next lines
                println(line + " = " + calc.getResult());
            }
        } catch (FileNotFoundException e) {
            printMessage("file not found");
            printUsage();
        } catch (IOException e) {
            printMessage("file reading failed");
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printMessageOnLine(String message, String line) {
        println(message + " (" + line + ")");
    }

    private static void printMessage(String message) {
        println("Message: " + message);
    }

    private static void printUsage() {
        println("Usage: calc [file]");
        println("");
        println("File example:");
        println("SUM: 1, 2, 3");
        println("MIN: 4, 3, 2, 40");
        println("AVERAGE: 2, 2");
        println("SUM: 6");
        println("MIN: 2");
        println("AVERAGE: 2");
    }

    private static void println(String line) {
        System.out.println(line);
    }

}
