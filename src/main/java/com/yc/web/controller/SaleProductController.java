package com.yc.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.yc.bean.JsonModel;
import com.yc.bean.SaleProduct;
import com.yc.biz.SaleProductBiz;

@Controller
@Scope(value="prototype")
public class SaleProductController {
	
	@Resource(name="saleProductBizImpl")
	private SaleProductBiz biz;
	
	@RequestMapping(value="saleProduct_findAll.action")
	public String findAll(HttpSession session) {
		List<SaleProduct> list = biz.findAll();
		JsonModel jm = new JsonModel();
		jm.setCode(1);
		jm.setObj(list);
		System.err.println(list);
		Gson gson = new Gson();
		String json = gson.toJson(jm);
		session.setAttribute("jsonModel", json);
		return "result";
	}
}
