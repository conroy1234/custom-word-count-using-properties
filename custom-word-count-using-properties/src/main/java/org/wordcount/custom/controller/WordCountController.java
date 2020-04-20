package org.wordcount.custom.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.wordcount.custom.factory.WordCountConfig;
import org.wordcount.custom.model.Word;

@RestController
public class WordCountController {
	@Autowired
	MessageSource messageSource;
	

	private static Pattern pattern;
	private static Matcher matcheds;


	@GetMapping("/word/search/{search}")
	public List<Word> findWordInList(@RequestHeader(name="Accept-Language",required=false) Locale locale,@PathVariable String search) {			
		Word word = WordCountConfig.wordContainer(search, Arrays.asList( messageSource.getMessage("word-searchdisplay.message", null,locale)) );
		System.out.println(word);
	System.out.println(word);
	return Arrays.asList(word);
		
	}
	
	public  Word wordContainer(String word, String[] words) {
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
