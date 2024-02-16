/*
 * Zhongtian Zhai
 * Email: zzhai4@u.rochester.edu
 * Assignment name: CustomStack
*/

class customStack1<E> {
	private Node<E> top;
	private int size;

	public customStack1() {
		top = null;
		size = 0;
	}

	public static class Bunny<T, U> {
		T name;
		U furColor;

		Bunny(T name, U color) {
			this.name = name;
			this.furColor = color;
		}

		public T getName() {
			return name;
		}

		public U getFurColor() {
			return furColor;
		}
	}

	private static class Node<E> {
		E data;
		Node<E> next;

		Node(E data) {
			this.data = data;
			this.next = null;
		}
	}

	public void push(E item) {
		Node<E> newNode = new Node<>(item);
		newNode.next = top;
		top = newNode;
		size++;
	}

	public E pop() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		E data = top.data;
		top = top.next;
		size--;
		return data;
	}

	public E peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack is empty");
		}
		return top.data;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}
}
public class CustomStack {
	public static void main(String[] args) {
		customStack1<customStack1.Bunny<String, String>> stack1 = new customStack1<>();
		stack1.push(new customStack1.Bunny<>("Garry", "brown"));
		stack1.push(new customStack1.Bunny<>("Bugs", "gray"));
		stack1.push(new customStack1.Bunny<>("Fluffy", "white"));
		
		System.out.println("Bunny Stack");
		while(!stack1.isEmpty())
		{
			customStack1.Bunny<String, String> bunny1=stack1.pop();
			System.out.println("A " + bunny1.getFurColor()+ 
					" bunny named "+bunny1.getName()+ " jumped out of a burrow.");
		}
	}
}