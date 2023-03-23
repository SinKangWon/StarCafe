package kr.ac.kopo.starcafe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.starcafe.model.Customer;
import kr.ac.kopo.starcafe.pager.Pager;
import kr.ac.kopo.starcafe.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {
	
	@Autowired
	CustomerService service;
	
	@GetMapping
	public Map<String, Object> list(Pager pager) {
		Map<String, Object> map = new HashMap<>();
		
		List<Customer> list = service.list(pager);
		
		map.put("list", list);
		map.put("pager", pager);
		
		return map;
	}
	
	@PostMapping
	public Customer add(@RequestBody Customer item) {
		service.add(item);
		
		return item;
	}
	
	@PutMapping
	public Customer update(@RequestBody Customer item) {
		service.update(item);
		
		return item;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);		
	}

}
