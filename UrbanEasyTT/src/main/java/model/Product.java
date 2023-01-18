//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package model;

public class Product {
    private int id;
    private String district;
    private String city;
    private String country;
    private double stars;
    private double lng;
    private double lat;
    private String url;
    private double price;
    private int categoryID;
    public Product(int id, String district, String city, String country, double stars, double lng, double lat) {
        this.id = id;
        this.district = district;
        this.city = city;
        this.country = country;
        this.stars = stars;
        this.lng = lng;
        this.lat = lat;
    }
    public Product(int id, String district, String city, String country, double stars, double price , String url, int categoryID) {
        this.id = id;
        this.district = district;
        this.city = city;
        this.country = country;
        this.stars = stars;
        this.price = price;
        this.url = url;
        this.categoryID = categoryID;
    }

    public int getId() {
        return this.id;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	
}
