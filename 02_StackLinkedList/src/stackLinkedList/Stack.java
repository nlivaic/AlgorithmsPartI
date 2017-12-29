package stackLinkedList;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	class Node {
		Item item;
		Node next;
	}
	private Node first;
	public int size;
	
	public Stack() {
		first = null;
		size = 0;
	}
	
	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		size++;
	}
	
	public Item pop() {
		Node oldFirst = first;
		first = first.next;
		size--;
		return oldFirst.item;
	}
	
	public int size() {
		return size;
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			/* not supported */
		}	
	}
}
