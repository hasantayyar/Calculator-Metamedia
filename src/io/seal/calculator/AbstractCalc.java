package io.seal.calculator;

/**
 * Abstract calculator which adds operands and calculates results immediately.
 */
public abstract class AbstractCalc {

    protected int result;

    public abstract AbstractCalc addOperand(int operand);

    public int getResult() {
        return result;
    }
}
