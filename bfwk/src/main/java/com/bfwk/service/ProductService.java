package com.bfwk.service;

import java.util.List;

import com.bfwk.exception.WkException;
import com.bfwk.model.Product;

public interface ProductService {

	void add(Product product) throws WkException ;

	List<Product> list(int pageIndex);


}
