<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${app}/static/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${app}/static/js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>通讯录</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="${app}/static/images/leftico01.png" /></span>管理信息
    </div>
    	<ul class="menuson">
    	
        <li class="active"><cite></cite><a href="/page/toindex" target="rightFrame">首页模版</a><i></i></li>
        <li><cite></cite><a href="/user/toRight" target="rightFrame">用户列表</a><i></i></li>
        <li><cite></cite><a href="/page/torecharge" target="rightFrame" id="recharge">用户充值</a><i></i></li>
        <li><cite></cite><a href="/page/toregister" target="rightFrame">用户注册</a><i></i></li>
       <!--  
        <li><cite></cite><a href="/page/toimglist" target="rightFrame">图片列表</a><i></i></li>
        <li><cite></cite><a href="/page/toimglist1" target="rightFrame">自定义</a><i></i></li>
        <li><cite></cite><a href="/page/totools" target="rightFrame">常用工具</a><i></i></li>
        <li><cite></cite><a href="/page/tofilelist" target="rightFrame">信息管理</a><i></i></li>
        <li><cite></cite><a href="/page/totab" target="rightFrame">Tab页</a><i></i></li>
        <li><cite></cite><a href="/page/toerror" target="rightFrame">404页面</a><i></i></li>
   		 -->
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="${app}/static/images/leftico02.png" /></span>网吧商城
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="#" target="rightFrame">食品</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">点卡</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">呼叫网管</a><i></i></li>
        </ul>     
    </dd> 
    
    
    <dd><div class="title"><span><img src="${app}/static/images/leftico03.png" /></span>货品管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="/page/toadd_product" target="rightFrame">添加货品</a><i></i></li>
        <li><cite></cite><a href="/product/list" target="rightFrame">货品列表</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">修改货品</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">其他</a><i></i></li>
    </ul>    
    </dd>  
    
    <dd><div class="title"><span><img src="${app}/static/images/leftico03.png" /></span>管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="#" target="rightFrame">修改费率</a><i></i></li>
         <li><cite></cite><a href="#" target="rightFrame">服务平台</a><i></i></li>
          <li><cite></cite><a href="#" target="rightFrame">工作考勤</a><i></i></li>
    </ul>    
    </dd>  
    
    
    <dd><div class="title"><span><img src="${app}/static/images/leftico04.png" /></span>日期管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="#" target="rightFrame">自定义</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">常用资料</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">信息列表</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">其他</a><i></i></li>
    </ul>
    
    </dd>   
    
    </dl>
</body>
</html>