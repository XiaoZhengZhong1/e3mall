<html>
<head>
	<title>student</title>
</head>
<body>
	学生信息：<br>
	学号：${student.id}&nbsp;&nbsp;&nbsp;&nbsp;
	姓名：${student.name}&nbsp;&nbsp;&nbsp;&nbsp;
	年龄：${student.age}&nbsp;&nbsp;&nbsp;&nbsp;
	家庭住址：${student.address}<br>
		学生列表：
	<table border="1">
		<tr>
			<th>序号</th>
			<th>学号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>家庭住址</th>
		</tr>
		<#list stuList as stu>
		<#if stu_index % 2 == 0>
		<tr bgcolor="red">
		<#else>
		<tr bgcolor="green">
		</#if>
			<td>${stu_index}</td>
			<td>${stu.id}</td>
			<td>${stu.name}</td>
			<td>${stu.age}</td>
			<td>${stu.address}</td>
		</tr>
		</#list>
	</table>
	<br> 
	<!--                                      获取日期     获取时间    获取日期和时间    	获取指定类型年月日时分秒			 -->
	<!-- 日期格式可以使用key后面跟上?date, 或者 ?time, 或者 ?datetime,或者?string("yyyy/MM/dd HH:mm:ss")-->
	当前日期：${date?string("yyyy/MM/dd HH:mm:ss")}<br>
	<!--如果获取的值可能为空,在key后面跟上!感叹号即可.感叹号后面可以有自定义的提示语句比喻 !此值为空-->
	null值的处理：${val!}<br>
	<#if val??>
		val有值
	<#else>
		val的值为空
	</#if><br>
	引用别的文件模板测试：<br>
	<!--前提是项目中的freemarker引用中,必须有引用的模板的内容.即模板中的相关的对象或者是键-->
	<#include "hello.ftl">
</body>
</html>