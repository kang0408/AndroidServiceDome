package com.langk.android.dome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.langk.android.dome.base.entity.BaseReturnEntity;

@Controller
public class AndroidController extends AndroidBaseController {

	
	@RequestMapping(value="/*",method=RequestMethod.GET)
	public @ResponseBody BaseReturnEntity<Object> baseDispatch(@RequestParam("jsonstr") String jsonstr) {
		return getFailReturnEntity("002","未定义CommonName");
	}

}
