package com.pengli.shopSystem.beans.promotion;

import com.pengli.shopSystem.beans.Purchase;

public interface PromotionInterface {
	public Purchase applyPromation(Purchase onePurchase);
	
	public String getPromotionInfo();
	
}
