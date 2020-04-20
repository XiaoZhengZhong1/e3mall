package cn.e3mall.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbUser;
import cn.e3mall.sso.service.RegisterService;

/**
 * 注册功能Controller
 * <p>Title: RegitsterController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Controller
public class RegitsterController {
	
	@Autowired
	private RegisterService registerService;
	
	
	//测试是否能访问到注册首页
	@RequestMapping("/page/register")
	public String showRegister() {
		return "register";
	}
	
	//检查注册页面的输入数据
	@RequestMapping("/user/check/{param}/{type}")
	@ResponseBody
	public E3Result checkData(@PathVariable String param, @PathVariable Integer type) {
		E3Result e3Result = registerService.checkData(param, type);
		return e3Result;
	}
	
	
	//注册页面注册成功后添加到数据库
	@RequestMapping(value="/user/register", method=RequestMethod.POST)
	@ResponseBody
	public E3Result register(TbUser user) {
		E3Result e3Result = registerService.register(user);
		return e3Result;
	}
}
