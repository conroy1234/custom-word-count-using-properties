package org.wordcount.custom.integration.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.wordcount.custom.CustomWordCountUsingPropertiesApplication;
import org.wordcount.custom.factory.WordCountConfig;
import org.wordcount.custom.model.Word;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = CustomWordCountUsingPropertiesApplication.class)
public class WordCountIntegrationTest {

	private static final String ACTUAL_FOR_LIST_OF_WORDS = "conroy";
	static String STRING_OF_WORDS = "conroy delroy timothy carol conroy louise victor conroy shantel conroy carol carol louise timothy";
	private static final String WORD_TO_SEARCH[] = STRING_OF_WORDS.split(" ");

	@Autowired
	protected MockMvc mockMvc;

	@Autowired
	MessageSource messageSource;

	private WordCountConfig wordCountConfig;

	@Before
	public void setup() {
		wordCountConfig = mock(WordCountConfig.class);
	}

	@Test
	public void test() {
		wordCountConfig.findCharactor('c', "conroy");
	}

	public void wordContainerTest() {

	}

	// seacrc for word conroy
	@Test
	public void when_search_word_conroy_in_list() throws Exception {
		String expected = "conroy";
		Word word = new WordCountConfig().wordContainerInList(expected, Arrays.asList(WORD_TO_SEARCH));
		Mockito.when(wordCountConfig.wordContainerInList(Matchers.anyString(), Matchers.any())).thenReturn(word);
		assertThat(word.getCount(), is(4));
		assertThat(word.getWord(), is(ACTUAL_FOR_LIST_OF_WORDS));
		System.out.println(word);

		String jsonString = "[{\"count\":4,\"word\":\"conroy\",\"c\":\"\\u0000\"}]";

		String url = new StringBuilder().append("/").append("word/search/" + expected).toString();

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(jsonString)).andDo(print())
				.andReturn();

	}

	@Test
	public void when_search_for_word_delroy_in_list() throws Exception {
		String expected = "delroy";

		Word word = new WordCountConfig().wordContainerInList(expected, Arrays.asList(WORD_TO_SEARCH));
		Mockito.when(wordCountConfig.wordContainerInList(Matchers.anyString(), Matchers.any())).thenReturn(word);
		assertThat(word.getCount(), is(1));
		assertThat(word.getWord(), is(expected));
		System.out.println(word);

		String jsonString = "[{\"count\":1,\"word\":\"delroy\",\"c\":\"\\u0000\"}]";

		String url = new StringBuilder().append("/").append("word/search/" + expected).toString();

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(jsonString)).andDo(print())
				.andReturn();

	}

	@Test
	public void when_search_for_word_timothy_in_list() throws Exception {
		String expected = "timothy";

		Word word = new WordCountConfig().wordContainerInList(expected, Arrays.asList(WORD_TO_SEARCH));
		Mockito.when(wordCountConfig.wordContainerInList(Matchers.anyString(), Matchers.any())).thenReturn(word);
		assertThat(word.getCount(), is(2));
		assertThat(word.getWord(), is(expected));
		System.out.println(word);

		String jsonString = "[{\"count\":2,\"word\":\"timothy\",\"c\":\"\\u0000\"}]";

		String url = new StringBuilder().append("/").append("word/search/" + expected).toString();

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(jsonString)).andDo(print())
				.andReturn();

	}

	@Test
	public void when_search_for_word_shantel_in_list() throws Exception {
		String expected = "shantel";

		Word word = new WordCountConfig().wordContainerInList(expected, Arrays.asList(WORD_TO_SEARCH));
		Mockito.when(wordCountConfig.wordContainerInList(Matchers.anyString(), Matchers.any())).thenReturn(word);
		assertThat(word.getCount(), is(1));
		assertThat(word.getWord(), is(expected));
		System.out.println(word);

		String jsonString = "[{\"count\":1,\"word\":\"shantel\",\"c\":\"\\u0000\"}]";

		String url = new StringBuilder().append("/").append("word/search/" + expected).toString();

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(jsonString)).andDo(print())
				.andReturn();

	}

	/*
	 * find word in array
	 */

	@Test
	public void when_search_word_conroy_in_array() throws Exception {
		String expected = "conroy";
		Word word = new WordCountConfig().wordContainerInArray(expected, WORD_TO_SEARCH);
		Mockito.when(wordCountConfig.wordContainerInArray(Matchers.anyString(), Matchers.any())).thenReturn(word);
		assertThat(word.getCount(), is(4));
		assertThat(word.getWord(), is(ACTUAL_FOR_LIST_OF_WORDS));
		System.out.println(word);

		String jsonString = "[{\"count\":4,\"word\":\"conroy\",\"c\":\"\\u0000\"}]";

		String url = new StringBuilder().append("/").append("word/search/" + expected).toString();

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(jsonString)).andDo(print())
				.andReturn();

	}

	@Test
	public void when_search_for_word_delroy_in_array() throws Exception {
		String expected = "delroy";

		Word word = new WordCountConfig().wordContainerInArray(expected, WORD_TO_SEARCH);
		Mockito.when(wordCountConfig.wordContainerInList(Matchers.anyString(), Matchers.any())).thenReturn(word);
		assertThat(word.getCount(), is(1));
		assertThat(word.getWord(), is(expected));
		System.out.println(word);

		String jsonString = "[{\"count\":1,\"word\":\"delroy\",\"c\":\"\\u0000\"}]";

		String url = new StringBuilder().append("/").append("word/search/" + expected).toString();

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(jsonString)).andDo(print())
				.andReturn();

	}

	@Test
	public void when_search_for_word_timothy_in_array() throws Exception {
		String expected = "timothy";

		Word word = new WordCountConfig().wordContainerInArray(expected, WORD_TO_SEARCH);
		Mockito.when(wordCountConfig.wordContainerInList(Matchers.anyString(), Matchers.any())).thenReturn(word);
		assertThat(word.getCount(), is(2));
		assertThat(word.getWord(), is(expected));
		System.out.println(word);

		String jsonString = "[{\"count\":2,\"word\":\"timothy\",\"c\":\"\\u0000\"}]";

		String url = new StringBuilder().append("/").append("word/search/" + expected).toString();

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(jsonString)).andDo(print())
				.andReturn();

	}

	@Test
	public void when_search_for_word_shantel_in_array() throws Exception {
		String expected = "shantel";

		Word word = new WordCountConfig().wordContainerInArray(expected, WORD_TO_SEARCH);
		Mockito.when(wordCountConfig.wordContainerInList(Matchers.anyString(), Matchers.any())).thenReturn(word);
		assertThat(word.getCount(), is(1));
		assertThat(word.getWord(), is(expected));
		System.out.println(word);

		String jsonString = "[{\"count\":1,\"word\":\"shantel\",\"c\":\"\\u0000\"}]";

		String url = new StringBuilder().append("/").append("word/search/" + expected).toString();

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(jsonString)).andDo(print())
				.andReturn();

	}

	/*
	 * 
	 * string of words
	 */

	@Test
	public void when_search_word_conroy_in_string() throws Exception {
		String expected = "conroy";
		Word word = new WordCountConfig().wordContainerInString(expected, STRING_OF_WORDS);
		Mockito.when(wordCountConfig.wordContainerInString(Matchers.anyString(), Matchers.anyString()))
				.thenReturn(word);
		assertThat(word.getCount(), is(4));
		assertThat(word.getWord(), is(ACTUAL_FOR_LIST_OF_WORDS));
		System.out.println(word);

		String jsonString = "[{\"count\":4,\"word\":\"conroy\",\"c\":\"\\u0000\"}]";

		String url = new StringBuilder().append("/").append("word/search/" + expected).toString();

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(jsonString)).andDo(print())
				.andReturn();

	}

	@Test
	public void when_search_for_word_delroy_in_string() throws Exception {
		String expected = "delroy";

		Word word = new WordCountConfig().wordContainerInString(expected, STRING_OF_WORDS);
		Mockito.when(wordCountConfig.wordContainerInString(Matchers.anyString(), Matchers.anyString()))
				.thenReturn(word);
		assertThat(word.getCount(), is(1));
		assertThat(word.getWord(), is(expected));
		System.out.println(word);

		String jsonString = "[{\"count\":1,\"word\":\"delroy\",\"c\":\"\\u0000\"}]";

		String url = new StringBuilder().append("/").append("word/search/" + expected).toString();

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(jsonString)).andDo(print())
				.andReturn();

	}

	@Test
	public void when_search_for_word_timothy_in_string() throws Exception {
		String expected = "timothy";

		Word word = new WordCountConfig().wordContainerInString(expected, STRING_OF_WORDS);
		Mockito.when(wordCountConfig.wordContainerInString(Matchers.anyString(), Matchers.anyString()))
				.thenReturn(word);
		assertThat(word.getCount(), is(2));
		assertThat(word.getWord(), is(expected));
		System.out.println(word);

		String jsonString = "[{\"count\":2,\"word\":\"timothy\",\"c\":\"\\u0000\"}]";

		String url = new StringBuilder().append("/").append("word/search/" + expected).toString();

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(jsonString)).andDo(print())
				.andReturn();

	}

	@Test
	public void when_search_for_word_shantel_in_string() throws Exception {
		String expected = "shantel";

		Word word = new WordCountConfig().wordContainerInString(expected, STRING_OF_WORDS);
		Mockito.when(wordCountConfig.wordContainerInString(Matchers.anyString(), Matchers.anyString()))
				.thenReturn(word);
		assertThat(word.getCount(), is(1));
		assertThat(word.getWord(), is(expected));
		System.out.println(word);

		String jsonString = "[{\"count\":1,\"word\":\"shantel\",\"c\":\"\\u0000\"}]";

		String url = new StringBuilder().append("/").append("word/search/" + expected).toString();

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(jsonString)).andDo(print())
				.andReturn();

	}

	/*
	 * find word using java 8
	 */

	@Test
	public void when_search_word_conroy_in_java_8() throws Exception {
		String expected = "conroy";
		Word word = new WordCountConfig().wordContainerInList(expected, Arrays.asList(WORD_TO_SEARCH));
		Mockito.when(wordCountConfig.findword(Matchers.anyString(), Matchers.any())).thenReturn(word);
		assertThat(word.getCount(), is(4));
		assertThat(word.getWord(), is(ACTUAL_FOR_LIST_OF_WORDS));
		System.out.println(word);

		String jsonString = "[{\"count\":4,\"word\":\"conroy\",\"c\":\"\\u0000\"}]";

		String url = new StringBuilder().append("/").append("word/search-java8/" + expected).toString();

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(jsonString)).andDo(print())
				.andReturn();

	}

	@Test
	public void when_search_for_word_delroy_in_java_8() throws Exception {
		String expected = "delroy";

		Word word = new WordCountConfig().wordContainerInList(expected, Arrays.asList(WORD_TO_SEARCH));
		Mockito.when(wordCountConfig.findword(Matchers.anyString(), Matchers.any())).thenReturn(word);
		assertThat(word.getCount(), is(1));
		assertThat(word.getWord(), is(expected));
		System.out.println(word);

		String jsonString = "[{\"count\":1,\"word\":\"delroy\",\"c\":\"\\u0000\"}]";

		String url = new StringBuilder().append("/").append("word/search-java8/" + expected).toString();

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(jsonString)).andDo(print())
				.andReturn();

	}

	@Test
	public void when_search_for_word_timothy_in_java_8() throws Exception {
		String expected = "timothy";

		Word word = new WordCountConfig().wordContainerInList(expected, Arrays.asList(WORD_TO_SEARCH));
		Mockito.when(wordCountConfig.findword(Matchers.anyString(), Matchers.any())).thenReturn(word);
		assertThat(word.getCount(), is(2));
		assertThat(word.getWord(), is(expected));
		System.out.println(word);

		String jsonString = "[{\"count\":2,\"word\":\"timothy\",\"c\":\"\\u0000\"}]";

		String url = new StringBuilder().append("/").append("word/search-java8/" + expected).toString();

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(jsonString)).andDo(print())
				.andReturn();

	}

	@Test
	public void when_search_for_word_shantel_in_java_8() throws Exception {
		String expected = "shantel";

		Word word = new WordCountConfig().wordContainerInList(expected, Arrays.asList(WORD_TO_SEARCH));
		Mockito.when(wordCountConfig.findword(Matchers.anyString(), Matchers.any())).thenReturn(word);
		assertThat(word.getCount(), is(1));
		assertThat(word.getWord(), is(expected));
		System.out.println(word);

		String jsonString = "[{\"count\":1,\"word\":\"shantel\",\"c\":\"\\u0000\"}]";

		String url = new StringBuilder().append("/").append("word/search-java8/" + expected).toString();

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(jsonString)).andDo(print())
				.andReturn();

	}

	
	/*
	 * test characters
	 */
	@Test
	public void when_search_for_charactor_shantel_in_java_8() throws Exception {
		char expected = 's';

		Word word = new WordCountConfig().findCharactor(expected, STRING_OF_WORDS);
		when(wordCountConfig.findCharactor(Matchers.anyChar(), Matchers.anyString())).thenReturn(word);
		assertThat(word.getCount(), is(3));
		assertThat(word.getC(), is(expected));
		System.out.println(word);

		String jsonString = "[\r\n" + "    {\r\n" + "        \"count\": 2,\r\n"
				+ "        \"word\": \"conroy delroy timothy carol conroy louise victor conroy shantel conroy timothy\",\r\n"
				+ "        \"c\": \"s\"\r\n" + "    }\r\n" + "]";

		String url = new StringBuilder().append("/word/search/charactor/s").toString();

		mockMvc.perform(MockMvcRequestBuilders.get(url).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json(jsonString)).andDo(print())
				.andReturn();

	}
	
	
	
	// test sorting words base on numbers of count
		@Test
		public void when_search_word_base_on_number_of_count() throws Exception {
			//populate the list
			List<String> list = Arrays.asList("conroy delroy timothy carol conroy louise victor conroy shantel conroy timothy");
			
			//count the number of occurrences
			Map<String, Long> collect = list.stream()
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
			
			// sort word base on number of occurrences
			LinkedHashMap<String, Long> countByWordSorted = collect.entrySet().stream()
					.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> {
						throw new IllegalStateException();
					}, LinkedHashMap::new));
			
			
			when( wordCountConfig.countByWordSorted(anyList())).thenReturn(countByWordSorted);
		
			
			mockMvc.perform(MockMvcRequestBuilders.get("/find/sorted/words/from/file").contentType(MediaType.APPLICATION_JSON_VALUE))
					.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().json("{\r\n" + 
							"    \"conroy\": 4,\r\n" + 
							"    \"timothy\": 2,\r\n" + 
							"    \"carol\": 1,\r\n" + 
							"    \"victor\": 1,\r\n" + 
							"    \"shantel\": 1,\r\n" + 
							"    \"louise\": 1,\r\n" + 
							"    \"delroy\": 1\r\n" + 
							"}")).andDo(print())
					.andReturn();

		}
		
		

}
