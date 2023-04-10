package com.atteam.atshop.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atteam.atshop.model.Product;
import com.atteam.atshop.service.IProductService;

@Controller
public class FavouriteController {
	
	@Autowired
	IProductService productService;
	
	@RequestMapping("/favourite/view")
	public String view(Model model, HttpServletRequest request, @RequestParam(defaultValue = "0") int page) {
		String username = request.getRemoteUser();
		List<Product> list = productService.findAllProductCustomerLike(username);
		
		/*
		 * 		pageSize   : số lượng sản phẩm trên 1 trang
		 * 		maxPages : Tổng số trang
		 * 		startIndex : chỉ số bắt đầu của sản phẩm cần hiển thị trên trang hiện tại
		 */
		
		int pageSize = 10;
		int maxPages = (int) Math.ceil((double) list.size() / pageSize); 
		int startIndex = (page - 1) * pageSize; 
		// dssp cần hiển thị
		List<Product> productsOnPage = list;
		
		model.addAttribute("favourite", productsOnPage);
		model.addAttribute("currentPage", page);
		model.addAttribute("maxPages", maxPages);

		return "web/favourite/view";
	}
}
