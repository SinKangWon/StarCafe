package kr.ac.kopo.starcafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.starcafe.model.Customer;
import kr.ac.kopo.starcafe.pager.Pager;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	SqlSession sql;

	@Override
	public int total(Pager pager) {
		return sql.selectOne("customer.total", pager);
	}

	@Override
	public List<Customer> list(Pager pager) {
		return sql.selectList("customer.list", pager);
	}

	@Override
	public void add(Customer item) {
		sql.insert("customer.add", item);
	}

	@Override
	public Customer item(int id) {
		return sql.selectOne("customer.item", id);
	}

	@Override
	public void update(Customer item) {
		sql.update("customer.update", item);
	}

	@Override
	public void delete(int id) {
		sql.delete("customer.delete", id);
	}

}
