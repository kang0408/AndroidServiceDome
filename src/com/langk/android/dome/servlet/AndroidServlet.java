package com.langk.android.dome.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.langk.android.dome.base.entity.BaseReturnEntity;

/**
 * Android客户端访问的Servlet
 * 
 * @author K
 *
 */
public class AndroidServlet extends BaseServlet {

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
		String resultContext = getFailReturnEntity("002","未定义CommonName");
		resp.getWriter().print(resultContext);
		resp.getWriter().close();
	}


}
