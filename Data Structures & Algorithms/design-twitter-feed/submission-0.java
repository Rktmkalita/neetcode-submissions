class Twitter {
    private Map<Integer, Set<Integer>> userFollowing; // Users this user follows
    private Map<Integer, List<int[]>> userTweets; // User's tweets (tweetId, timestamp)
    private int time; // Global timestamp

    public Twitter() {
        userFollowing = new HashMap<>();
        userTweets = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        userTweets.computeIfAbsent(userId, k -> new ArrayList<>());
        userTweets.get(userId).add(new int[]{tweetId, ++time});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> feed = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1])); // Min-Heap
        Set<Integer> users = userFollowing.getOrDefault(userId, new HashSet<>());
        users.add(userId); // Include user's own tweets

        for (int user : users) {
            List<int[]> tweets = userTweets.getOrDefault(user, new ArrayList<>());
            for (int[] tweet : tweets) {
                feed.offer(tweet);
                if (feed.size() > 10) { // Limit to the 10 most recent tweets
                    feed.poll();
                }
            }
        }

        List<Integer> result = new LinkedList<>();
        while (!feed.isEmpty()) {
            result.add(0, feed.poll()[0]); // Extract tweets in descending order of timestamp
        }
        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) { // Avoid self-follow
            userFollowing.computeIfAbsent(followerId, k -> new HashSet<>());
            userFollowing.get(followerId).add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (userFollowing.containsKey(followerId)) {
            userFollowing.get(followerId).remove(followeeId);
        }
    }
}
