package edu.avans.hartigehap.service;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import edu.avans.hartigehap.domain.MenuItem;
import edu.avans.hartigehap.domain.Order;
import edu.avans.hartigehap.domain.OrderItem;

public class RegularHandler extends MenuItemHandler{
	
	public Collection<OrderItem> orderitems = new ArrayList<OrderItem>();
	public Collection<MenuItem> menuitems = new ArrayList<MenuItem>();
	public double price = 0;
	int quantity = 1;
	
	@Override
	public double getPrice(Collection<Order> order) throws HeadlessException {
			Iterator<Order> orderIterator = order.iterator();
			
			while(orderIterator.hasNext()){
				orderitems = orderIterator.next().getOrderItems();
				
				for(OrderItem orderitem : orderitems){
					if(orderitem.getMenuItem().discount == null){		
						menuitems.add(orderitem.getMenuItem());
					}else{
						price += m_successor.getPrice(order);
					}
				}
				
				for(MenuItem item : menuitems){
						price += item.getPrice() * quantity;
				}				
				orderIterator.next();
			}
			return price;
	}
}
