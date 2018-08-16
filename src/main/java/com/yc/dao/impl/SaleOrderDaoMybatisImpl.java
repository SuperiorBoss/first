package com.yc.dao.impl;


import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.SaleOrder;
import com.yc.bean.SaleOrderLine;
import com.yc.dao.SaleOrderDao;

@Repository
public class SaleOrderDaoMybatisImpl implements SaleOrderDao {

	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public SaleOrder getWithLines(Long id) {
	return	this.sqlSession.selectOne("com.yc.dao.SaleOrderDaoMapper.getWithLines", id);
	}

	@Override
	public void add(SaleOrder o) {
		this.sqlSession.insert("com.yc.dao.SaleOrderDaoMapper.add",o);
	}

	@Override
	public void addDetail(SaleOrderLine o) {
		this.sqlSession.insert("com.yc.dao.SaleOrderDaoMapper.addDetail", o);
	}

	@Override
	public void delOrderLine(SaleOrderLine saleOrderLine) {
		this.sqlSession.delete("com.yc.dao.SaleOrderDaoMapper.delOrderLine",saleOrderLine);
	}

	@Override
	public void updateDetail(SaleOrderLine o) {
		this.sqlSession.update("com.yc.dao.SaleOrderDaoMapper.updateDetail",o);
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	
}
