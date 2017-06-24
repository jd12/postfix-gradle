package language;

/**
 * A {@code BinaryOperator} is an {@code Operator} that performs an
 * operation on two arguments.
 * @author jddevaug
 *
 * @param <T>
 */
public abstract class UnaryOperator<T> implements Operator<T> {

	private Operand<T> operand;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int getNumberOfArguments() {
		return 1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setOperand(int i, Operand<T> operand) {
		if(operand == null)
			throw new NullPointerException("Could not set null operand.");
		if(i > 0)
			throw new IllegalArgumentException("Unary operator only accepts 0 but was given " + i + ".");
		if(this.operand != null)
				throw new IllegalStateException("Position " + i + " has been previously set.");
			this.operand = operand;
	}

	/**
	 * Returns the operand
	 * @return the operand
	 */
	public Operand<T> getOperand() {
		return operand;
	}

}
