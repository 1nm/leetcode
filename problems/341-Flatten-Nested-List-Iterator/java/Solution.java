/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<List<NestedInteger>> stack;
    Map<List<NestedInteger>,Integer> indices;
    List<NestedInteger> curr;
    int index;
    Integer next;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        this.indices = new HashMap<>();
        this.curr = nestedList;
        this.index = 0;
        this.next = null;
    }

    @Override
    public Integer next() {
        return this.next;
    }

    @Override
    public boolean hasNext() {
        while (this.index == this.curr.size() && !this.stack.isEmpty()) {
            this.curr = this.stack.pop();
            this.index = indices.get(this.curr);
        }
        if (this.index == this.curr.size() && this.stack.isEmpty()) return false;
        NestedInteger ni = this.curr.get(this.index++);
        while (!ni.isInteger()) {
            this.indices.put(this.curr, this.index);
            this.stack.push(this.curr);
            this.curr = ni.getList();
            this.index = 0;
            while (this.index == this.curr.size() && !this.stack.isEmpty()) {
                this.curr = this.stack.pop();
                this.index = indices.get(this.curr);
            }
            if (this.index == this.curr.size() && this.stack.isEmpty()) break;
            ni = this.curr.get(this.index++);
        }
        this.next = ni.getInteger();
        return this.next != null;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */