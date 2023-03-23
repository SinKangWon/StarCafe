package kr.ac.kopo.starcafe.dao;

import java.util.List;

import kr.ac.kopo.starcafe.model.Customer;
import kr.ac.kopo.starcafe.pager.Pager;

public interface CustomerDao {

	int total(Pager pager);

	List<Customer> list(Pager pager);

	void add(Customer item);

	Customer item(int id);

	void update(Customer item);

	void delete(int id);

}
