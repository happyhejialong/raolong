<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${app}/static/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${app}/static/js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		function isEmpty(name,text){
			if(text==''){
				alert(name+"不为空！！");
				return ;
			}
		}
		$("#mdBtn").click(function(){
			var nickname=$("input[name='nickname']").val();
			var birthday=$("input[name='birthday']").val();
			var gender=$("input[name='gender']").val();
			var balance=$("input[name='balance']").val();
			isEmpty('nickname',nickname);
			isEmpty('birthday',birthday);
			isEmpty('gender',gender);
			isEmpty('balance',balance);
		});
		
	});
</script>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    	--
    <li><a href="">账号设置</a></li>
    	 |
   	<li><a href="javascript:windows.locations.href=go(-1)">返回</a></li>
    </ul>
    </div>
    
    <div class="mainindex">
    
    
    <div class="welinfo">
    <span><img src="${app}/static/images/sun.png" alt="天气" /></span>
    <b>${user.username}早上好，欢迎使用信息管理系统</b>
    </div>
    
   
    <div class="xline"></div>
    <form action="/user/modifyUser" method="post">
    	昵称&nbsp;&nbsp;&nbsp;<input type="text" name="nickname" value="${user.nickname}"/><br/>
		生日&nbsp;&nbsp;&nbsp;<input type="text" name="birthday" value="${user.birthday}"/><br/>
       	性别&nbsp;&nbsp;&nbsp;
       		<input type="radio" name="gender" value='M'  <c:if test="${user.gender=='M'}">checked='true'</c:if>/>男
       		&nbsp;&nbsp;&nbsp;
       		<input type="radio" name="gender" value='W'  <c:if test="${user.gender=='W'}">checked='true'</c:if>/>女
       	<br/>          
                        余额 &nbsp;&nbsp;&nbsp;<input type="text" name="balance" value="${user.balance}"/><br/>
 		<input id="mdBtn" class="ibtn" type="button" value="修改"/>
	</form>
    
   	
    <div class="info"><b>查看网站使用指南，您可以了解到多种风格的B/S后台管理界面,软件界面设计，图标设计，手机界面等相关信息</b>(More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>)</div>
    
    <ul class="umlist">
    <li><a href="#">如何发布文章</a></li>
    <li><a href="#">如何访问网站</a></li>
    <li><a href="#">如何管理广告</a></li>
    <li><a href="#">后台用户设置(权限)</a></li>
    <li><a href="#">系统设置</a></li>
    </ul>
    
    
    </div>
</body>
</html>