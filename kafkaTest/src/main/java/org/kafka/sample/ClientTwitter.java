package org.kafka.sample;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

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

public class ClientTwitter {

	public static void main(String[] args) throws InterruptedException {
		new ClientTwitter().run();
	}

	private void run() throws InterruptedException {
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
		Client client = createClient(queue);
		boolean result = client.isDone();
		while(result) {
			String data = queue.poll(5, TimeUnit.MILLISECONDS);
			if(data !=null) {
				result= true;
				break;
			}else {
				result= false;
			}
		}

	}

	private Client createClient(BlockingQueue<String> queue) {

		Authentication authentication = new OAuth1("", "", "", "");
		StatusesFilterEndpoint endpoint = new StatusesFilterEndpoint();
		endpoint.trackTerms(Lists.newArrayList("streamo stream 2", "stream 3"));
		Hosts hosts = new HttpHosts(Constants.STREAM_HOST);
		return new ClientBuilder().name("client_test").endpoint(endpoint).hosts(hosts).authentication(authentication)
				.processor(new StringDelimitedProcessor(queue)).build();
	}

}
