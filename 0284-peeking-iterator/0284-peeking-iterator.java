// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.NoSuchElementException;

class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer next;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;

        if (this.iterator.hasNext()) {
            next = this.iterator.next();
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        try {
            return next;
        }
        catch(RuntimeException e) {
            System.err.println("Un-checked exception at peek() -> class PeekingIterator: " + e.getMessage());
            return null;
        }                
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        try {
            Integer temp = next;

            if (iterator.hasNext()) {
                next = iterator.next();
            } else {
                next = null;
            }

            return temp;
        }
        catch (RuntimeException e) {
            System.err.println("Un-checked exception in next() -> class PeekingIterator: " + e.getMessage());
            return null;
        }
	}
	
	@Override
	public boolean hasNext() {
        try {
            if (next == null) return false;

            else return true;
        }
        catch (RuntimeException e) {
            System.err.println("Un-checked exception in hasNext() -> class PeekingIterator: " + e.getMessage());
            return false;
        }	    
	}
}