package com.langk.android.dome.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.rmi.runtime.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.langk.android.dome.base.entity.BaseReturnEntity;
import com.langk.android.dome.base.entity.ConfigEntity;
import com.langk.android.dome.base.entity.RequestEntity;
import com.langk.android.dome.entity.User;

/**
 * Android客户端访问的Servlet
 * 
 * @author K
 *
 */
public class AndroidUserServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7854773704690252697L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String resultContext = "";
		String requestContext = (String) req
				.getParameter(ConfigEntity.REQUESTNAME);
		System.out.println(requestContext);
		RequestEntity requestEntity ;
		try {
			requestEntity = gson.fromJson(requestContext, new TypeToken<RequestEntity>(){}.getType());
		} catch (Exception e) {
			e.printStackTrace();
			resultContext = getFailReturnEntity("入参格式不正确");
			resp.getWriter().print(resultContext);
			resp.getWriter().close();
			return;
		}
		if (requestEntity==null) {
			resultContext = getFailReturnEntity("入参格式不正确");
			resp.getWriter().print(resultContext);
			resp.getWriter().close();
			return;
		}
		
		if (requestEntity.getC().equals(ConfigEntity.LOGINCOMMON)) {
			User user = new User();
			user.setId("1");
			user.setName("json");
			user.setPassword("password");
			user.setSex("man");
			user.setAge(12);
			resp.getWriter().print(gson.toJson(user));
			resp.getWriter().close();
			return;
		}
		
		resultContext = getFailReturnEntity("002","未定义CommonName");
		resp.getWriter().print(resultContext);
		resp.getWriter().close();
	}

	
}
