package org.wordcount.custom.factory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
		Map<String, Long> collect = countByWordSorted(Arrays.asList("conroy", "conroy", "delroy", "louise", "conroy"));
			
		System.out.println(collect);

	}

	public static Word findword(String word, List<String> list) {
		long count = list.stream().filter(n -> n.equalsIgnoreCase(word)).count();
		return new Word((int) count, word);
	}

	public static Word findCharactor(char c, String word) {
		long count = word.chars().filter(p -> p == c).count();

		return new Word((int) count, word, c);
	}

	public static LinkedHashMap<String, Long> countByWordSorted(List<String> list) {
		//collect each words and count them
		Map<String, Long> collect = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		//sort the values by number of occurrences
		LinkedHashMap<String, Long> countByWordSorted = collect.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> {
					throw new IllegalStateException();
				}, LinkedHashMap::new));
		
		return countByWordSorted;
	}
}
