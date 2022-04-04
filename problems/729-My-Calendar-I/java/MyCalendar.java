import java.util.TreeSet;

public class MyCalendar {

  private TreeSet<int[]> bookings;

  private boolean conflicts(int[] a, int[] b) {
    int compare = a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
    if (compare > 0) {
      int[] c = a;
      a = b;
      b = c;
    }
    // It is gauranteed that a[0] < a[1] and b[0] < b[1] so we only check if a[1] and b[0]
    // intersects
    return a[1] > b[0];
  }

  public MyCalendar() {
    // Sort the by start asc, if start is the same, by end desc
    bookings = new TreeSet<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
  }

  public boolean book(int start, int end) {
    int[] newBooking = new int[] {start, end};
    int[] floor = bookings.floor(newBooking);
    int[] ceiling = bookings.ceiling(newBooking);
    if (floor != null && conflicts(floor, newBooking)) {
      return false;
    }
    if (ceiling != null && conflicts(ceiling, newBooking)) {
      return false;
    }
    bookings.add(newBooking);
    return true;
  }
}
