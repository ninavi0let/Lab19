package dsa;

import java.util.LinkedList;

public class MainApp {

	public static void main(String[] args) {
		MyArrayList list = new MyArrayList();
		
		list.addAtBeginning("hello");
		list.addAtBeginning("hello1");
		list.addAtBeginning("hello3");
		list.addAtBeginning("hello4");
		list.removeAt(2);
		System.out.println(list);
		list.insertAt(2, "monkey in the middle");
		
		
		System.out.println(list);
//		System.out.println(list.get(10));
		
		System.out.println("\nLinkedList starts here: ");
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.addAtBeginning("help1");
		linkedList.addAtBeginning("help2");
		linkedList.addAtBeginning("help3");
		linkedList.removeAt(1);
		System.out.println(linkedList);
//		
//		linkedList.removeFromBeginning();
//		System.out.println(linkedList);
		
		//linkedList.addAtEnd("End");
//		System.out.println(linkedList);
	}

}
