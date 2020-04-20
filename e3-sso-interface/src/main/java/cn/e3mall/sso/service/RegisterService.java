package cn.e3mall.sso.service;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.pojo.TbUser;

public interface RegisterService {

	//检查注册页面的输入数据
	E3Result checkData(String param , int type);
	
	//注册页面注册成功后添加到数据库
	E3Result register(TbUser user);
}
