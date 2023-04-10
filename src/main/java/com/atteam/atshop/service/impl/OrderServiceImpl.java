package com.atteam.atshop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atteam.atshop.dao.IOrderDAO;
import com.atteam.atshop.dao.IOrderDetailDAO;
import com.atteam.atshop.model.Order;
import com.atteam.atshop.model.OrderDetail;
import com.atteam.atshop.service.IOrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	IOrderDAO dao;
	
	@Autowired
	IOrderDetailDAO orderDetailDao;
	
	// Tạo order (đơn hàng mới của khách đặt)
	@Override
	public Order create(JsonNode orderData) {
		/*
		 * 	ObjectMapper: chuyển đổi Json thành đối tượng
		 * 
		 * */
		ObjectMapper mapper = new ObjectMapper();
		
		Order order = mapper.convertValue(orderData, Order.class);
		
		dao.save(order);
		
		/*
		 * 	TypeReference : được sử dụng để giữ thông tin về kiểu của đối tượng và giúp cho việc ánh xạ các dữ liệu
		 *  trở nên dễ dàng hơn trong quá trình chuyển đổi.
		 */		
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
			
		/*
		 * 	convertValue : đọc Json chuyển sang list	
		 * 
		 * 	mapper.convertValue(orderData.get("orderDetail"), type) : sau khi lấy ra
		 * 
		 * 	sẽ có được 1 list orderDetails
		 * 
		 * 	saveAll : lưu nhiều data cùng 1 lúc
		 * 
		 * */
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		
		orderDetailDao.saveAll(details);
		
		return order;
	}
	
	@Override
	public Order findById(Long id) {
		return dao.findById(id).get();
	}
	
	// Cho khách xem lại danh sách đơn hàng của chính khách đặt
	@Override
	public List<Order> findByUsername(String username) {
		return dao.findByUsername(username);
	}

}
