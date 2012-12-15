package model;

import unti.UnifiedOAuth;

public abstract class BaseUser {
	private String id;
	private String name;
	private String birthday;
	private String tiny_url;
	private String url;
	private String location;
	private String createdTime;
	private UnifiedOAuth uoa;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getTiny_url() {
		return tiny_url;
	}
	public void setTiny_url(String tiny_url) {
		this.tiny_url = tiny_url;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public UnifiedOAuth getUoa() {
		return uoa;
	}
	public void setUoa(UnifiedOAuth uoa) {
		this.uoa = uoa;
	}
}
