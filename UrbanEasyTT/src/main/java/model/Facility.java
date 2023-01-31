package model;

public class Facility {
	private int id;
	private String name;
	private String svg;
	
	public Facility(int id, String name, String svg) {
		super();
		this.id = id;
		this.name = name;
		this.svg = svg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSvg() {
		return svg;
	}

	public void setSvg(String svg) {
		this.svg = svg;
	}
	
	
}
