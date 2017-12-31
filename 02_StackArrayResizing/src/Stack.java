public class Stack {
	private String[] s;
	public int size;
	
	public Stack() {
		s = new String[1];
		size = 0;
	}
	
	public void push(String item) {
		s[size++]= item;
		if (size == s.length) {
			resize(s.length*2);
		}
	}
	
	public String pop() {
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
		String[] newS = new String[length];
		for (int i = 0; i < copyLength; i++) {
			newS[i] = s[i];
		}
		s = newS;
	}
}
