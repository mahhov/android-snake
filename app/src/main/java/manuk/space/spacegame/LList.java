package manuk.space.spacegame;

class LList<T> {
	Node<T> head, tail;

	class Node<T> {
		Node prev, next;
		T elem;
	}
}
