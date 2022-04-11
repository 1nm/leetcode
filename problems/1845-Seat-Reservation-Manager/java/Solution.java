import java.util.PriorityQueue;

class SeatManager {

  PriorityQueue<Integer> q;
  int min;

  public SeatManager(int n) {
    q = new PriorityQueue<>();
    min = 1;
  }

  public int reserve() {
    if (!q.isEmpty()) {
      return q.poll();
    } else {
      int curr = min;
      min++;
      return curr;
    }
  }

  public void unreserve(int seatNumber) {
    q.add(seatNumber);
  }
}

/**
 * Your SeatManager object will be instantiated and called as such: SeatManager obj = new
 * SeatManager(n); int param_1 = obj.reserve(); obj.unreserve(seatNumber);
 */
