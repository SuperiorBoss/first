package com.yc.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.yc.bean.SaleProduct;
import com.yc.dao.SaleProductDao;

@Repository
public class SaleProductDaoMybatisImpl implements SaleProductDao {
	@Resource(name="sqlSession")
	private SqlSessionTemplate sqlSession;
	@Override
	public List<SaleProduct> findAll() {
		return sqlSession.selectList("com.yc.dao.SaleProductDaoMapper.findAll");
	}
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	

}
