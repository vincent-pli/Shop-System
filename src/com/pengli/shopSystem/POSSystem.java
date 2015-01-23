package com.pengli.shopSystem;

import java.util.HashMap;
import java.util.Map;

import com.pengli.shopSystem.beans.Apple;
import com.pengli.shopSystem.beans.Badminton;
import com.pengli.shopSystem.beans.BuyTwoFreeOne;
import com.pengli.shopSystem.beans.CocoCola;
import com.pengli.shopSystem.beans.GoodsCategory;
import com.pengli.shopSystem.beans.PromotionInterface;

public class POSSystem {
	static Map<String, GoodsCategory> goodsList;
	static{
		PromotionInterface promotion = new BuyTwoFreeOne();
		goodsList = new HashMap<String, GoodsCategory>();
		CocoCola coco = new CocoCola();
		coco.setPromotion(promotion);
		goodsList.put(coco.getUPCCode(), coco);
		Badminton badminton = new Badminton();
		badminton.setPromotion(promotion);
		goodsList.put(badminton.getUPCCode(), badminton);
		Apple apple = new Apple();
		goodsList.put(apple.getUPCCode(), apple);
	}
	
	private void countGoods(String[] detailedList){
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
			if(POSSystem.goodsList.containsKey(UPCCode)){
				POSSystem.goodsList.get(UPCCode).addMore(number);
			}
		}		
	}
	
	private void applyPromotion(){
		for(Map.Entry<String, GoodsCategory> goods : POSSystem.goodsList.entrySet()){
			goods.getValue().applyPromotion();
		}
	}
	
	private void printDetailedList(){
		for(Map.Entry<String, GoodsCategory> goods : POSSystem.goodsList.entrySet()){
			System.out.println(goods.getValue());
		}
		System.out.println("--------------------");
	}
	
	private void printPromotionInfo(){
		for(Map.Entry<String, GoodsCategory> goods : POSSystem.goodsList.entrySet()){
			System.out.println(goods.getValue().printPromotionInfo());
		}
	}
	
	public void printInventory(String[] detailedList){
		this.countGoods(detailedList);
		this.applyPromotion();
		this.printDetailedList();
		this.printPromotionInfo();
	}
	
	public static void main(String[] args) {
		POSSystem pos = new POSSystem();
		String[] input = {"ITEM000001", "ITEM000001", "ITEM000001", "ITEM000001", "ITEM000001", "ITEM000003-2", "ITEM000005", "ITEM000005", "ITEM000005"};
		pos.printInventory(input);
	}
}
