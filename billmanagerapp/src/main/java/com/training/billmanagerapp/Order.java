package com.training.billmanagerapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Order {

    private final BillmanagerappApplication billmanagerappApplication;
	
	@Autowired
	private Menu menu;
	
	@Autowired
	private BillingProcessor billing;

    Order(BillmanagerappApplication billmanagerappApplication) {
        this.billmanagerappApplication = billmanagerappApplication;
    }

	public void placeOrder() {
		
		while(true) {
			System.out.println("*".repeat(7)+" MENU ITEMS "+"*".repeat(7));
			billing.showMenu();
			System.out.println("*".repeat(7)+" CHOOSE OPTION "+"*".repeat(7));
			Scanner sc = new Scanner(System.in);
			switch (sc.nextInt()) {
			case 1: {
				List<Item> breakfast = menu.getBreakfast();
				System.out.println("*".repeat(7)+" SELECT BREAKFAST "+"*".repeat(7)); 
				int breakfastoption = sc.nextInt();
				Item item = breakfast.get(breakfastoption-1);
				billing.selectItem(item);
				System.out.println("*".repeat(7)+"SELECTED ITEMS"+"*".repeat(7));
				billing.displayselected();
				billing.checkout();
				if(sc.nextInt()==2) {
					System.out.println("*".repeat(7)+"TOTAL BILL : "+ billing.totalBill()+"*".repeat(7));
				return;
				}
				break;
			}
			case 2: {
				List<Item> lunch = menu.getLunch();
				System.out.println("*".repeat(7)+" SELECT BREAKFAST "+"*".repeat(7)); 
				int breakfastoption = sc.nextInt();
				Item item = lunch.get(breakfastoption-1);
				billing.selectItem(item);
				System.out.println("ItemSelected");
				billing.displayselected();
				billing.checkout();
				if(sc.nextInt()==2) {
					System.out.println("*".repeat(7)+"TOTAL BILL : "+ billing.totalBill()+"*".repeat(7));
				return;
				}
				break;
			}
			case 3: {
				List<Item> bevarages = menu.getBeaverages();
				System.out.println("*".repeat(7)+" SELECT BREAKFAST "+"*".repeat(7)); 
				int breakfastoption = sc.nextInt();
				Item item = bevarages.get(breakfastoption-1);
				billing.selectItem(item);
				System.out.println("*".repeat(7)+"ItemSelected"+"*".repeat(7));
				billing.displayselected();
				billing.checkout();
				if(sc.nextInt()==2) {
					System.out.println("*".repeat(7)+"TOTAL BILL : "+ billing.totalBill()+"*".repeat(7));
				return;
				}
				break;
			}
			default:
				System.out.println("WRONG OPTION");
			}
		}
		
	}
	
	
}
