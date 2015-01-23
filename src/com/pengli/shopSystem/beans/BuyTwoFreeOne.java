package com.pengli.shopSystem.beans;

import java.math.BigDecimal;

public class BuyTwoFreeOne implements PromotionInterface {

	@Override
	public GoodsCategory applyPromation(GoodsCategory goodsCategory) {
		if(goodsCategory.getNumber() >= 2){
			goodsCategory.setTotlePrice(BigDecimal.valueOf(goodsCategory.getTotlePrice()).subtract(BigDecimal.valueOf(goodsCategory.getPrice()).multiply(new BigDecimal("1"))).doubleValue());
		}
		
		return goodsCategory;
	}

	@Override
	public String printPromotion(GoodsCategory goodsCategory) {
		return "Give as present: " + goodsCategory.getName() + " 1 " + goodsCategory.getUnit();
		
	}



}
