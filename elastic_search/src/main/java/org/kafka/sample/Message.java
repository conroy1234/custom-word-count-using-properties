package org.kafka.sample;

public class Message {
	
	private String ofset;
	private String topic;
	private String partition;
	private String value;
	private String kay;
	public String getOfset() {
		return ofset;
	}
	public void setOfset(String ofset) {
		this.ofset = ofset;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getPartition() {
		return partition;
	}
	public void setPartition(String partition) {
		this.partition = partition;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getKay() {
		return kay;
	}
	public void setKay(String kay) {
		this.kay = kay;
	}
	@Override
	public String toString() {
		return "Message [ofset=" + ofset + ", topic=" + topic + ", partition=" + partition + ", value=" + value
				+ ", kay=" + kay + "]";
	}
	
	

}
