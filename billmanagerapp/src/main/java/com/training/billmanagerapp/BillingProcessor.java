package com.training.billmanagerapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BillingProcessor {
	
	private Integer totalBill = 0;
	
	private List<Item> selectedItems = new ArrayList<Item>();
	
	
	public void showMenu() {
		System.out.println("1. BREAKFAST");
		System.out.println("2. LUNCH");
		System.out.println("3. BEVERAGES");
	}

	public List<Item> selectItem(Item item){
		selectedItems.add(item);
		return selectedItems;
	}
	
	public void displayselected() {
		selectedItems.stream().forEach(System.out::println);
	}
	
	/*
	 * public Integer totlaBill() {
	 *  for (Item item : selectedItems) { 
	 *  	totalBill = totalBill+item.getPrice(); 
	 *  } return totalBill; 
	 * }
	 */
	
	public Integer totalBill() {
		return selectedItems.stream().mapToInt(Item::getPrice).sum();
	}
	
	public void checkout() {
		System.out.println("1. ADD MORE");
		if(selectedItems.size()>0) {
			System.out.println("2. CHECKOUT");
		}
	}
}
