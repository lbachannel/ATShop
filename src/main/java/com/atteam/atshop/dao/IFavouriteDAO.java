package com.atteam.atshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atteam.atshop.model.Favourite;


public interface IFavouriteDAO extends JpaRepository<Favourite, Integer>{
	
	@Query(value = "select * from Favourites where Username = ?1 and ProductId = ?2", nativeQuery = true)
	Favourite findByUsernameAndProductId(String username, String productId);
	
}
