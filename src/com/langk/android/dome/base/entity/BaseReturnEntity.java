package com.langk.android.dome.base.entity;

/**
 * 返回客户端的基类
 * @author K
 *
 * @param <T>
 */
public class BaseReturnEntity<T> {
	
	/**
	 * 是否成功
	 */
	private boolean S;
	/**
	 * 状态码
	 */
	private String C;
	/**
	 * 如果不成功，备注信息
	 */
	private String M;
	/**
	 * 成功后返回的数据源
	 */
	private T D;
	public boolean isS() {
		return S;
	}
	public void setS(boolean s) {
		S = s;
	}
	public String getC() {
		return C;
	}
	public void setC(String c) {
		C = c;
	}
	public String getM() {
		return M;
	}
	public void setM(String m) {
		M = m;
	}
	public T getD() {
		return D;
	}
	public void setD(T d) {
		D = d;
	}

}
