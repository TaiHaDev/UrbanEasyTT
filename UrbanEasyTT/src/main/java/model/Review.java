package model;

public class Review {
	private final String propertyName;
	private final String date;
	private final String comment;
	private final long reviewerId;
	private final String propertyUrl;
	private final long propertyId;
	private final String userName;
	private final String city;
	private final String country;
	private final String userUrl;
	public Review(String propertyName, String date, String comment, String propertyUrl, String userUrl, long propertyId, long reviewerId, String userName, String city, String country) {
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