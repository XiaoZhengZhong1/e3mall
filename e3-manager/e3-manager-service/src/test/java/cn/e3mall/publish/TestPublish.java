/*package cn.e3mall.publish;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


 * 本类演示用方法开启spring容器,本次的"宜立方商城"项目所有的服务发布和接受都是用dobbo!而项目中
 * 配置的tomcat只是起到一个初始化spring容器的效果.
 * 本类演示用类中是方法开器sprng容器,不开启e3-marager项目(就不启动项目中Tomcat的8080端口)
 * 开启e3-marager-web服务层tomcat8081端口,看是否能访问到后台首页正常进行增删改查
 * 
public class TestPublish {
	//本类演示项目服务和tomcat没关系,tomcat只是初始化spring容器.服务都是由dubbo处理
	@Test
	public void publishService() throws Exception {
		表示创建了上下文就是整个项目应用对象,加载了spring的所有配置文件,就是初始化了spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		
		//延长对象寿命方法1:
		System.out.println("服务已经启动。。。。");
		System.in.read()在控制台等待键盘输入零结束方法.是为了延长方法,就是spring容器的开启时间
		 * 如果方法一运行就结束也就关闭了sprign容器.那浏览器将无法访问到后台
		
		System.in.read();	//表示在控制台等待键盘输入:敲回车键就结束(结束方法,就是关闭spring容器)
		
		
		System.out.println("服务已经关闭");
		
		
		
		////延长对象寿命方法2
		//方法2;用死循环来延长方法中的对象(开启spring容器对象)寿命,不让方法弹栈,对象消失
		while(true){
			//线程休眠一秒.表示每隔一秒钟循环一层
			Thread.sleep(1000);
		}
		
		
	}
}
*/