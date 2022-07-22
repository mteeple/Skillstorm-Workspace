package com.skillstorm.data;

import java.util.LinkedList;
import java.util.List;

import com.skillstorm.models.Product;

public class FakeProductDAO {
	LinkedList<Product> data = new LinkedList<>();
	
	public List<Product> findAll(){
		return data;
	}
	
	public void add(Product product) {
		data.add(product);
	}
}
