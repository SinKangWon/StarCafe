package kr.ac.kopo.starcafe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.starcafe.model.Product;
import kr.ac.kopo.starcafe.pager.ProductPager;
import kr.ac.kopo.starcafe.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	final String path = "product/";
	
	@Autowired
	ProductService service;
	
	@GetMapping("/dummy")
	public String dummy() {
		service.dummy();
		
		return "redirect:list";
	}
	
	@GetMapping("/init")
	public String init() {
		service.init();
		
		return "redirect:list";
	}
	
	@GetMapping("/list")
	public String list(Model model, @ModelAttribute("pager") ProductPager pager) {
		List<Product> list = service.list(pager);
	
		model.addAttribute("list", list);
		
		return path + "list";	
	}
	
	@GetMapping("/add")
	public String add() {
		return path + "add";
	}
	
	@PostMapping("/add")
	public String add(Product item) {
		service.add(item);
		
		return "redirect:list";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model) {
		Product item = service.item(id);
		
		model.addAttribute("item", item);
		
		return path + "update";
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable int id, Product item) {
		item.setId(id);
		
		service.update(item);
		
		return "redirect:../list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		service.delete(id);
		
		return "redirect:../list";
	}
}
