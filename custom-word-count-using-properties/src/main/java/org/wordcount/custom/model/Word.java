package org.wordcount.custom.model;

public class Word {
	private int count;
	private String word;
	private char c;

	public Word(int count, String actualWord) {
		this.count = count;
		this.word = actualWord;
	}


	public Word(int count, String word, char c) {	
		this.count = count;
		this.word = word;
		this.c = c;
	}


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Word [count=" + count + ", word=" + word + ", c=" + c + "]";
	}


}
