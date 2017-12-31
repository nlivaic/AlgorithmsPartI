public class Program {

	public static void main(String[] args) {
		test1();
	}
	private static void test1() {
		Queue<String> queue = new Queue<String>();
		queue.enqueue(new String("test1"));
		queue.enqueue(new String("test2"));
		queue.enqueue(new String("test3"));
		queue.enqueue(new String("test4"));
		queue.enqueue(new String("test5"));
		queue.enqueue(new String("test6"));
		queue.enqueue(new String("test7"));
		queue.enqueue(new String("test8"));
		queue.enqueue(new String("test9"));
		queue.enqueue(new String("test10"));
		queue.enqueue(new String("test11"));
		queue.enqueue(new String("test12"));
		queue.enqueue(new String("test13"));
		queue.enqueue(new String("test14"));
		queue.enqueue(new String("test15"));
		queue.enqueue(new String("test16"));
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
	}

	private static void test2() {
		Queue<String> queue = new Queue<String>();
		queue.enqueue(new String("test1"));
		queue.enqueue(new String("test2"));
		queue.enqueue(new String("test3"));
		queue.enqueue(new String("test4"));
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		queue.enqueue(new String("test3"));
		queue.enqueue(new String("test4"));
		queue.enqueue(new String("test5"));
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		queue.enqueue(new String("test3"));
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		queue.enqueue(new String("test3"));
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		queue.enqueue(new String("test1"));
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
		System.out.printf("%s, size: %d\n", queue.dequeue(), queue.size());
	}

	private static void test3() {
		Queue<String> queue = new Queue<String>();
		queue.enqueue(new String("test1"));
		queue.enqueue(new String("test2"));
		queue.enqueue(new String("test3"));
		queue.enqueue(new String("test4"));
		queue.enqueue(new String("test5"));
		queue.enqueue(new String("test6"));
		queue.enqueue(new String("test7"));
		queue.enqueue(new String("test8"));
		queue.enqueue(new String("test9"));
		queue.enqueue(new String("test10"));
		queue.enqueue(new String("test11"));
		queue.enqueue(new String("test12"));
		queue.enqueue(new String("test13"));
		queue.enqueue(new String("test14"));
		queue.enqueue(new String("test15"));
		queue.enqueue(new String("test16"));
		//for (String s : queue) {
		//	System.out.printf(s+"\n");	
		//}
	}
}
