package language.arith;

import language.Operand;
import language.UnaryOperator;

/**
 * The {@code NegateOperator} is an operator that performs negation on a single integer
 * @author jddevaug
 *
 */
public class NegateOperator extends UnaryOperator<Integer> {

	@Override
	public Operand<Integer> performOperation() {
		Operand<Integer> op = getOperand();
		if(op == null)
			throw new IllegalStateException();
		return new IntegerOperand(-op.getValue());
	}


}
