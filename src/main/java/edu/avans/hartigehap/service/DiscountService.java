package edu.avans.hartigehap.service;

import java.util.List;

import edu.avans.hartigehap.domain.Discount;

public interface DiscountService {

	List<Discount> findAll();
	
	Discount save(Discount discount);
	
	void delete(String name);
}
