package cn.e3mall.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;

@Controller
public class IndexController {
		//首页展示
	/*表示当页面访问8082端口时,会找e3-portal-web项目中的webapp下面的index首页,没有就会到
	 * WEB-INF下面找,就会到web.xml中的欢迎首页中,就会被spring前端控制器拦截,就到控制层
	 * 我们现在的controller来了
	 */
	
	
	
	//实现e3-protal-web商品首页轮播图从数据库中动态获取
			/*返回结果是一个商品集合LIst<TbContent> 参数是根据商品表中的外键cid ,表示商品表中的内容都是
			 * cid外键表中的大广告的内容*/
			
	
	//使用配置文件注解,从配置文件中获取首页需要展示的广告cid
		@Value("${CONTENT_LUNBO_ID}")
		private Long CONTENT_LUNBO_ID;
	
	@Autowired
	private ContentService contentService;
	
	
	
	@RequestMapping("/index")
	public String showIndex(Model model ){
		//根据配置文件中的id查询所有同一类的id商品信息    ad是广告的意思 1 代表大号广告
		List<TbContent> ad1List = contentService.getContentListByCid(CONTENT_LUNBO_ID);
		//返回页面一个逻辑视图  注意"ad1List"必须和首页index.jsp里面遍历的集合一致
		model.addAttribute("ad1List", ad1List);
		return "index";
	}
	
}
