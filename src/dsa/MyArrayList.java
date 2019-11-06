package dsa;

import java.util.Arrays;

public class MyArrayList implements MyList {
	
	private String[] arr = new String[4];
	private int myLength = 0;
	
	// we will use this method as a helper method inside this class
	private boolean isFull() {
		return arr.length == myLength;
	}
	
	// we will use this as a helper method as well to dynamically increase the
	// size of the array
	private void doubleLength() {
		// make a copy of the array that is twice as long
		arr = Arrays.copyOf(arr, arr.length *2);
	}
	
	

	@Override
	public void addAtBeginning(String data) {
		if (isFull()) {
			doubleLength();
		}
		
		// loop backwards and shift all the items over to make room for the new data
		for (int i = myLength; i>0; i--) {
			arr[i] = arr[i - 1]; // this is assigning the element was before it to the new index
		}
		
		arr[0] = data;
		myLength++;

	}

	@Override
	public void removeFromBeginning() {
		if (myLength != 0) {
			// we are going to the length -1 because we want to force the last index to be cut off
			for (int i = 0; i < arr.length -1; i++) {
				arr[i] = arr[i+1];
			}
			myLength--;
		}
//		String[] newArr = new String[myLength-1];
//		for (int i = 1; i < myLength; i++) {
//			newArr[i-1] = arr[i];
//		}
//		arr = Arrays.copyOf(newArr, myLength-1);
	}

	@Override
	public void addAtEnd(String data) {
		
		if(isFull()) {
			doubleLength();
			
		}
		arr[myLength] = data;
		myLength++;

	}

	@Override
	public void removeFromEnd() {
		// check that myLength does not = 0 so code does not throw error
		if (myLength != 0) {
			// null attempting to clear the slot
			arr[myLength - 1] = null; 
			//decrement the length
			myLength--;
		}

	}
	
//	public boolean removeAt(int index) {
//		
//		if (myLength != 0) {
//		
//			
//			return true; // replace
//		} else {
//			return false;
//		}
//		
//	}

	@Override
	public String get(int index) {
		
		if (index >= myLength) {
			throw new ArrayIndexOutOfBoundsException("index out of bounds");
		}
		
		return arr[index];
	}

	@Override
	public int size() {
		
		return myLength;
	}


	@Override
	public boolean removeAt(int index) {
		if (index >= myLength) {
			return false;
		} else {
			// starting index would be the element being removed
			// we remove that element by overwriting it with the element at the index
			for (int i = index; i < myLength-1; i++) {
				arr[i] = arr[i+1];
			}
			myLength--;
			return true;
		}
	}

	@Override
	public boolean insertAt(int index, String item) {
		myLength++;
		if (isFull()) {
			doubleLength();
		}
		if (index >= myLength) {
			return false;
		}
		// step 1: make way for new guy
		for (int i = index; i <= myLength + 1; i++) {
			arr[i+1] = arr[i];			
		} 
		// step 2: send him in to do the job, drop him at specified index
		arr[index] = item;
		
		return true;
	}
	
	@Override 
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < myLength; i++) {
			sb.append(arr[i]);
			if (i != myLength -1) {
				sb.append(", ");
			}
		}
		
		sb.append(" }");
		return sb.toString();
	}
}
