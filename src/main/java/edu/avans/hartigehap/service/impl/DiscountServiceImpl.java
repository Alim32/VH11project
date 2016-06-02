package edu.avans.hartigehap.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import edu.avans.hartigehap.domain.Discount;
import edu.avans.hartigehap.repository.discountRepository;
import edu.avans.hartigehap.service.DiscountService;

@Service("discountService")
@Repository
@Transactional
public class DiscountServiceImpl implements DiscountService {
	
	@Autowired
	private discountRepository discountRepository;

	@Override
	public List<Discount> findAll() {
		
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		return Lists.newArrayList(discountRepository.findAll(sort));
	}

	@Override
	public Discount save(Discount discount) {
		return discountRepository.save(discount);
	}

	@Override
	public void delete(String name) {
		discountRepository.delete(name);
		
	}

}
