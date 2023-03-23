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

import kr.ac.kopo.starcafe.model.Product;
import kr.ac.kopo.starcafe.pager.ProductPager;
import kr.ac.kopo.starcafe.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
	
	@Autowired
	ProductService service;
	
	@GetMapping
	public Map<String, Object> list(ProductPager pager) {
		HashMap<String, Object> map = new HashMap<>();
		
		List<Product> list = service.list(pager);
		
		map.put("list", list);
		
		map.put("pager", pager);
		
		return map;
	}
	
	@PostMapping
	public Product add(@RequestBody Product item) {
		service.add(item);
		
		return item;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}
	
	@PutMapping
	public Product update(@RequestBody Product item) {
		service.update(item);
		
		return item;
	}

}
