package io.seal.calculator;

/**
 * Calc used for MIN operation.
 */
public class MinCalc extends AbstractCalc {

    public MinCalc() {
        result = Integer.MAX_VALUE;
    }

    @Override
    public AbstractCalc addOperand(int operand) {
        result = Math.min(operand, result);
        return this;
    }

}
