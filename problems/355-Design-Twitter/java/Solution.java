public class Twitter {

    Map<Integer, Set<Integer>> following;
    Map<Integer, Queue<Tweet>> tweets;

    private static final int CAPACITY = 10;

    static class Tweet {
        static int count = 0;
        int time;
        int id;
        public Tweet(int id) {
            this.time = count++;
            this.id = id;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new LinkedList<>());
        }
        Queue<Tweet> t = tweets.get(userId);
        if (t.size() == CAPACITY)
            t.poll();
        t.add(new Tweet(tweetId));
        tweets.put(userId, t);
    }

    private void addTweet(PriorityQueue<Tweet> feed, int userId) {
        if (tweets.containsKey(userId)) {
            for (Tweet t : tweets.get(userId)) {
                if (feed.size() == CAPACITY) {
                    if (t.time > feed.peek().time) {
                        feed.poll();
                        feed.add(t);
                    }
                } else {
                    feed.add(t);
                }
            }
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        // use min heap to keep latest 10 tweets
        PriorityQueue<Tweet> feed = new PriorityQueue<>((Tweet t1, Tweet t2) -> t1.time - t2.time);
        // add user's self tweets
        addTweet(feed, userId);
        // add followee's tweets
        if (following.containsKey(userId))
            for (int id : following.get(userId))
                addTweet(feed, id);
        List<Integer> result = new ArrayList<>();
        while(!feed.isEmpty())
            result.add(feed.poll().id);
        Collections.reverse(result);
        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) return;
        if (!following.containsKey(followerId)) {
            following.put(followerId, new HashSet<>());
        }
        Set<Integer> followees = following.get(followerId);
        followees.add(followeeId);
        following.put(followerId, followees);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId || !following.containsKey(followerId)) return;
        Set<Integer> followees = following.get(followerId);
        followees.remove(followeeId);
        following.put(followerId, followees);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
