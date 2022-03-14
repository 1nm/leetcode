// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    Integer buffer;
    Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.buffer = null;
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (this.buffer == null) {
            this.buffer = this.iterator.next();
        }
        return this.buffer;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer ret = null;
        if (this.buffer == null) {
            ret = this.iterator.next();
        } else {
            ret = this.buffer;
            this.buffer = null;
        }
        return ret;
    }

    @Override
    public boolean hasNext() {
        return (this.buffer != null || this.iterator.hasNext());
    }
}
