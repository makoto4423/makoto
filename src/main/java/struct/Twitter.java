package struct;

import java.util.*;

public class Twitter {

    private List<String> twitters = new ArrayList<>();
    private Map<Integer, Set<Integer>> subscribes = new HashMap<>();

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        twitters.add(userId+","+tweetId);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> subscribe =  subscribes.get(userId);
        if(subscribe == null){
            subscribe = new HashSet<>();
        }
        subscribe.add(userId);
        for(int i=twitters.size()-1; i>=0; i--){
            String[] ss = twitters.get(i).split(",");
            if(subscribe.contains(Integer.parseInt(ss[0]))){
                result.add(Integer.parseInt(ss[1]));
            }
            if(result.size() == 10){
                return result;
            }
        }
        return result;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> subscribe = subscribes.get(followerId);
        if(subscribe == null){
            subscribe = new HashSet<>();
        }
        subscribe.add(followeeId);
        subscribes.put(followerId, subscribe);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> subscribe = subscribes.get(followerId);
        if(subscribe == null)   return;
        subscribe.remove(followeeId);
    }
}
