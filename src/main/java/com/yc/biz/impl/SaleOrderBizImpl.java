package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.SaleOrder;
import com.yc.bean.SaleOrderLine;
import com.yc.biz.SaleOrderBiz;
import com.yc.dao.SaleOrderDao;

@Service
@Transactional(readOnly=false,isolation=Isolation.DEFAULT,rollbackForClassName= {
		"java.lang.RunTimeException"},propagation=Propagation.REQUIRED)
public class SaleOrderBizImpl implements SaleOrderBiz {
	@Resource(name="saleOrderDaoMybatisImpl")
	private SaleOrderDao saleOrderDao;
	
	
	@Override
	@Transactional(readOnly=true)
	public SaleOrder getWithLines(Long id) {
		return this.saleOrderDao.getWithLines(id);
	}

	@Override
	public void add(SaleOrder o) {
		this.saleOrderDao.add(o);
	}

	@Override
	public void addDetail(SaleOrderLine o) {
		boolean flag=false;
		//1. 根据   订单编号查订单，以获得这个订单的订单详情.
		SaleOrder so=getWithLines(  o.getSaleOrder().getOdrId() );
		//有详情，则看详情中的产品是否是当前这个  要下订的产品，如果是，则加数量。 
		if(   so!=null&& so.getSaleOrderLines()!=null&& so.getSaleOrderLines().size()>0 ){
			List<SaleOrderLine> list=so.getSaleOrderLines();
			for(  SaleOrderLine sol:list){
				//页面中form表单中的ProductName等于 当前订单的所有详情中的某一个详情产品名
				if(  sol.getOdlProductName().equals(o.getOdlProductName())){
					//如果产品已经存在，则取出订单详情编号，及更改数量
					//更新
					o.setOdlId(   sol.getOdlId() );
					o.setOdlProductCount(   o.getOdlProductCount()+sol.getOdlProductCount() );
					flag=true;
					break;
				}
			}
		}
		if( flag){
			this.saleOrderDao.updateDetail(o);
		}else{
			this.saleOrderDao.addDetail(o);
		}
	}

	@Override
	public void delOrderLine(SaleOrderLine saleOrderLine) {
		this.saleOrderDao.delOrderLine(saleOrderLine);
	}

	@Override
	public void updateDetail(SaleOrderLine o) {
		this.saleOrderDao.updateDetail(o);
	}

}
