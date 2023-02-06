package model.classes;

public class Component 
{
	// Instance variable for description of each item
	private String category;
	private String name;
	private String price;
	private String spec1;
	private String spec2;
	private String spec3;
	private String imageSrc;
	private String link;
	

	// Getters and Setter methods
	public String getCategory() { 
		return category; 
	}
	
	public void setCategory(String category) { 
		this.category = category; 
	}
	
	public String getName() { 
		return name; 
	}
	
	public void setName(String name) { 
		this.name = name;
	}
	
	public String getPrice() {	
		return price; 
	}
	
	public void setPrice(String price) { 
		this.price = price; 
	}
	
	public String getSpec1() { 
		return spec1; 
	}
	
	public void setSpec1(String spec1) { 
		this.spec1 = spec1; 
	}
	
	public String getSpec2() { 
		return spec2; 
	}
	
	public void setSpec2(String spec2) { 
		this.spec2 = spec2; 
	}
	
	public String getSpec3() { 
		return spec3;
	}
	
	public void setSpec3(String spec3) { 
		this.spec3 = spec3;
	}
	
	public String getImgSrc() {	
		return imageSrc; 
	}
	
	public void setImgSrc(String imgSrc) { 
		this.imageSrc = imgSrc; 
	}
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
