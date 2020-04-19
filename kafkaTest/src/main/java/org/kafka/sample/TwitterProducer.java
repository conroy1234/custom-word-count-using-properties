package org.kafka.sample;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;

public class TwitterProducer {

	private Logger logger = LoggerFactory.getLogger(TwitterProducer.class.getName());
	private static final String CONSUMER_KEY = "consumer key from twitter";
	private static final String CONSUMER_SECRET = "consumer secret from twitter";
	private static final String TOKEN = "token from twitter";
	private static final String SECRET = "secret from twitter";

	public static void main(String[] args) throws InterruptedException {
		new TwitterProducer().reu();
	}

	private void reu() throws InterruptedException {
		BlockingQueue<String> msgQueue = new LinkedBlockingQueue<String>(100000);

		Client client = cerstaClient(msgQueue);
		client.connect();
		boolean isDone = client.isDone();
		// on a different thread, or multiple different threads....
		while (!isDone) {
			String msg = msgQueue.poll(5, TimeUnit.MILLISECONDS);
			if (msg != null) {
				isDone = false;
				
				logger.info(">>>>>>>>>>>>>>"+msg);
				break;
			}else {				
				isDone= true;
				
			}
			logger.info("End of application");

		}

	}

	private Client cerstaClient(BlockingQueue<String> msgQueue) {
				
		/**
		 * Declare the host you want to connect to, the endpoint, and authentication
		 * (basic auth or oauth)
		 */
		Hosts host = new HttpHosts(Constants.STREAM_HOST);
		StatusesFilterEndpoint endpoint = new StatusesFilterEndpoint();
		// Optional: set up some followings and track terms
		List<String> terms = Lists.newArrayList("twitter", "api");
		endpoint.trackTerms(terms);

		// These secrets should be read from a config file
		Authentication hosebirdAuth = new OAuth1(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, SECRET);

		ClientBuilder builder = new ClientBuilder().name("Hosebird-Client-01") // optional: mainly for the logs
				.hosts(host).authentication(hosebirdAuth).endpoint(endpoint)
				.processor(new StringDelimitedProcessor(msgQueue));

		Client client = builder.build();
		return client;

	}
}
