package model;

public class User {
	private Long id;
	private String name;
	private String about;
	private String year;
	private boolean isHost;
	private String avatarURL;
	private Integer totalReview;
	public User( String name, String about, boolean isHost, String year, String avatarURL) {
		this.name = name;
		this.year = year;
		this.about = about;
		this.avatarURL = avatarURL;
		this.isHost = isHost;
		
	}
	public boolean isHost() {
		return isHost;
	}
	
	public void setHost(boolean isHost) {
		this.isHost = isHost;
	}
	public User(long id, String name, String url, int totalReview) {
		this.id = id;
		this.name = name;
		this.avatarURL = url;
		this.totalReview = totalReview;
	}
	
	public User(long id, String avatarUrl) {
		this.id = id;
		this.avatarURL = avatarUrl;
	}
	

	public String getName() {
		return name;
	}
	public String getAbout() {
		return about;
	}
	public String getYear() {
		return year;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getTotalReview() {
		return totalReview;
	}
	public void setTotalReview(Integer totalReview) {
		this.totalReview = totalReview;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}
	public String getAvatarURL() {
		return avatarURL;
	}

}