package dsa;

public class MyLinkedList implements MyList {
	
	private Node head;
	//private Node tail;
	private int myLength = 0;
	
	// created a helper method to get the node at a certain location
		// to help us prevent some code duplication
		private Node getNodeAt(int index) {
			Node node = head;
			for (int i = 0; i < index; i++) {
				if (node == null) {
					return null;
				}
				node = node.getNext();
			}
			return node;
		}

	@Override
	public void addAtBeginning(String data) {
		// add a new Node and set it to the head
		head = new Node(head, data);
	
		myLength++;
	}

	@Override
	public void removeFromBeginning() {
		head = head.getNext();
		myLength--;

	}

	@Override
	public void addAtEnd(String data) {
		// check to make sure the list is not empty!
		// if empty add to the beginning (hint: we have some code for that!)
		
		// otherwise - create logic to add to the end (tail)
		// the reference to the next node should be null
		// increase the length
		
		// create a new node
		Node newNode = new Node(null, data);
		// get the last node in the linkedList
		getNodeAt(myLength-1).setNext(newNode);
		
//		tail = new Node(tail, data);
//		if (myLength != 0) {
//		myLength.getNodeAt(tail);
//		} else {
//			addAtBeginning(data);
//		}
	}

	@Override
	public void removeFromEnd() {
		// set the second to last node to null
		// set index[1] set to null
		getNodeAt(myLength-2).setNext(null);

	}

	@Override
	public String get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		
		return myLength;
	}
	

	@Override
	public boolean removeAt(int index) {
		if (index >= myLength) {
			return true;
		}
//		Node nextNode = getNodeAt(index+1);
		// set node at specified index to null
		getNodeAt(index).setNext(null);
		// set the previous node to the node after node that was just set to null
		getNodeAt(index).setNext(getNodeAt(index+1));
		return false;
	}

	@Override
	public boolean insertAt(int index, String item) {
		
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[ ");
		Node node = head;
		// follow the links between the nodes until it reaches the end
		while(node != null) {
			sb.append(node);
			node = node.getNext();
		}
		sb.append(" ]");
		
		return sb.toString(); // replace later
	}
}
