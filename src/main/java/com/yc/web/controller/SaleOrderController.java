package com.yc.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.yc.bean.JsonModel;
import com.yc.bean.SaleOrder;
import com.yc.bean.SaleOrderLine;
import com.yc.biz.SaleOrderBiz;

@Controller
@Scope(value="prototype")
public class SaleOrderController {
	
	@Resource(name="saleOrderBizImpl")
	private SaleOrderBiz saleOrderBiz;
	
	@RequestMapping(value="saleOrder_save.action")
	public String findAll(SaleOrder saleOrder,HttpSession session) {
		this.saleOrderBiz.add(saleOrder);
		Long odrId = saleOrder.getOdrId();
		JsonModel jm = new JsonModel();
		jm.setCode(1);
		jm.setObj(odrId);
		Gson gson = new Gson();
		String result = gson.toJson(jm);
		session.setAttribute("jsonModel", result);
		return "result";
	}
	
	@RequestMapping(value="saleOrder_findOrderWithDetail.action")
	public String findOrderWithDetail(HttpSession session,long odrId) {
		SaleOrder saleOrder = saleOrderBiz.getWithLines(odrId);
		JsonModel jm = new JsonModel();
		jm.setCode(1);
		jm.setObj(saleOrder);
		Gson gson = new Gson();
		String json = gson.toJson(jm);
		session.setAttribute("jsonModel", json);
		return "result";
	}
	
	@RequestMapping(value="saleOrder_saveOrderLine.action")
	public String saveOrderLine(HttpSession session,SaleOrderLine line) {
		saleOrderBiz.addDetail(line);
		JsonModel jm = new JsonModel();
		jm.setCode(1);
		Gson gson = new Gson();
		String json = gson.toJson(jm);
		session.setAttribute("jsonModel", json);
		return "result";
	}
	
	@RequestMapping(value="saleOrder_delOrderLine.action")
	public String delOrderLine(HttpSession session,long odlId) {
		SaleOrderLine line = new SaleOrderLine();
		line.setOdlId(odlId);
		saleOrderBiz.delOrderLine(line);
		JsonModel jm =new JsonModel();
		jm.setCode(1);
		Gson gson = new Gson();
		String json = gson.toJson(jm);
		session.setAttribute("jsonModel", json);
		return "result";
	}
}
