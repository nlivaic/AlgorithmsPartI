import edu.princeton.cs.algs4.StdOut;

public class Program {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(new String("test1"));
		stack.push(new String("test2"));
		stack.push(new String("test3"));
		stack.push(new String("test4"));
		stack.push(new String("test5"));
		stack.push(new String("test6"));
		stack.push(new String("test7"));
		stack.push(new String("test8"));
		stack.push(new String("test9"));
		stack.push(new String("test10"));
		stack.push(new String("test11"));
		stack.push(new String("test12"));
		stack.push(new String("test13"));
		stack.push(new String("test14"));
		stack.push(new String("test15"));
		stack.push(new String("test16"));
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());		// First cut.
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());		// Second cut.
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());		// Third cut.
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());		// Fourth cut.
		StdOut.printf("%s, size: %d\n", stack.pop(), stack.size());		// Last pop.
		
	}

}
