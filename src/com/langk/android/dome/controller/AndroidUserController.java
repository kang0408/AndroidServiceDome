package com.langk.android.dome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.sym.Name;
import com.google.gson.reflect.TypeToken;
import com.langk.android.dome.base.entity.BaseReturnEntity;
import com.langk.android.dome.base.entity.RequestEntity;
import com.langk.android.dome.db.impl.UserDAOImpl;
import com.langk.android.dome.entity.User;
/**
 * 用户请求控制类
 * @author K
 *
 */
@Controller
@RequestMapping("/Android/user")
public class AndroidUserController extends AndroidBaseController {

	/**
	 * 用户登录传递的Name参数名
	 */
	private static final String EMAIL = "email";
	/**
	 * 用户登录传递的PWD参数名
	 */
	private static final String PWD = "password";
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public @ResponseBody BaseReturnEntity<Object> login(@RequestParam("jsonstr") String jsonstr) {
		RequestEntity<String> requestEntity;
		try {
			requestEntity = gson.fromJson(jsonstr, new TypeToken<RequestEntity<String>>(){}.getType());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			requestEntity = null;
		}
		if (requestEntity==null) {
			return getFailReturnEntity("入参格式不正确");
		}
		if (requestEntity.getF()==null||requestEntity.getF().size()==0) {
			return getFailReturnEntity("参数不能为空");
		}
		String emailString,password = null;
		for (int i = 0; i < requestEntity.getF().size(); i++) {
			if (requestEntity.getF().get(i).getN().equals(EMAIL)) {
				emailString = requestEntity.getF().get(i).getV();
				continue;
			}
			if (requestEntity.getF().get(i).getN().equals(PWD)) {
				password = requestEntity.getF().get(i).getV();
				continue;
			}
		}
		
		User user = new User();
		user.setAge(1);
		user.setName("张帅");
		return getSuccessReturnEntity(user);
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public @ResponseBody BaseReturnEntity<Object> register(@RequestParam("jsonstr") String jsonstr) {
//		RequestEntity<User> requestEntity = gson.fromJson(jsonstr, new TypeToken<RequestEntity<User>>(){}.getType());
//		if (requestEntity==null) {
//			return getFailReturnEntity("入参格式不正确");
//		}
//		if (requestEntity.getD()==null) {
//			return getFailReturnEntity("参数不能为空");
//		}
		
		User user = new User();
		user.setAge(1);
		user.setName("张帅");
		try {
			new UserDAOImpl().saveUser(user);
			return getSuccessReturnEntity("注册成功");
		} catch (Exception e) {
			e.printStackTrace();
			return getFailReturnEntity("注册失败");
		}
	}

}
