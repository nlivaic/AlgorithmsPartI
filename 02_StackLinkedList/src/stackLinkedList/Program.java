package stackLinkedList;

public class Program {

	public static void main(String[] args) {
		test3();
	}
	private static void test1() {
		Stack<String> stack = new Stack<String>();
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
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());		// First cut.
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());		// Second cut.
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());		// Third cut.
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());		// Fourth cut.
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());		// Last pop.
	}

	private static void test2() {
		Stack<String> stack = new Stack<String>();
		stack.push(new String("test1"));
		stack.push(new String("test2"));
		stack.push(new String("test3"));
		stack.push(new String("test4"));
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		stack.push(new String("test3"));
		stack.push(new String("test4"));
		stack.push(new String("test5"));
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		stack.push(new String("test3"));
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		stack.push(new String("test3"));
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		stack.push(new String("test1"));
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
		System.out.printf("%s, size: %d\n", stack.pop(), stack.size());
	}

	private static void test3() {
		Stack<String> stack = new Stack<String>();
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
		for (String s : stack) {
			System.out.printf(s+"\n");	
		}
	}
}
