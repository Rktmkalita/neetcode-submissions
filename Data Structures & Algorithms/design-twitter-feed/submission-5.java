class Twitter {

    int time = 0;
    Map<Integer,List<int[]>> tweets;
    Map<Integer,Set<Integer>> following;

    public Twitter() {
        this.tweets = new HashMap<>();
        this.following = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        int[] tweet = new int[]{tweetId, time++};
        tweets.computeIfAbsent(userId, t->new ArrayList<>()).add(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->a[1]-b[1]
        );

        Set<Integer> followingUsers = following.get(userId);
        
        if(followingUsers==null){
            followingUsers = new HashSet<>();
        }

        for(int user : followingUsers){
            List<int[]> list=tweets.get(user);
            for(int[] i: list){
                pq.offer(i);
                if(pq.size()>10){
                    pq.poll();
                }
            }
        }

        List<int[]> owntweets = tweets.get(userId);
        if(owntweets==null){
            owntweets = new ArrayList<>();
        }

        for(int[] i: owntweets){
            pq.offer(i);
            if(pq.size()>10){
                pq.poll();
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll()[0]);
        }

        Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, f->new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followedUsers = following.get(followerId);
        followedUsers.remove(followeeId);
    }
}
