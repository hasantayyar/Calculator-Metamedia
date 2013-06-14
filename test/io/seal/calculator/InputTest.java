package io.seal.calculator;

import junit.framework.TestCase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class InputTest extends TestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        File file = new File("sample.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        String separator = System.getProperty("line.separator");
        bufferedWriter.write(
                "SUM: 1, 2, 3" + separator +
                        "MIN: 4, 3, 2, 40" + separator +
                        "AVERAGE: 2, 2" + separator +
                        "SUM: 6" + separator +
                        "MIN: 2" + separator +
                        "AVERAGE: 2" + separator +
                        "AVERAGE: 2, 4, 1 " + separator +
                        "AVERAGE: 3, 3, 3" + separator +
                        "MAX: 153 2499" + separator +
                        "     " + separator +
                        "   sasakfjaksf  " + separator +
                        "   MAX  " + separator +
                        "     MIN" + separator +
                        "  S U M  " + separator
        );

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        File file = new File("sample.txt");
        file.delete();
    }

    public void testCalculator() {
        String[] args = new String[1];
        args[0] = "sample.txt";
        Calculator.main(args);
    }

    public void testNonExistingFile() {
        String[] args = new String[1];
        args[0] = "sample2.txt";
        Calculator.main(args);
    }

    public void testNoArguments() {
        String[] args = new String[0];
        Calculator.main(args);
    }

    public void testEmptyArguments() {
        String[] args = new String[0];
        Calculator.main(args);
    }

    public void testNullArguments() {
        String[] args = null;
        Calculator.main(args);
    }

    public void testUnnecessaryArguments() {
        String[] args = new String[3];
        args[0] = "sample1.txt";
        args[1] = "sample2.txt";
        args[2] = "sample3.txt";
        Calculator.main(args);
    }

}
