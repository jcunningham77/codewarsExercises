package com.jeffcunningham.org.ArrayList;

public class ResizableArray {
	private int[] items = new int[8];
	private int size = 0;
	
	public int size() {
		return size;
	}
	
	public void set(int index, int item) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		items[index] = item;
		
	}
	
	public void append (int item) {
		ensureExtraCapacity();
		items[size] = item;
		size++;
	}
	
	public int get(int index) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return items[index];
		
	}
	
	private void ensureExtraCapacity() {
		int tempArray[] = null;
		if (items.length==size) {
			tempArray = new int[size*2];
			System.arraycopy(items, 0, tempArray, 0, size);
			items = tempArray;
			System.out.println("We have added extra capacity to the array storage, now the length is" + items.length);
		}
		

		
	}
	
}
