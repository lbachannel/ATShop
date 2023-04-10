package com.atteam.atshop.service;

import com.atteam.atshop.model.Account;
import com.atteam.atshop.model.Favourite;
import com.atteam.atshop.model.Product;
import com.fasterxml.jackson.databind.JsonNode;

public interface IFavouriteService {
	
	// Thymeleaf
	Favourite create(Favourite favorite);
	
	Favourite create(JsonNode favouriteData);
	
	//Optional<Favourite> findByUsernameAndProductId(String username, String productId);
	
	Favourite findByUsernameAndProductId(String username, String productId);
	
	void delete(Favourite favourite);

	Favourite create(Account account, Product product);
	
	Favourite updateLikeOrUnlike(Account account, String productId);

}
