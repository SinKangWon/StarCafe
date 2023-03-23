package kr.ac.kopo.starcafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.starcafe.model.Product;
import kr.ac.kopo.starcafe.pager.Pager;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public List<Product> list(Pager pager) {
		return sql.selectList("product.list", pager);
	}

	@Override
	public void add(Product item) {
		sql.insert("product.add", item);

	}

	@Override
	public Product item(int id) {		
		return sql.selectOne("product.item", id);
	}

	@Override
	public void update(Product item) {
		sql.update("product.update", item);
	}

	@Override
	public void delete(int id) {
		sql.delete("product.delete", id);
	}

	@Override
	public int total(Pager pager) {		
		return sql.selectOne("product.total", pager);
	}
}
