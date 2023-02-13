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
	private double cleanliness;
	private double communication;
	private double checkin;
	private double accuracy;
	private double location;
	private double value;

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

	public Review(long reviewerId, String userName, String userUrl, String comment, String date, double cleanliness,
			double communication, double checkin, double accuracy, double location, double value) {
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

	public double getCleanliness() {
		return cleanliness;
	}

	public void setCleanliness(double cleanliness) {
		this.cleanliness = cleanliness;
	}

	public double getCommunication() {
		return communication;
	}

	public void setCommunication(double communication) {
		this.communication = communication;
	}

	public double getCheckin() {
		return checkin;
	}

	public void setCheckin(double checkin) {
		this.checkin = checkin;
	}

	public double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	public double getLocation() {
		return location;
	}

	public void setLocation(double location) {
		this.location = location;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
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