// LinkedNumberSequence.java

/****************************************************************

LinkedNumberSequence represents a sequence of real numbers.
Such a sequence is defined by the interface NumberSequence.
The class uses linked nodes to store the numbers in the sequence.

Author
Fadil Galjic

****************************************************************/

public class LinkedNumberSequence implements NumberSequence
{
	private class Node
	{
		public double number;
		public Node next;

		public Node (double number)
		{
			this.number = number;
			next = null;
		}
	}

	// the first node in the node-sequence
    private Node first;

    // create the sequence
    public LinkedNumberSequence (double[] numbers)
    {
		if (numbers.length < 2)
		    throw new IllegalArgumentException("not a sequence");

        first = new Node(numbers[0]);
        Node n = first;
		for (int i = 1; i < numbers.length; i++)
		{
			n.next = new Node(numbers[i]);
			n = n.next;
		}
	}

    // toString returns the character string representing this
    // sequence
	public String toString ()
	{
		String s = "";
		Node n = first;
		while (n.next != null)
		{
		    s = s + n.number + ", ";
		    n = n.next;
		}
		s = s + n.number;

		return s;
	}

	/* ================================================ STUDENT CODE ================================================ */

    public int length ()  {
		int i = 1;
		Node node = first;
		while (node.next != null) {
			i++;
			node = node.next;
		}
		return i;
	}

	public double upperBound() {
		double number = first.number;
		Node node = first;
		while (node.next != null) {
			node = node.next;
			if (node.number >= number) {
				number = node.number;
			}
		}
		return number;
	}

	public double lowerBound() {
		double number = first.number;
		Node node = first;
		while (node.next != null) {
			node = node.next;
			if (node.number <= number) {
				number = node.number;
			}
		}
		return number;
	}

	public double numberAt(int position) throws IndexOutOfBoundsException {
		if (position - 0 > length()) {
			throw new IndexOutOfBoundsException();
		}
		Node node = first;
		for (int i = 0; i < position; i++) {
			node = node.next;
		}
		return node.number;
	}

	public int positionOf(double number) {
		Node node = first;
		for (int i = 1; i < length(); i++) {
			node = node.next;
			if (node.number == number) {
				return i;
			}
		}
		return -1;
	}

	public boolean isIncreasing() {
		Node currentNode = first;
		Node nextNode = first.next;

		for (int i = 1; i < length(); i++) {
			if (currentNode.number >= nextNode.number) {
				return false;
			}
			currentNode = currentNode.next;
			nextNode = currentNode.next;
		}

		return true;
	}

	public boolean isDecreasing() {
		return !isIncreasing();
	}

	public boolean contains(double number) {
		Node node = first;
		while (node.next != null) {
			node = node.next;
			if (node.number == number) {
				return true;
			}
		}
		return false;
	}

	public void add(double number) {
		Node node = first;
		while (node.next != null) {
			node = node.next;
		}
		node.next = new Node(number);
	}

	public void insert(int position, double number) throws IndexOutOfBoundsException {
		if (position - 0 > length()) {
			throw new IndexOutOfBoundsException();
		}

		Node node = first;

		for (int i = 1; i < position; i++) {
			node = node.next;
		}

		Node insertedNode = new Node(number);
		insertedNode.next = node.next;
		node.next = insertedNode;

	}

	public void removeAt(int position) throws IndexOutOfBoundsException, IllegalStateException {
		if (position - 0 > length()) {
			throw new IndexOutOfBoundsException();
		}
		if (length() < 2) {
			throw new IllegalStateException();
		}

		Node node = first;

		for (int i = 1; i < position; i++) {
			node = node.next;
		}

		node.next = node.next.next;

	}

	public double[] asArray() {
		double[] array = new double[length()];
		Node node = first;
		for (int i = 0; i < length(); i++) {
			array[i] = node.number;
			node = node.next;
		}
		return array;
	}

	/* ================================================ END STUDENT CODE ================================================ */

}