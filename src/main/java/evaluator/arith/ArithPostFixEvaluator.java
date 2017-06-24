package evaluator.arith;

//import static org.junit.Assert.assertEquals;
import language.Operand;
import language.Operator;
import parser.arith.ArithPostFixParser;
import stack.LinkedStack;
import stack.StackInterface;
import evaluator.IllegalPostFixExpressionException;
import evaluator.PostFixEvaluator;

/**
 * An {@link ArithPostFixEvaluator} is a post fix evaluator over simple arithmetic expressions.
 *
 */
public class ArithPostFixEvaluator implements PostFixEvaluator<Integer> {

	private final StackInterface<Operand<Integer>> stack;
	
	/**
	 * Constructs an {@link ArithPostFixEvaluator}
	 */
	public ArithPostFixEvaluator(){
		this.stack = new LinkedStack<Operand<Integer>>(); //TODO Initialize to your LinkedStack
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer evaluate(String expr) {
		ArithPostFixParser parser = new ArithPostFixParser(expr);
		while(parser.hasNext()){
			switch(parser.nextType()){ 
			case OPERAND:
				Operand<Integer> operand = parser.nextOperand();
				stack.push(operand);
				break;
			case OPERATOR:
				Operator<Integer> operator = parser.nextOperator();
				if(operator.getNumberOfArguments() == 1){
					doOneArgument(operator);
				}else{
					doTwoArguments(operator);
				}
				break;
			}
		}		
		if(stack.size() != 1)
			throw new IllegalPostFixExpressionException();
		return stack.pop().getValue();
	}
	
	private final void doTwoArguments(Operator<Integer> operator){
		if(stack.size() < 2)
			throw new IllegalPostFixExpressionException();
		Operand<Integer> op1 = stack.pop();
		Operand<Integer> op0 = stack.pop();
		operator.setOperand(0, op0);
		operator.setOperand(1, op1);
		Operand<Integer> result = operator.performOperation();
		stack.push(result);		
	}
	
	private final void doOneArgument(Operator<Integer> operator){
		if(stack.size() < 1)
			throw new IllegalPostFixExpressionException();
		Operand<Integer> op = stack.pop();
		operator.setOperand(0, op);
		Operand<Integer> result = operator.performOperation();
		stack.push(result);
	}
	
//	public static void main(String ... args){
//		PostFixEvaluator<Integer> evaluator = new ArithPostFixEvaluator();
//		Integer result = evaluator.evaluate("1 !");
//		assertEquals(new Integer(-1), result);
//		
//		result = evaluator.evaluate("2 !");
//		assertEquals(new Integer(-2), result);
//		
//		result = evaluator.evaluate("-15 !");
//		assertEquals(new Integer(15), result);		
//	}

}
