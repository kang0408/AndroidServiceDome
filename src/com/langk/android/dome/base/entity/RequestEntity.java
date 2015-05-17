package com.langk.android.dome.base.entity;

import java.util.List;
/**
 * 客户端入参基类
 * 入参name永远是jsonstr
 * @author K
 */
public class RequestEntity<T>{
	
	/**
	 * 访问的接口名
	 */
	private String C;
	/**
	 * 入参的键值对
	 */
	private List<FilterEntity> F;
	/**
	 * 对象的JSON字符串
	 */
	private T D;
	
	public String getC() {
		if (C==null) {
			C = "";
		}
		return C;
	}
	public void setC(String c) {
		C = c;
	}
	public List<FilterEntity> getF() {
		return F;
	}
	public void setF(List<FilterEntity> f) {
		F = f;
	}
	public T getD() {
		return D;
	}
	public void setD(T d) {
		D = d;
	}
	


}
