package com.yc.dao;

import com.yc.bean.SaleOrder;
import com.yc.bean.SaleOrderLine;

public interface SaleOrderDao {
	/**
	 * 根据订单号查订单，包括订单项
	 * @param id
	 * @return
	 */
	public SaleOrder getWithLines(Long id);
	
	/**
	 * 添加订单
	 * @param o
	 */
	public void add(SaleOrder o);
	
	/**
	 * 添加订单详情
	 * @param o
	 */
	public void addDetail(SaleOrderLine o);
	
	/**
	 * 根据编号删除订单详情
	 * @param saleOrderLine
	 */
	public void delOrderLine(SaleOrderLine saleOrderLine);
	
	public void updateDetail(SaleOrderLine o);
}
