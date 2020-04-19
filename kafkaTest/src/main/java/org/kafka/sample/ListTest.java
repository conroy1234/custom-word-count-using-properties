package org.kafka.sample;

import java.util.List;

import com.google.common.collect.Lists;

public class ListTest {

	public static void main(String[] args) {
		List<String> lists = Lists.newArrayList("conroy","delroy","louise","stephen");
		lists.stream().forEach(l->{
			System.out.println(l);
			Runtime.getRuntime().addShutdownHook(new Thread(()->{
				System.out.println("shutting down");
			}));
		});
	}

}
