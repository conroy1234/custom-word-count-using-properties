package org.wordcount.custom.factory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;
import org.wordcount.custom.model.Word;

public class WordCountConfigTest {
	WordCountConfig wordCountConfig = new WordCountConfig();

	static String STRING_OF_WORDS = "around the rock the rogged raskal run until he run into the wolf that run him down";
	private static final String WORD_TO_SEARCH[] = STRING_OF_WORDS.split(" ");

	@Test
	public void testWordContainerInList() {
		String expected = "run";
		Word word = new WordCountConfig().wordContainerInList(expected, Arrays.asList(WORD_TO_SEARCH));
		assertThat(word.getCount(), is(3));
		assertThat(word.getWord(), is(expected));
	}

	@Test
	public void testWordContainerInString() {
		String expected = "rogged";
		Word word = new WordCountConfig().wordContainerInString(expected, STRING_OF_WORDS);
		assertThat(word.getCount(), is(1));
		assertThat(word.getWord(), is(expected));
	}

	@Test
	public void testWordContainerInArray() {
		String expected = "the";
		Word word = new WordCountConfig().wordContainerInArray(expected, WORD_TO_SEARCH);
		assertThat(word.getCount(), is(3));
		assertThat(word.getWord(), is(expected));
	}

	/*
	 * find word using java 8
	 */

	@Test
	public void when_search_word_conroy_in_java_8() throws Exception {
		String expected = "around";
		Word word = wordCountConfig.wordContainerInList(expected, Arrays.asList(WORD_TO_SEARCH));
		assertThat(word.getCount(), is(1));
		assertThat(word.getWord(), is(expected));

	}

	/*
	 * test characters
	 */
	@Test
	public void when_search_for_charactor_shantel_in_java_8() throws Exception {
		char expected = 'r';

		Word word = wordCountConfig.findCharactor(expected, STRING_OF_WORDS);
		assertThat(word.getCount(), is(7));
		assertThat(word.getC(), is(expected));

	}

	// test sorting words base on numbers of count
	@Test
	public void when_search_word_base_on_number_of_count() throws Exception {
		// populate the list

		LinkedHashMap<String, Long> result = wordCountConfig.countByWordSorted(Arrays.asList(WORD_TO_SEARCH));
		assertThat(result, is(prepareTest(Arrays.asList(WORD_TO_SEARCH))));
		assertThat(result.get("the"), is(3L));
		assertThat(result.get("run"), is(3L));
		assertThat(result.get("rock"), is(1L));
		assertThat(result.get("into"), is(1L));
		assertThat(result.get("raskal"), is(1L));
		assertThat(result.get("rogged"), is(1L));
		assertThat(result.get("until"), is(1L));
		assertThat(result.get("down"), is(1L));
		assertThat(result.get("him"), is(1L));
		assertThat(result.get("he"), is(1L));
		assertThat(result.get("around"), is(1L));
		System.out.println(result);
	}

	private LinkedHashMap<String, Long> prepareTest(List<String> list) {
		// collect each words and count them
		Map<String, Long> collect = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		// sort the values by number of occurrences
		LinkedHashMap<String, Long> countByWordSorted = collect.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> {
					throw new IllegalStateException();
				}, LinkedHashMap::new));

		return countByWordSorted;
	}
}
