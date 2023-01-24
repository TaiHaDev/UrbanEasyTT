package model;

public class Review {
	private String propertyName;
	private String date;
	private String comment;
	private long reviewerId;
	private String propertyUrl;
	private long propertyId;
	private String userName;
	private String city;
	private String country;
	private String userUrl;
	private int cleanliness;
	private int communication;
	private int checkin;
	private int accuracy;
	private int location;
	private int value;
	

	public Review(String propertyName, String date, String comment, String propertyUrl, String userUrl, long propertyId,
			long reviewerId, String userName, String city, String country) {
		this.propertyName = propertyName;
		this.date = date;
		this.comment = comment;
		this.propertyUrl = propertyUrl;
		this.propertyId = propertyId;
		this.reviewerId = reviewerId;
		this.userName = userName;
		this.city = city;
		this.country = country;
		this.userUrl = userUrl;
	}

	public Review(long reviewerId, String userName, String userUrl, String comment, String date, int cleanliness,
			int communication, int checkin, int accuracy, int location, int value) {
		this.reviewerId = reviewerId;
		this.userName = userName;
		this.userUrl = userUrl;
		this.comment = comment;
		this.date = date;
		this.cleanliness = cleanliness;
		this.communication = communication;
		this.checkin = checkin;
		this.accuracy = accuracy;
		this.location = location;
		this.value = value;
	}
	
	public int getCleanliness() {
		return cleanliness;
	}

	public void setCleanliness(int cleanliness) {
		this.cleanliness = cleanliness;
	}

	public int getCommunication() {
		return communication;
	}

	public void setCommunication(int communication) {
		this.communication = communication;
	}

	public int getCheckin() {
		return checkin;
	}

	public void setCheckin(int checkin) {
		this.checkin = checkin;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setReviewerId(long reviewerId) {
		this.reviewerId = reviewerId;
	}

	public void setPropertyUrl(String propertyUrl) {
		this.propertyUrl = propertyUrl;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}



	public String getPropertyName() {
		return propertyName;
	}

	public String getDate() {
		return date;
	}

	public String getComment() {
		return comment;
	}

	public long getReviewerId() {
		return reviewerId;
	}

	public String getUserName() {
		return userName;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getUserUrl() {
		return userUrl;
	}

	public String getPropertyUrl() {
		return propertyUrl;
	}

	public long getPropertyId() {
		return propertyId;
	}

}