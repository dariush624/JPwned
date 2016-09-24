package org.jpwned.model;

import java.time.LocalDateTime;

import com.google.gson.annotations.SerializedName;
/**
 * @author Dariush Moshiri
 * Class that represents the Paste model
 */
public class Paste {
	
	@SerializedName("Source")
	private String source;
	@SerializedName("Id")
	private String id;
	@SerializedName("Title")
	private String title;
	@SerializedName("Date")
	private LocalDateTime date;
	@SerializedName("EmailCount")
	private int emailCounter;
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getEmailCounter() {
		return emailCounter;
	}
	public void setEmailCounter(int emailCounter) {
		this.emailCounter = emailCounter;
	}
	
}
