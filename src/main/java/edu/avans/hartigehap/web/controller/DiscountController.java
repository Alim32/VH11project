package edu.avans.hartigehap.web.controller;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import edu.avans.hartigehap.domain.*;
import edu.avans.hartigehap.service.*;
import edu.avans.hartigehap.web.form.Message;

@Controller
@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
@Slf4j
public class DiscountController {

	@Autowired
	private DiscountService discountservice;
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping(value = "/restaurants/{restaurantName}/discount", method = RequestMethod.GET)
	public String showDiscount(@PathVariable("restaurantName") String restaurantName, Model uiModel){
        Collection<Restaurant> restaurants = restaurantService.findAll();
        uiModel.addAttribute("restaurants", restaurants);
        Restaurant restaurant = restaurantService.fetchWarmedUp(restaurantName);
        uiModel.addAttribute("restaurant", restaurant);
		
        List<Discount> allDiscounts = discountservice.findAll();
        uiModel.addAttribute("allDiscounts", allDiscounts);
                
		return "hartigehap/discount";
	}
}
