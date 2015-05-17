package com.langk.android.dome.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* 以 UTF-8 输入输出
* 
* @author K
* 
*/
public class FilterChar implements Filter {

  private String config;

  public void destroy() {
    this.config = null;
  }

  /**
    * name="FilterChar" <br>
    * init-param name="config" value="utf-8"<br>
    * mapping url-pattern="/*"<br>
    */
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req;
    req = (HttpServletRequest) request;

    HttpServletResponse res;
    res = (HttpServletResponse) response;

    req.setCharacterEncoding(config);
    res.setCharacterEncoding(config);
    chain.doFilter(req, res);

  }

  /**
    * 获得web.xml中初始化的参数
    */
  public void init(FilterConfig config) throws ServletException {
    this.config = config.getInitParameter("chars");
  }

}
 