package twitterStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TweetSample 
{
    private static String CONSUMER_KEY_SECRET = "635fsZ8EdtGskPNJaMU4eCxzUx6bwguUB6NZbjJVyUem8HdVqe";
	private static String CONSUMER_KEY = "SZSAHKgh0jec0flBIzyZIk0F8";

	public static void main( String[] args )
    {
    	Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);
        String accessToken = "1331394793-RmnlgxDsvVyeXNe5hA182w0AnmfoEEpQdIZNHSV"; /* enter your twitter access token */
       String accessTokenSecret = "GGgbfTJuogLQPhHNWbsfCeOhwlps7C80Q7J1FcQxQ7wvU"; /*enter your twitter secret token */
        AccessToken oathAccessToken = new AccessToken(accessToken, accessTokenSecret);
       twitter.setOAuthAccessToken(oathAccessToken);
        Query query = new Query("Trump");
        query.setCount(100);
        query.setLang("en");
        QueryResult result = null;
        try {
			result = twitter.search(query);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
        List<Status> list = result.getTweets();
        System.out.println(list.get(99).getLang());
        System.out.println(list.get(0).getText());
        System.out.print(result.getCount());
        
    }
}

