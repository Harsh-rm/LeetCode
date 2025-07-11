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
        try {
            return peekElement;
        }
        catch(RuntimeException e) {
            System.err.println("Unchecked Exception at hasNext() -> class Peeking Iterator" + e);
            return null;
        }
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {

        try {
            Integer temp = peekElement;

            if (iterator.hasNext()) {
                peekElement = iterator.next();
            } else {
                peekElement = null;
            }

            return temp;
        }
        catch(RuntimeException e) {
            System.err.println("Unchecked Exception at hasNext() -> class Peeking Iterator" + e);
            return null;
        }        
	}
	
	@Override
	public boolean hasNext() {

        try {
            if(peekElement == null) {
                return false;
            }

            return true;
        } 
        catch(RuntimeException e) {
            System.err.println("Unchecked Exception at hasNext() -> class Peeking Iterator" + e);
            return false;
        }

	}
}