package day3.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("productDaoByAnnotation")
public class MyProductDaoImpl {
	private String name;
	private int price;
	
	public String getName() {
		return name;
	}
	@Value("andy")
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(@Value("100") int price) {
		this.price = price;
	}
	
	
}
