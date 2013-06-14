package io.seal.calculator;

/**
 * Calc used for SUM operation.
 */
public class SumCalc extends AbstractCalc {

    @Override
    public AbstractCalc addOperand(int operand) {
        result += operand;
        return this;
    }

}
