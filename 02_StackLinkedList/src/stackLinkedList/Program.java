package stackLinkedList;
import edu.princeton.cs.algs4.StdOut;

public class Program {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(new String("test1"));
		stack.push(new String("test2"));
		stack.push(new String("test3"));
		stack.push(new String("test4"));
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		stack.push(new String("test3"));
		stack.push(new String("test4"));
		stack.push(new String("test5"));
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		stack.push(new String("test3"));
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		stack.push(new String("test3"));
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		stack.push(new String("test1"));
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
	}

}
