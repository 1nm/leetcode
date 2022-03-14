class MedianFinder {

    Queue<Integer> small = new PriorityQueue<>();
    Queue<Integer> large = new PriorityQueue<>();

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (small.size() == 0 && large.size() == 0)
            small.add(-num);
        else {
            if (small.size() == large.size()) {
                if (num <= large.peek())
                    small.add(-num);
                else {
                    small.add(-large.poll());
                    large.add(num);
                }
            } else {
                if (num <= -small.peek()) {
                    large.add(-small.poll());
                    small.add(-num);
                } else
                    large.add(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (small.size() == 0 && large.size() == 0)
            return 0;
        if (small.size() > large.size())
            return -small.peek();
        return (large.peek() - small.peek()) / 2.0;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
