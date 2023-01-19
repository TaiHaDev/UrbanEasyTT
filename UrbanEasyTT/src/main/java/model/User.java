package model;

public class User {

	private final String name;
	private final String about;
	private final String year;
	private final boolean isHost;
	private final String avatarURL;
	public User( String name, String about, String year, boolean isHost, String avatarURL) {
	
		this.name = name;
		this.year = year;
		this.isHost = isHost;
		this.about = about;
		this.avatarURL = avatarURL;
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
	public boolean isHost() {
		return isHost;
	}
	public String getAvatarURL() {
		return avatarURL;
	}

}