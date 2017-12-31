public class Queue<Item> {
	class Node {
		Item item;
		Node next;
	}
	private Node first, last;
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void enqueue(Item item) {
		Node newLast = new Node();
		newLast.item = item;
		last.next = newLast;
		last = newLast;
		if (isEmpty()) {
			first = last;
		}
	}
	
	public Item dequeue() {
		Node oldFirst = first;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		return oldFirst.item;	
	}
}
