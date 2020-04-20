package org.wordcount.custom.factory;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.wordcount.custom.model.Word;

public class WordCountConfig {

	private static Pattern pattern;
	private static Matcher matcheds;

	private static WordCountConfig instance = new WordCountConfig();

	public static WordCountConfig newInstance() {
		return instance;

	}

	private WordCountConfig() {

	}

	public Word wordContainerA(String searchWord, String word) {
		int count = 0;
		pattern = Pattern.compile(searchWord);
		matcheds = pattern.matcher(word);

		while (matcheds.find()) {
			count++;
		}
		return new Word(count, searchWord);
	}

	public Word wordContainerB(String word, String[] words) {
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

	public Word wordContainerC(String word, List<String> words) {
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

		System.out.println(findCharactor('a', "accountance"));

	}

	public static Word findword(String word, List<String> list) {
		long count = list.stream().filter(n -> n.equalsIgnoreCase(word)).count();
		return new Word((int) count, word);
	}

	public static Word findCharactor(char c, String word) {
		long count = word.chars().filter(p -> p == c).count();

		return new Word((int) count, word, c);
	}

}
