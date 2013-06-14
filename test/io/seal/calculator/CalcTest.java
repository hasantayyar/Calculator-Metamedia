package io.seal.calculator;

import junit.framework.TestCase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class CalcTest extends TestCase {

    public void testSumCalc() {
        AbstractCalc calc = new SumCalc();
        assertEquals(calc.addOperand(1).getResult(), 1);
        assertEquals(calc.addOperand(2).getResult(), 3);
        assertEquals(calc.addOperand(11111).getResult(), 11114);
        assertEquals(calc.addOperand(150).getResult(), 11264);
        assertEquals(calc.addOperand(3).getResult(), 11267);
        assertEquals(calc.addOperand(1).getResult(), 11268);
        assertEquals(calc.addOperand(1001).getResult(), 12269);
        assertEquals(calc.addOperand(4).getResult(), 12273);
    }

    public void testMinCalc() {
        AbstractCalc calc = new MinCalc();
        assertEquals(calc.addOperand(10).getResult(), 10);
        assertEquals(calc.addOperand(22).getResult(), 10);
        assertEquals(calc.addOperand(-134).getResult(), -134);
        assertEquals(calc.addOperand(-17).getResult(), -134);
        assertEquals(calc.addOperand(-1).getResult(), -134);
        assertEquals(calc.addOperand(-14030).getResult(), -14030);
        assertEquals(calc.addOperand(15392).getResult(), -14030);
        assertEquals(calc.addOperand(0).getResult(), -14030);
    }

    public void testMaxCalc() {
        AbstractCalc calc = new MaxCalc();
        assertEquals(calc.addOperand(10).getResult(), 10);
        assertEquals(calc.addOperand(22).getResult(), 22);
        assertEquals(calc.addOperand(-134).getResult(), 22);
        assertEquals(calc.addOperand(-17).getResult(), 22);
        assertEquals(calc.addOperand(-1).getResult(), 22);
        assertEquals(calc.addOperand(-14030).getResult(), 22);
        assertEquals(calc.addOperand(15392).getResult(), 15392);
        assertEquals(calc.addOperand(0).getResult(), 15392);
    }

    public void testAverageCalc() {
        AbstractCalc calc = new AverageCalc();
        assertEquals(calc.addOperand(10).getResult(), 10);
        assertEquals(calc.addOperand(22).getResult(), 16);
        assertEquals(calc.addOperand(-134).getResult(), -34);
        assertEquals(calc.addOperand(-17).getResult(), -30);
        assertEquals(calc.addOperand(-1).getResult(), -24);
        assertEquals(calc.addOperand(-14030).getResult(), -2358);
        assertEquals(calc.addOperand(15392).getResult(), 177);
        assertEquals(calc.addOperand(0).getResult(), 155);
    }

}
