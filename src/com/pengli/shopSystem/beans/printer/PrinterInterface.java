package com.pengli.shopSystem.beans.printer;

import java.util.List;

import com.pengli.shopSystem.beans.Purchase;


public interface PrinterInterface {
	public void print(List<Purchase> purchaseList);
}
