class Twitter {

    class Tweets {
        int id;
        int createdAt;

        public Tweets (int id, int createdAt) {
            this.id = id;
            this.createdAt = createdAt;
        }
    }

    int newsFeedCapacity;
    int createdAt;
    HashMap<Integer, HashSet<Integer>> userMap;
    HashMap<Integer, List<Tweets>> tweets;

    public Twitter() {
        newsFeedCapacity = 10;
        createdAt = 0;
        userMap = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {

        try {
            if (!tweets.containsKey(userId)) {
                tweets.put(userId, new ArrayList<>());
            }

            Tweets newTweet = new Tweets(tweetId, createdAt++);

            tweets.get(userId).add(newTweet);

            return;
        }
        catch (RuntimeException e) {
            System.err.println("Unchecked exception in postTweet -> class Twitter: " + e.getMessage());
            return;
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        try {
            follow (userId, userId);

            PriorityQueue<Tweets> pq = new PriorityQueue<>(newsFeedCapacity, (a, b) -> a.createdAt - b.createdAt);

            if (userMap.containsKey(userId)) {
                Set<Integer> followerList = userMap.get(userId);

                for (int id : followerList) {
                    List<Tweets> tweetList = tweets.get(id);

                    if (tweetList != null) {
                        for (Tweets tweet : tweetList) {
                            if (pq.size() == newsFeedCapacity) {
                                pq.poll();
                            }

                            pq.add(tweet);
                        }
                    }
                }
            }

            List<Integer> result = new ArrayList<>();

            while (!pq.isEmpty()) {
                result.add(0, pq.poll().id);
            }

            return result;
        }
        catch (RuntimeException e) {
            System.err.println("Unchecked exception in postTweet -> class Twitter: " + e.getMessage());
            return null;
        }
    }
    
    public void follow(int followerId, int followeeId) {
        
        try {
            if (!userMap.containsKey(followerId)) {
                userMap.put(followerId, new HashSet<>());
            }

            userMap.get(followerId).add(followeeId);
/*
            Set<Integer> followersList = userMap.get(followerId);

            followersList.add(followeeId);

            userMap.add(followerId, followersList);
*/
            return;
        } 
        catch (RuntimeException e) {
            System.err.println("Unchecked exception in follow(int, int) -> class Twitter: " + e.getMessage());
            return;
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        try {
            if (userMap.containsKey(followerId) && followerId != followeeId) {

                userMap.get(followerId).remove(followeeId);
/*
                Set<Integer> followerList = userMap.get(followerId);

                followersList.remove(followeeId);

                userMap.add(followerId, followersList);
*/                
            }

            return;
        }
        catch (RuntimeException e) {
            System.err.println("Unchecked exception in unfollow(int, int) -> class Twitter: " + e.getMessage());
            return;
        }
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