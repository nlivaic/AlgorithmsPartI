import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
	private Item[] s;
	public int size;
	
	public Stack() {
		s = (Item[])new Object[1];
		size = 0;
	}
	
	public void push(Item item) {
		s[size++]= item;
		if (size == s.length) {
			resize(s.length*2);
		}
	}
	
	public Item pop() {
		size--;
		if (size == s.length/4) {
			resize(s.length/2);
		}
		return s[size];
	}
	
	public int size() {
		return size;
	}
	
	public void resize(int length) {
		int copyLength = Math.min(s.length, length);
		Item[] newS = (Item[])new Object[length];
		for (int i = 0; i < copyLength; i++) {
			newS[i] = s[i];
		}
		s = newS;
	}

	@Override
	public StackIterator iterator() {
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<Item> {
		private int index = 0;
		
		@Override
		public boolean hasNext() {
			return index < size();
		}

		@Override
		public Item next() {
			return s[index++];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
		}
	}
}
