// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.*;

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer peekNumber;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.iterator = iterator;

	    if (iterator.hasNext()) {            
            this.peekNumber = iterator.next();
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peekNumber;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if (peekNumber == null) {
            throw new NoSuchElementException();
        }

	    return replaceAndReturn(peekNumber, () -> peekNumber = iterator.hasNext()? iterator.next() : null);
	}
	
	@Override
	public boolean hasNext() {
	    return peekNumber != null;
	}

    private Integer replaceAndReturn(Integer oldValue, Runnable updater) {
        updater.run();
        return oldValue;
    }
}