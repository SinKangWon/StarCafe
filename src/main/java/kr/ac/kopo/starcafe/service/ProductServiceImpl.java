package kr.ac.kopo.starcafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.starcafe.dao.ProductDao;
import kr.ac.kopo.starcafe.model.Product;
import kr.ac.kopo.starcafe.pager.Pager;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao dao;

	@Override
	public List<Product> list(Pager pager) {
		int total = dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	public void add(Product item) {
		dao.add(item);
	}

	@Override
	public Product item(int id) {
		return dao.item(id);
	}

	@Override
	public void update(Product item) {
		dao.update(item);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public void dummy() {
		for(int index=1; index < 100; index++) {
			Product item = new Product();
			
			item.setName("제품명 " + index);
			item.setPrice(index * 100);
			item.setCategory(1);
			
			dao.add(item);
		}		
	}

	@Override
	public void init() {		
		while(true) {
			List<Product> list = dao.list(new Pager());
			
			if(list.size() < 1)
				break;
			
			for(Product item : list)
				dao.delete(item.getId());			
		}
	}

}
