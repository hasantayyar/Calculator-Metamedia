package io.seal.calculator;

/**
 * Calc used for AVERAGE operation.
 */
public class AverageCalc extends AbstractCalc {

    private int mCount = 0;
    private float mOldAverage; // old average in float is needed to be more accurate

    @Override
    public AbstractCalc addOperand(int operand) {
        result = average(operand);
        mCount++;
        return this;
    }

    private int average(int x) {
        mOldAverage = ((mOldAverage * mCount) + x) / (mCount + 1f);
        return Math.round(mOldAverage); // round to integer
    }

}
