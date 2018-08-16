package com.yc.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.yc.bean.CusCustomer;
import com.yc.bean.JsonModel;
import com.yc.biz.CusCustomerBiz;

@Controller
@Scope(value="prototype")
public class CusCustomerController {
	
	@Resource(name="cusCustomerBizImpl")
	private CusCustomerBiz cusCustomerBiz;
	
	@RequestMapping(name="cusCustomer_findAll.action")
	public String findAll(HttpSession session) {
		JsonModel jm = new JsonModel();
		Gson gson = new Gson();
		List<CusCustomer> list = cusCustomerBiz.findAll();
		jm.setCode(1);
		jm.setObj(list);
		String jsonModel = gson.toJson(jm);
		session.setAttribute("jsonModel", jsonModel);
		return "result"	;
	}
}
