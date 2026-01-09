package com.training.billmanagerapp;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

@Component
public class Menu {
	
	public void displayItems(List itemList) {
		//itemList.stream().forEach(System.out::println);
		IntStream.range(0, itemList.size())
		.forEach(i->System.out.println((i+1)+"."+itemList.get(i)));
	}
	

	public List<Item> getBreakfast(){
		List breakfeast= List.of(new Item("IDLI", 30),new Item("WADA", 40),new Item("DOSA", 50));
		displayItems(breakfeast);
		return breakfeast;
	}
	public List<Item> getLunch(){
		List lunch= List.of(new Item("THALI", 100),new Item("COMBO", 70),new Item("BIRIYANI", 150));
		displayItems(lunch);
		return lunch;
	}
	public List<Item> getBeaverages(){
		List beaverages= List.of(new Item("COFFE", 20),new Item("TEA", 10),new Item("MILK", 25));
		displayItems(beaverages);
		return beaverages;
	}
}
