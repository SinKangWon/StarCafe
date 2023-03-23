package kr.ac.kopo.starcafe.service;

import java.util.List;

import kr.ac.kopo.starcafe.model.Product;
import kr.ac.kopo.starcafe.pager.Pager;

public interface ProductService {

	List<Product> list(Pager pager);

	void add(Product item);

	Product item(int id);

	void update(Product item);

	void delete(int id);

	void dummy();

	void init();

}
