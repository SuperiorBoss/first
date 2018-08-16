package com.yc.biz.test;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yc.bean.CusCustomer;
import com.yc.bean.SaleOrder;
import com.yc.bean.SaleOrderLine;
import com.yc.bean.SaleProduct;
import com.yc.biz.CusCustomerBiz;
import com.yc.biz.SaleOrderBiz;
import com.yc.biz.SaleProductBiz;

//junit启动时，就会自动地: ApplicationContext ac=new
//ClassPathXmlApplicationContext("classpath:beans.xml");
//创建容器自动经了.
@RunWith(SpringJUnit4ClassRunner.class) // 值: SpringJUnit4ClassRunner 表示使用spring
										// junit测试 -> 区别：自动地完成 ioc,di
										// JUnit 表示使用原生的 junit测试
@ContextConfiguration({ "classpath:applicationContext.xml", "classpath:applicationContext-dao.xml" }) // 告诉容器,
public class TestBizImpl {
	@Resource(name = "cusCustomerBizImpl")
	private CusCustomerBiz cusCustomerBiz;

	@Resource(name = "saleProductBizImpl")
	private SaleProductBiz saleProductBiz;

	@Resource(name = "saleOrderBizImpl")
	private SaleOrderBiz saleOrderBiz;

	@Test
	public void test1() throws Exception {
		System.out.println();
		List<CusCustomer> list = this.cusCustomerBiz.findAll();
		System.out.println(list);
	}

	@Test
	public void test2() throws Exception {
		List<SaleProduct> list = this.saleProductBiz.findAll();
		System.out.println(list);
	}

	@Test // 添加订单
	public void test3() throws Exception {
		SaleOrder so = new SaleOrder();
		so.setOdrCustomerId(1L);
		so.setOdrCustomerName("中国工业集团");
		so.setOdrDeliverAddr("北京兴华门32号");
		so.setOdrDeliverDate(new Date(117, 12, 2));
		so.setOdrOrderDate(new Date(117, 12, 2));
		so.setOdrStatus("1");
		this.saleOrderBiz.add(so);
	}

	@Test // 添加订单项
	//测试1： 向新的4号订单给订单项添加一个产品
	public void test4() throws Exception {
		SaleOrder s = new SaleOrder();
		s.setOdrId(14L);  
		SaleOrderLine so = new SaleOrderLine();
		so.setSaleOrder(s);
		so.setOdlProductName("GPS");
		so.setOdlProductPrice(3300.0);
		so.setOdlProductCount(100);
		this.saleOrderBiz.addDetail(so);
	}

	@Test // 删除订单项
	public void test5() throws Exception {
		SaleOrderLine so = new SaleOrderLine();
		so.setOdlId(4L);
		this.saleOrderBiz.delOrderLine(so);
	}

	@Test // 查询订单
	public void test6() throws Exception {
		SaleOrder so = this.saleOrderBiz.getWithLines(4L);
		System.out.println(so);
	}

}
