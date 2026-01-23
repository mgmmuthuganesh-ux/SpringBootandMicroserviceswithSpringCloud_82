package com.training.springmvcthymleafpos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

import com.training.springmvcthymleafpos.model.Product;

import jakarta.annotation.PostConstruct;

@Controller
public class ProductController {
	
	List<Product> products = new ArrayList<>();
	
	@PostConstruct
	public void intProdcuts() {
		products.add(new Product(1, "Mobile", "ordered", 1));
		products.add(new Product(2, "Garments", "delivered", 10));
		products.add(new Product(3, "Statinary", "retuned", 20));
		products.add(new Product(4, "HomeNeeds", "ordered", 70));
		products.add(new Product(5, "Utilities", "shipped", 30));
	}
	
	@RequestMapping({"/","/products"})
	public ModelAndView getProducts() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList",products);
		mav.setViewName("products");
		return mav;
	}
	
	@RequestMapping("/add")
	public ModelAndView addProdcut() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("prd",new Product());
		mav.setViewName("addproduct");
		return mav;
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String saveProduct(Product prd) {
		Product existingprd=  products.stream()
				.filter(p->p.getPid()==prd.getPid()).findFirst().orElse(null);
		if(existingprd==null) {
			prd.setPid(products.size()+1);
			products.add(prd);
		}else {
			products.stream().filter(p->p.getPid()==prd.getPid()).findFirst()
			.ifPresent(exp->{
				exp.setName(prd.getName());
				exp.setQty(prd.getQty());
				exp.setStatus(prd.getStatus());
			});
			
		}
		return "redirect:/products";
	}
	
	@RequestMapping("/update/{pid}")
	public ModelAndView updateProducts(@PathVariable Integer pid) {
		Product prd = products.stream().filter(p->p.getPid()==pid).findFirst()
				.orElseThrow(()->new RuntimeException("PRODUCT NOT FOUND" + pid));
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("prd",prd);
		mav.setViewName("addproduct");
		return mav;
	}
	
	@RequestMapping("/delete/{pid}")
	public String deleteProducts(@PathVariable Integer pid) {
		Product prd = products.stream().filter(p->p.getPid()==pid).findFirst()
				.orElseThrow(()->new RuntimeException("PRODUCT NOT FOUND" + pid));
		
		products.remove(prd);
		return "redirect:/products";
	}
	
	@RequestMapping("/search")
	public ModelAndView searchProduct(@RequestParam String name) {
		intProdcuts();
		Product prd = products.stream().filter(p->p.getName().toLowerCase().contains(name)).findFirst()
				.orElseThrow(()->new RuntimeException("PRODUCT NOT FOUND " + name));
		 products = new ArrayList<>();
		 products.add(prd);
		ModelAndView mav = new ModelAndView();
		mav.addObject("productList",products);
		mav.setViewName("products");
		return mav;
	}
	
}
