package model;

public class User {
	private Long id;
	private String name;
	private String about;
	private String year;
	private String phone;
	private String email;
	private boolean isHost;
	private String avatarURL;
	private Integer totalReview;

	public User(long id, String name, String url, int totalReview) {
		this.id = id;
		this.name = name;
		this.avatarURL = url;
		this.totalReview = totalReview;
	}

	public User(String name, String about, boolean isHost, String year, String avatarURL) {
		this.name = name;
		this.year = year;
		this.about = about;
		this.avatarURL = avatarURL;
		this.isHost = isHost;

	}

	public User(String name, String phone, String email, String url) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.avatarURL = url;
	}

	public User(String name, String phone, String email, String url, String year, String about) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.avatarURL = url;
		this.year = year;
		this.about = about;
	}

	public User(long id, String avatarUrl) {
		this.id = id;
		this.avatarURL = avatarUrl;
	}

	public boolean isHost() {
		return isHost;
	}

	public void setHost(boolean isHost) {
		this.isHost = isHost;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}