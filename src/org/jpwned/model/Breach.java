package org.jpwned.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * @author Dariush Moshiri
 * Class that represents the Breach model
 */
public class Breach {
	
	@SerializedName("Name")
	private String name;
	@SerializedName("Title")
	private String title;
	@SerializedName("Domain")
	private String domain;
	@SerializedName("BreachDate")
	private LocalDate breachDate;
	@SerializedName("AddedDate")
	private LocalDateTime addedDate;
	@SerializedName("PwnCount")
	private int pwnCount;
	@SerializedName("Description")
	private String description;
	@SerializedName("DataClasses")
	private List<String> dataClasses;
	@SerializedName("IsVerified")
	private boolean isVerified;
	@SerializedName("IsSensitive")
	private boolean isSensitive;
	@SerializedName("IsRetired")
	private boolean isRetired;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public LocalDate getBreachDate() {
		return breachDate;
	}
	public void setBreachDate(LocalDate breachDate) {
		this.breachDate = breachDate;
	}
	public LocalDateTime getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(LocalDateTime addedDate) {
		this.addedDate = addedDate;
	}
	public int getPwnCount() {
		return pwnCount;
	}
	public void setPwnCount(int pwnCount) {
		this.pwnCount = pwnCount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getDataClasses() {
		return dataClasses;
	}
	public void setDataClasses(List<String> dataClasses) {
		this.dataClasses = dataClasses;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public boolean isSensitive() {
		return isSensitive;
	}
	public void setSensitive(boolean isSensitive) {
		this.isSensitive = isSensitive;
	}
	public boolean isRetired() {
		return isRetired;
	}
	public void setRetired(boolean isRetired) {
		this.isRetired = isRetired;
	}
	
}
