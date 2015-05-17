package com.langk.android.dome.servlet;

import javax.servlet.http.HttpServlet;

import com.google.gson.Gson;
import com.langk.android.dome.base.entity.BaseReturnEntity;

public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = -2806565079751056363L;

	protected Gson gson = new Gson();
	/**
	 * 获取失败后的返回对象
	 */
	protected String getFailReturnEntity(String C, String M) {
		// TODO Auto-generated method stub
		BaseReturnEntity<String> entity = new BaseReturnEntity<String>();
		entity.setS(false);
		entity.setC(C);
		entity.setM(M);
		entity.setD("");
		return  gson.toJson(entity);
	}
	
	/**
	 * 获取失败后的返回对象
	 * 默认错误状态码是001
	 */
	protected String getFailReturnEntity(String M) {
		// TODO Auto-generated method stub
		BaseReturnEntity<String> entity = new BaseReturnEntity<String>();
		entity.setS(false);
		entity.setC("001");
		entity.setM(M);
		entity.setD("");
		return  gson.toJson(entity);
	}

}
