package language;

/**
 * An {@code Operand} is a wrapper around a value.
 * @author jddevaug
 *
 * @param <T> the type of the stored data
 */
public interface Operand<T> {

	/**
	 * Returns the concrete value stored in this {@link Operand}
	 * @return the concrete value stored in this {@link Operand}
	 */
	public T getValue();
	
}
