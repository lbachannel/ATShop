package com.atteam.atshop.service;

import java.util.List;

import com.atteam.atshop.model.Order;
import com.fasterxml.jackson.databind.JsonNode;

public interface IOrderService {

	Order create(JsonNode orderData);
	
	// Khi đặt hàng thành công rồi. Sẽ hiển thị lại hóa đơn cho khách hàng
	Order findById(Long id);
	
	// Cho khách xem lại danh sách đơn hàng của chính khách đặt
	List<Order> findByUsername(String username);

}
