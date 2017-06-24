package language.arith;

import language.Operand;

/**
 * An {@link IntegerOperand} is a wrapper around an integer.
 * @author jddevaug
 *
 */
public class IntegerOperand implements Operand<Integer> {

	private final Integer value;
	
	/**
	 * Constructs an {@link IntegerOperand} with the specified value
	 * @param value the value to store
	 */
	public IntegerOperand(int value){
		this.value = value;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer getValue() {
		return value;
	}

}
