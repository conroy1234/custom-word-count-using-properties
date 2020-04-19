package org.wordcount.custom.factory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.wordcount.custom.model.Word;

public class WordCountConfig {

	private static Pattern pattern;
	private static Matcher matcheds;

	public static Word wordContainer(String word, String searchWord) {
		int count = 0;
		pattern = Pattern.compile(searchWord);
		matcheds = pattern.matcher(word);

		while (matcheds.find()) {
			count++;
		}
		return new Word(count, searchWord);
	}

	public static Word wordContainer(String word, String[] words) {
		int count= 0;
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

	

}
