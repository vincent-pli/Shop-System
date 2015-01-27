package com.pengli.shopSystem.beans;

import java.math.BigDecimal;

import com.pengli.shopSystem.beans.goods.GoodsCategory;

public class Purchase {
	private GoodsCategory goodsCategory;
	private int number;
	private double totalPrice;
	
	public Purchase(GoodsCategory goodsCategory){
		this.goodsCategory = goodsCategory;
	}
	
	public void buyMore(int num){
		double price = goodsCategory.getPrice();
		this.number += num;
		this.totalPrice = BigDecimal.valueOf(this.totalPrice).add(BigDecimal.valueOf(price).multiply(BigDecimal.valueOf(num))).doubleValue();
	}
	
	private void applyPromotion(){
		if(this.goodsCategory.getPromotion() != null){
			Purchase purchasewithPromotion = this.goodsCategory.getPromotion().applyPromation(this);
			this.number = purchasewithPromotion.getNumber();
			this.totalPrice = purchasewithPromotion.getTotalPrice();		
		}
	}
	
	public void settleAccounts(){
		this.applyPromotion();
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public GoodsCategory getGoodsCategory() {
		return goodsCategory;
	}
	
}
