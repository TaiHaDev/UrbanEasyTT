package model;

import java.util.Date;

public class Booking {
	private long id;
	private long propertyId;
	private long hostId;
	private String propertyUrl;
	private String avatarUrl;
	private String name;
	private String startDate;
	private String endDate;
	private String address;
	private String status;
	private int guest;
	private String hostName;
	private String hostPhoneNumber;
	private String bookingDate;
	private String hostEmail;
	public long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}

	public long getHostId() {
		return hostId;
	}

	public void setHostId(long hostId) {
		this.hostId = hostId;
	}
	private String paidAmount;
	private boolean isReviewed;
	private int length;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Booking(long id, String propertyUrl, String startDate, String endDate, String address, String status, String name) {
		super();
		this.id = id;
		this.propertyUrl = propertyUrl;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
		this.status = status;
		this.name = name;
	}
	
	


	@Override
	public String toString() {
		return "Booking [id=" + id + ", propertyId=" + propertyId + ", hostId=" + hostId + ", propertyUrl="
				+ propertyUrl + ", avatarUrl=" + avatarUrl + ", name=" + name + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", address=" + address + ", status=" + status + ", guest=" + guest
				+ ", hostName=" + hostName + ", hostPhoneNumber=" + hostPhoneNumber + ", bookingDate=" + bookingDate
				+ ", hostEmail=" + hostEmail + ", paidAmount=" + paidAmount + ", isReviewed=" + isReviewed + ", length="
				+ length + "]";
	}

	public Booking(long id, long propertyId, long hostId, String avatarUrl, String propertyUrl, String name, String startDate, String endDate, String address,
			String status, int guest, String hostName, String hostPhoneNumber, String bookingDate, String hostEmail,
			String paidAmount, boolean isReviewed, int length) {
		super();
		this.id = id;
		this.propertyId = propertyId;
		this.hostId = hostId;
		this.propertyUrl = propertyUrl;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
		this.status = status;
		this.guest = guest;
		this.hostName = hostName;
		this.hostPhoneNumber = hostPhoneNumber;
		this.bookingDate = bookingDate;
		this.hostEmail = hostEmail;
		this.paidAmount = paidAmount;
		this.isReviewed = isReviewed;
		this.length = length;
		this.avatarUrl = avatarUrl;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public int getGuest() {
		return guest;
	}

	public void setGuest(int guest) {
		this.guest = guest;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getHostPhoneNumber() {
		return hostPhoneNumber;
	}

	public void setHostPhoneNumber(String hostPhoneNumber) {
		this.hostPhoneNumber = hostPhoneNumber;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getHostEmail() {
		return hostEmail;
	}

	public void setHostEmail(String hostEmail) {
		this.hostEmail = hostEmail;
	}

	public String getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}

	public boolean isReviewed() {
		return isReviewed;
	}

	public void setReviewed(boolean isReviewed) {
		this.isReviewed = isReviewed;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPropertyUrl() {
		return propertyUrl;
	}
	public void setPropertyUrl(String propertyUrl) {
		this.propertyUrl = propertyUrl;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	

	
}
