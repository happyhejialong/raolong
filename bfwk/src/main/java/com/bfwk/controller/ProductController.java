package com.bfwk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bfwk.common.WkResponse;
import com.bfwk.model.Product;
import com.bfwk.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	@PostMapping("/add")
	@ResponseBody
	public WkResponse<Product> add(Product product){
		WkResponse<Product> wr=new WkResponse<Product>();
		try{
			productService.add(product);
		}catch(Exception e){
			e.printStackTrace();
			wr.setCode(e.hashCode());
			wr.setMsg(e.getMessage());
		}
		return wr;
	}
	@GetMapping("/list")
	public String list(@RequestParam(defaultValue="1")int pageIndex,Model model){
		List<Product> prods=productService.list(pageIndex);
		model.addAttribute("productList", prods);
		return "product_list";
	}
}
