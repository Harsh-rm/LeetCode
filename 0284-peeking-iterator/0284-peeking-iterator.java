// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer peekElement;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
        if(this.iterator.hasNext()) {
            peekElement = this.iterator.next();
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peekElement;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer temp = peekElement;

        if (iterator.hasNext()) {
            peekElement = iterator.next();
        } else {
            peekElement = null;
        }
        
        return temp;
	}
	
	@Override
	public boolean hasNext() {
	    if(peekElement == null) {
            return false;
        }

        return true;
	}
}