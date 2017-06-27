package manuk.snake.snakegame;

import java.util.Iterator;

class LList<T> implements Iterable<T> {
	private Node head, tail;
	
	LList() {
		head = tail = new Node(null, null, null);
	}
	
	void add(T elem) {
		head = new Node(elem, head, null);
		head.prev.next = head;
	}
	
	void removeTail() {
		tail = tail.next;
		tail.prev = null;
	}
	
	public Iterator<T> iterator() {
		return new LListIterator();
	}
	
	private class Node {
		private T elem;
		private Node prev, next;
		
		private Node(T elem, Node prev, Node next) {
			this.elem = elem;
			this.prev = prev;
			this.next = next;
		}
	}
	
	private class LListIterator implements Iterator<T> {
		Node cur;
		
		LListIterator() {
			cur = tail;
		}
		
		public boolean hasNext() {
			return cur.next != null;
		}
		
		public T next() {
			cur = cur.next;
			return cur.elem;
		}
	}
}
