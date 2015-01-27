package com.pengli.shopSystem.beans.printer.imp;

import java.util.List;

import com.pengli.shopSystem.beans.Purchase;
import com.pengli.shopSystem.beans.printer.PrinterInterface;


public class PrintTextImp implements PrinterInterface {
	private final String SEPARATOR = "-------------------------";
	@Override
	public void print(List<Purchase> purchaseList) {
		StringBuffer purchaseInfo = new StringBuffer();
		StringBuffer promotionInfo = new StringBuffer();
		for(Purchase purchase : purchaseList){
			String pruchaseStr = "Catetory: " + purchase.getGoodsCategory().getName() + ", Number: " + purchase.getNumber() + ", Price: " + purchase.getGoodsCategory().getPrice() + ", Total Price: " + purchase.getTotalPrice() + "\n";
			purchaseInfo.append(pruchaseStr);
			if(purchase.getGoodsCategory().getPromotion() != null){
				promotionInfo.append(purchase.getGoodsCategory().getPromotion().getPromotionInfo() + "\n");
			}
		}
		
		System.out.println(purchaseInfo.toString());
		System.out.println(this.SEPARATOR);
		System.out.println(promotionInfo.toString());
	}

}
