package cn.e3mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
//演示展示前端页面
	@RequestMapping("/")
	public String getPage(){
		return "index";
	}
	
	//根据前端请求的具体内容,返回和该内容对应的页面,项目中有和请求参数一样的.jsp静态页面
	@RequestMapping("/{page}") 	//page代表页面参数占位符
													//直接获取页面具体的参数 定义为page
	public String showPage(@PathVariable String page){
		
		return page;			//返回获取的参数,配置文件中给定义返回值配置了jsp后缀,表示返回请求参数.jsp页面
	}
	
}
