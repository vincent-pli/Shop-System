package com.pengli.shopSystem.beans;

public class GoodsCategory {
	protected String UPCCode;
	protected String name;
	protected double price;
	protected String unit = "";
	protected double totlePrice;
	protected int number;
	protected PromotionInterface promotion;
	
	
	public void addMore(int num){
		this.number += num;
		this.totlePrice += this.price * num;
	}
	
	public void applyPromotion(){
		if(this.promotion != null){
			this.totlePrice = this.promotion.applyPromation(this).getTotlePrice();
		}
	}
	
	public String printPromotionInfo(){
		if(this.promotion != null){
			return this.promotion.printPromotion(this);
		}
		return "";
	}
	
	public String toString(){
		return "Category: " + this.name + " Number: " + this.number + " Price: " + this.price + " Total Price:" + this.totlePrice;
	}
	
	public String getUPCCode() {
		return UPCCode;
	}

	public double getTotlePrice() {
		return totlePrice;
	}

	public void setTotlePrice(double totlePrice) {
		this.totlePrice = totlePrice;
	}

	public String getUnit() {
		return unit;
	}

	public int getNumber() {
		return number;
	}

	public PromotionInterface getPromotion() {
		return promotion;
	}

	public void setPromotion(PromotionInterface promotion) {
		this.promotion = promotion;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
	
}
