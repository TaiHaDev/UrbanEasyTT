//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package model;

import java.math.BigDecimal;

public class Product {
    private long id;
    private String name;
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
	private String district;
    private String city;
    private String country;
    private double stars;
    private double lng;
    private double lat;
    private String url;
    private BigDecimal price;
    private long userId;
    private int categoryID;
    public Product(long id, String district, String city, String country, double stars, double lng, double lat, long userId) {
        this.id = id;
        this.district = district;
        this.city = city;
        this.country = country;
        this.stars = stars;
        this.lng = lng;
        this.lat = lat;
        this.userId = userId;
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
	
	
}