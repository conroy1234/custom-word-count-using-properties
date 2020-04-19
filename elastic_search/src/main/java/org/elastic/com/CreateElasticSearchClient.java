package org.elastic.com;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateElasticSearchClient {

	public RestHighLevelClient createClient() {
		
		String honsname="mybonzai-4177299948.us-west-2.bonsaisearch.net";
		String username="rbverc0tgz";
		String password ="12y2vo1b8f";
		final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(username,password));
		
		RestClientBuilder builder = RestClient.builder(new HttpHost(honsname,443,"https")).setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
			
			@Override
			public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
				
				return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
			}
		});
		
		RestHighLevelClient client = new RestHighLevelClient(builder);
		return client;
	}
	public static void main(String[] args) throws IOException {
		Logger logger = LoggerFactory.getLogger(CreateElasticSearchClient.class);
		RestHighLevelClient client = new CreateElasticSearchClient().createClient();
		
		String jsonString ="{\"conroy\":\"white\"}";
		IndexRequest request = new IndexRequest("twitter", "twits").source(jsonString, XContentType.JSON);
		
		IndexResponse response = client.index(request);
		String id = response.getId();
		logger.info(id);
		client.close();
	}

}
