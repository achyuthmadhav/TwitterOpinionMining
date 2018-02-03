package twitterStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TweetSample 
{
    private static String CONSUMER_KEY_SECRET = "635fsZ8EdtGskPNJaMU4eCxzUx6bwguUB6NZbjJVyUem8HdVqe";
	private static String CONSUMER_KEY = "SZSAHKgh0jec0flBIzyZIk0F8";
	private static int count = 0;
	public static void main( String[] args ) throws IOException
    {
    	Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);
        String accessToken = "1331394793-RmnlgxDsvVyeXNe5hA182w0AnmfoEEpQdIZNHSV"; /* enter your twitter access token */
       String accessTokenSecret = "GGgbfTJuogLQPhHNWbsfCeOhwlps7C80Q7J1FcQxQ7wvU"; /*enter your twitter secret token */
        AccessToken oathAccessToken = new AccessToken(accessToken, accessTokenSecret);
       twitter.setOAuthAccessToken(oathAccessToken);
       /*ConfigurationBuilder cb = new ConfigurationBuilder();
       cb.setDebugEnabled(true)
         .setOAuthConsumerKey(CONSUMER_KEY)
         .setOAuthConsumerSecret(CONSUMER_KEY_SECRET)
         .setOAuthAccessToken(accessToken)
         .setOAuthAccessTokenSecret(accessTokenSecret);
       TwitterFactory tf = new TwitterFactory(cb.build());
       Twitter twitter1 = tf.getInstance();*/
	   File file = new File("DTweets.txt");
	   FileWriter fw = new FileWriter(file);
       for(int i=1; i<100; i++) {
       getTweets(twitter, i, 200, fw);
       }
       fw.close();
       /* Query query = new Query("Covfefe");
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
        */
    }

	private static void getTweets(Twitter twitter, int page, int number, FileWriter fw) throws IOException {
		Paging paging = new Paging(page, number);
		   List<Status>  statuses = null;
		   try {
			statuses = twitter.getUserTimeline("@realDonaldTrump", paging);
			} catch (TwitterException e1) {
			e1.printStackTrace();
		}
		   int i=1;

		   while(!statuses.isEmpty() && i<=statuses.size()) {
			   fw.write(++count + ". " + statuses.get(statuses.size()-i).getText()+"\n");
			   fw.write("*************************************************************\n");
			   i++;
		   }
		   
	}
}

