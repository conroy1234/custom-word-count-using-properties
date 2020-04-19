package org.wordcount.custom.model;

public class Word {
	private int count;
	private String actualWord;

	public Word(int count, String actualWord) {
		this.count = count;
		this.actualWord = actualWord;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getActualWord() {
		return actualWord;
	}

	public void setActualWord(String actualWord) {
		this.actualWord = actualWord;
	}

	@Override
	public String toString() {
		return "Word [count=" + count + ", actualWord=" + actualWord + "]";
	}

}
