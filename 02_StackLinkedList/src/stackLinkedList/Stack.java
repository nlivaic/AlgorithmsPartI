package stackLinkedList;

public class Stack {
	class Node {
		String item;
		Node next;
	}
	private Node first;
	public int size;
	
	public Stack() {
		first = null;
		size = 0;
	}
	
	public void push(String item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		size++;
	}
	
	public String pop() {
		Node oldFirst = first;
		first = first.next;
		size--;
		return oldFirst.item;
	}
	
	public int size() {
		return size;
	}
}
