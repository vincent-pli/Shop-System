package com.pengli.shopSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pengli.shopSystem.beans.Purchase;
import com.pengli.shopSystem.beans.goods.Apple;
import com.pengli.shopSystem.beans.goods.Badminton;
import com.pengli.shopSystem.beans.goods.CocoCola;
import com.pengli.shopSystem.beans.goods.GoodsCategory;
import com.pengli.shopSystem.beans.printer.PrinterInterface;
import com.pengli.shopSystem.beans.printer.imp.PrintTextImp;
import com.pengli.shopSystem.beans.promotion.imp.BuyTwoFreeOne;

public class POSSystem {
	static Map<String, GoodsCategory> goodsList;
	static{
		//Set promotion policy	
		goodsList = new HashMap<String, GoodsCategory>();
		CocoCola coco = new CocoCola();
		coco.setPromotion(new BuyTwoFreeOne());
		goodsList.put(coco.getUPCCode(), coco);
		Badminton badminton = new Badminton();
		badminton.setPromotion(new BuyTwoFreeOne());
		goodsList.put(badminton.getUPCCode(), badminton);
		Apple apple = new Apple();
		goodsList.put(apple.getUPCCode(), apple);
	}
	
	private PrinterInterface print;
	
	public void printInventory(String[] detailedList){
		List<Purchase> purchaseList = this.parseUPCs(detailedList);
		applyPromotion(purchaseList);
		this.print.print(purchaseList);
	}
	
	public void setPrint(PrinterInterface print) {
		this.print = print;
	}
	
	private void applyPromotion(List<Purchase> purchaseList){
		for(Purchase purchase : purchaseList){
			purchase.settleAccounts();
		}
	}
	
	private List<Purchase> parseUPCs(String[] detailedList){
		Map<String, Purchase> purchaseList = new HashMap<String, Purchase>();
		
		for(String item : detailedList){
			String UPCCode;
			int number;
			if(item.indexOf("-") != -1){
				UPCCode = item.split("-")[0];
				number = Integer.valueOf(item.split("-")[1]);
			}
			else{
				UPCCode = item;
				number = 1;
			}
			buildPurchaseList(UPCCode, number, purchaseList);
		}	
		return new ArrayList<Purchase>(purchaseList.values());
	}
	
	private void buildPurchaseList(String UPCCode, int number, Map<String, Purchase> purchaseList){
		if(POSSystem.goodsList.containsKey(UPCCode)){
			GoodsCategory goods = POSSystem.goodsList.get(UPCCode);
			if(purchaseList.containsKey(UPCCode)){
				purchaseList.get(UPCCode).buyMore(number);
			}
			else{
				Purchase purchase = new Purchase(goods);
				purchase.buyMore(number);
				purchaseList.put(UPCCode, purchase);
			}
		}
	}

	public static void main(String[] args) {
		POSSystem pos = new POSSystem();
		PrinterInterface print = new PrintTextImp();
		pos.setPrint(print);
		String[] input = {"ITEM000001", "ITEM000001", "ITEM000001", "ITEM000001", "ITEM000001", "ITEM000003-2", "ITEM000005", "ITEM000005", "ITEM000005"};
		
		pos.printInventory(input);
		
	}
}
