package language.arith;

import language.BinaryOperator;
import language.Operand;

/**
 * The {@link DivOperator} is an operator that performs division on two
 * integers.
 * @author jddevaug
 *
 */
public class DivOperator extends BinaryOperator<Integer> {

	@Override
	public Operand<Integer> performOperation() {
		Operand<Integer> op0 = this.getOp0();
		Operand<Integer> op1 = this.getOp1();
		if(op0 == null || op1 == null)
			throw new IllegalStateException("Could not perform operation prior to operands being set.");
		Integer result = op0.getValue() / op1.getValue();
		return new IntegerOperand(result);
	}


}
