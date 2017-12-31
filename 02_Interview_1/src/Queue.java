/********************************************************************************
* Queue with two stacks. Implement a queue with two stacks so that each queue 
* operations takes a constant amortized number of stack operations.
********************************************************************************/
public class Queue<Item> {	
	private Stack<Item> inStack, outStack;
	
	public Queue() {
		inStack = new Stack<Item>();
		outStack = new Stack<Item>();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void enqueue(Item item) {
		inStack.push(item);
	}
	
	public Item dequeue() {
		if (outStack.size() == 0) {
			while (inStack.size() > 0) {
				outStack.push(inStack.pop());
			}
		}
		return outStack.pop();
	}
	
	public int size() {
		return inStack.size() + outStack.size();
	}
}
