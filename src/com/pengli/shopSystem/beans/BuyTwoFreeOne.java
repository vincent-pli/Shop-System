package com.pengli.shopSystem.beans;

public class BuyTwoFreeOne implements PromotionInterface {

	@Override
	public GoodsCategory applyPromation(GoodsCategory goodsCategory) {
		if(goodsCategory.getNumber() >= 2){
			goodsCategory.setTotlePrice(goodsCategory.getTotlePrice() - goodsCategory.getPrice() * 1);
		}
		
		return goodsCategory;
	}

	@Override
	public String printPromotion(GoodsCategory goodsCategory) {
		return "Give as present: " + goodsCategory.getName() + " 1 " + goodsCategory.getUnit();
		
	}



}
