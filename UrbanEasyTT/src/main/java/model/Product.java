//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package model;

import java.math.BigDecimal;

public class Product {
	private long id;
	private String name;
	private String district;
	private String city;
	private String country;
	private double stars;
	private double lng;
	private double lat;
	private String url;
	private BigDecimal price;
	private long userId;
	private int view;
	private String status;
	private String dayAvailable;
	private String dayAvailableNext;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNeighbourhoodOverview() {
		return neighbourhoodOverview;
	}

	public void setNeighbourhoodOverview(String neighbourhoodOverview) {
		this.neighbourhoodOverview = neighbourhoodOverview;
	}

	private int categoryID;
	private int bedroom;
	private int guest;
	private int bed;
	private int bath;
	private String description;
	private String neighbourhoodOverview;

    // contrustor for product-detail
    public Product(long id, String name, String district, String city, String country, double stars, double lng, double lat, long userId, int guest, int bedroom, int bed, int bath, BigDecimal price, String description, String neighbourhoodOverview) {
        this.id = id;
        this.district = district;
        this.city = city;
        this.country = country;
        this.stars = stars;
        this.lng = lng;
        this.lat = lat;
        this.userId = userId;
        this.guest = guest;
        this.bedroom = bedroom;
        this.bed = bed;
        this.bath = bath;
        this.name = name;
        this.price = price;
        this.description = description;
        this.neighbourhoodOverview = neighbourhoodOverview;
    }
    // constructor for searched property
    public Product(long id, String name, int bed, String district, String city, String country, double stars, String url, BigDecimal price, double lng, double lat ) {
    	this.id = id;
    	this.name = name;
    	this.bed = bed;
    	this.district = district;
    	this.city = city;
    	this.country = country;
    	this.stars = stars;
    	this.url = url;
    	this.price = price;
    	this.lng = lng;
    	this.lat = lat;
    }

    public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNeighbourhoodOverview() {
		return neighbourhoodOverview;
	}
	public void setNeighbourhoodOverview(String neighbourhoodOverview) {
		this.neighbourhoodOverview = neighbourhoodOverview;
	}
    public int getBedroom() {
	// contrustor for product-detail
	public Product(long id, String name, String district, String city, String country, double stars, double lng,
			double lat, long userId, int guest, int bedroom, int bed, int bath, BigDecimal price, String description,
			String neighbourhoodOverview) {
		this.id = id;
		this.district = district;
		this.city = city;
		this.country = country;
		this.stars = stars;
		this.lng = lng;
		this.lat = lat;
		this.userId = userId;
		this.guest = guest;
		this.bedroom = bedroom;
		this.bed = bed;
		this.bath = bath;
		this.name = name;
		this.price = price;
		this.description = description;
		this.neighbourhoodOverview = neighbourhoodOverview;
	}

	public int getBedroom() {
		return bedroom;
	}

	public void setBedroom(int bedroom) {
		this.bedroom = bedroom;
	}
	public int getGuest() {
		return guest;
	}
	public void setGuest(int guest) {
		this.guest = guest;
	}
	public int getBed() {
		return bed;
	}
	public void setBed(int bed) {
		this.bed = bed;
	}
	public int getBath() {
		return bath;
	}
	public void setBath(int bath) {
		this.bath = bath;
	}
	public Product(long id, String district, String city, String country, double stars, BigDecimal price , String url, int categoryId) {
        this.id = id;
        this.district = district;
        this.city = city;
        this.country = country;
        this.stars = stars;
        this.price = price;
        this.url = url;
        this.categoryID= categoryId;
    }
    public Product(long id, String name, String url, double stars) {
    	this.id = id;
    	this.name = name;
    	this.url = url;
    	this.stars = stars;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getStars() {
        return this.stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDayAvailable() {
		return dayAvailable;
	}

	public void setDayAvailable(String dayAvailable) {
		this.dayAvailable = dayAvailable;
	}

	public String getDayAvailableNext() {
		return dayAvailableNext;
	}

	public void setDayAvailableNext(String dayAvailableNext) {
		this.dayAvailableNext = dayAvailableNext;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", district=" + district + ", city=" + city + ", country="
				+ country + ", stars=" + stars + ", lng=" + lng + ", lat=" + lat + ", url=" + url + ", price=" + price
				+ ", userId=" + userId + ", categoryID=" + categoryID + "]";
	}
	
	
}