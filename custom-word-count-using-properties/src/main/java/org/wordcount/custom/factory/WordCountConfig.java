package org.wordcount.custom.factory;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.wordcount.custom.model.Word;

public class WordCountConfig {

	private static Pattern pattern;
	private static Matcher matcheds;

	public static Word wordContainer(String searchWord, String word) {
		int count = 0;
		pattern = Pattern.compile(searchWord);
		matcheds = pattern.matcher(word);

		while (matcheds.find()) {
			count++;
		}
		return new Word(count, searchWord);
	}

	public static Word wordContainer(String word, String[] words) {
		int count = 0;
		String search = "";

		for (String str : words) {
			search += str;
		}

		pattern = Pattern.compile(word);
		matcheds = pattern.matcher(search);

		while (matcheds.find()) {
			count++;
		}
		return new Word(count, word);
	}

	public static Word wordContainer(String word, List<String> words) {
		String search = "";
		int count = 0;
		for (String str : words) {
			search += str;
		}

		pattern = Pattern.compile(word);
		matcheds = pattern.matcher(search);

		while (matcheds.find()) {
			count++;
		}
		return new Word(count, word);
	}

	public static void main(String[] args) {
	System.out.println(findword(Arrays.asList("conroy","conroy","timothy"), "conroy"));
	System.out.println(findCharactor("conroy",'o'));

	}

	public static String findword(List<String> list, String word) {
		long count = list.stream().filter(n -> n == word).count();
		return word+" : "+count;
	}

	public static String findCharactor(String word, char c) {			
		long count = word.chars().filter(p -> p==c ).count();		
		return word+" : "+count;
	}

}
