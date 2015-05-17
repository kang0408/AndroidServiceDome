package com.langk.android.dome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.langk.android.dome.base.entity.BaseReturnEntity;

@Controller
@RequestMapping("/Android")
public class AndroidBaseController {

	
	protected Gson gson = new Gson();
	/**
	 * 获取失败后的返回对象
	 */
	protected BaseReturnEntity<Object> getFailReturnEntity(String C, String M) {
		// TODO Auto-generated method stub
		BaseReturnEntity<Object> entity = new BaseReturnEntity<Object>();
		entity.setS(false);
		entity.setC(C);
		entity.setM(M);
		entity.setD("");
		return  entity;
	}
	
	/**
	 * 获取成功后的返回对象
	 */
	protected BaseReturnEntity<Object> getSuccessReturnEntity(Object o) {
		// TODO Auto-generated method stub
		BaseReturnEntity<Object> entity = new BaseReturnEntity<Object>();
		entity.setS(true);
		entity.setC("000");
		entity.setM("");
		entity.setD(o);
		return  entity;
	}
	
	/**
	 * 获取成功后的返回对象
	 */
	protected BaseReturnEntity<Object> getSuccessReturnEntity(String M) {
		// TODO Auto-generated method stub
		BaseReturnEntity<Object> entity = new BaseReturnEntity<Object>();
		entity.setS(true);
		entity.setC("000");
		entity.setM(M);
		entity.setD("");
		return  entity;
	}
	
	/**
	 * 获取失败后的返回对象
	 * 默认错误状态码是001
	 */
	protected BaseReturnEntity<Object> getFailReturnEntity(String M) {
		// TODO Auto-generated method stub
		BaseReturnEntity<Object> entity = new BaseReturnEntity<Object>();
		entity.setS(false);
		entity.setC("001");
		entity.setM(M);
		entity.setD("");
		return  entity;
	}
	
}
