public class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        PriorityQueue<Child> q = new PriorityQueue<Child>(ratings.length,
                new Comparator<Child>() {
                    @Override
                    public int compare(Child o1, Child o2) {
                        return o1.rating - o2.rating;
                    }
                });
        for (int i = 0; i < ratings.length; ++i) {
            candies[i] = 1;
            q.add(new Child(ratings[i], i));
        }
        while (!q.isEmpty()) {
            Child child = q.poll();
            int index = child.index;
            if (index - 1 >= 0 && ratings[index - 1] > child.rating && candies[index - 1] <= candies[child.index]) {
                candies[index - 1] = candies[child.index] + 1;
            }
            if (index + 1 < ratings.length && ratings[index + 1] > child.rating && candies[index + 1] <= candies[child.index]) {
                candies[index + 1] = candies[child.index] + 1;
            }
        }
        int total = 0;
        for (int i = 0; i < candies.length; ++i) {
            total += candies[i];
        }
        return total;
    }
    
    class Child {
        int rating;
        int index;
        Child(int rating, int index) {
            this.rating = rating;
            this.index = index;
        }
    }
}