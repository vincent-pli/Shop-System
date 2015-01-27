package com.pengli.shopSystem.beans.goods;

import com.pengli.shopSystem.beans.promotion.PromotionInterface;

public class GoodsCategory {
	protected String UPCCode;
	protected String name;
	protected double price;
	protected String unit = "";
	protected PromotionInterface promotion;
	
	
	public String getUPCCode() {
		return UPCCode;
	}

	public String getUnit() {
		return unit;
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
