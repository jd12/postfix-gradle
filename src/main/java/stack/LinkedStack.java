package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {
	
	private Node<T> top;
	private int size = 0;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T pop() throws StackUnderflowException {
		if(top == null)
			throw new StackUnderflowException();
		T temp = top.getData();
		top = top.getNext();
		size--;
		return temp;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T top() throws StackUnderflowException {
		if(top == null)
			throw new StackUnderflowException();
		return top.getData();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void push(T elem) {
		Node<T> newTop = new Node<T>(elem);
		newTop.setNext(top);
		top = newTop;
		size++;
	}

}
