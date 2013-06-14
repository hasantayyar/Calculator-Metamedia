package io.seal.calculator;

/**
 * Calc used for MAX operation.
 */
public class MaxCalc extends AbstractCalc {

    public MaxCalc() {
        result = Integer.MIN_VALUE;
    }

    @Override
    public AbstractCalc addOperand(int operand) {
        result = Math.max(operand, result);
        return this;
    }

}
