package com.pengli.shopSystem.beans.promotion.imp;

import java.math.BigDecimal;

import com.pengli.shopSystem.beans.Purchase;
import com.pengli.shopSystem.beans.promotion.PromotionInterface;

public class BuyTwoFreeOne implements PromotionInterface {
	private String promotionInfo;
	
	@Override
	public Purchase applyPromation(Purchase onePurchase) {
		if(onePurchase.getNumber() >= 2){
			onePurchase.setTotalPrice(BigDecimal.valueOf(onePurchase.getTotalPrice()).subtract(BigDecimal.valueOf(onePurchase.getGoodsCategory().getPrice()).multiply(new BigDecimal("1"))).doubleValue());
		}
		
		this.promotionInfo = "Give as persent: " + onePurchase.getGoodsCategory().getName() + " 1.";
		return onePurchase;
	}

	@Override
	public String getPromotionInfo() {
		return this.promotionInfo;
	}

}
