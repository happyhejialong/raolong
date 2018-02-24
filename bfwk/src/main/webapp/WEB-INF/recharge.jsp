<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${app}/static/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${app}/static/js/jquery.js"></script>
<script language="javascript">
$(function(){	
	$("#btn1").click(function(){
		var cardID=$("input[name='cardID']").val();
		var money=$("input[name='money']").val();
		$.post("/user/recharge",{'cardID':cardID,'money':money});
	});
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	});
	var websocket=null;
	if('WebSocket' in window){
		websocket=new WebSocket('ws://localhost:8070/webSocket');
	}else{
		alert('浏览器不支持webSocket');
		return;
	}
	websocket.onopen=function(){
		
	};
	websocket.onclose=function(){
		
	};
	websocket.onmessage=function(message){
		alert(message);
		var music=$("#myAudio")[0];
		music.play();
	}
})	
</script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
</head>


<body>
	<audio id="myAudio" src="${app}/static/mp3/8858.mp3" loop="false"></audio>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">用户注册</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="${app}/static/images/t01.png" /></span>添加</li>
        <li class="click"><span><img src="${app}/static/images/t02.png" /></span>修改</li>
        <li><span><img src="${app}/static/images/t03.png" /></span>删除</li>
        <li><span><img src="${app}/static/images/t04.png" /></span>统计</li>
        </ul>
        
        
        <ul class="toolbar1">
        <li><span><img src="${app}/static/images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="100px;">头像</th>
    <th></th>
    <th></th>
    <th>充值金额</th>
    <th></th>
    <th>是否审核</th>
    <th>点击</th>
    </tr>
    </thead>
    
    <tbody>
    <tr>
  		<td>头像</td>
  		<td><img src="${user.headImg}" width="100px;"/></td>
  	</tr>
  	<tr>
  		<td>昵称</td>
  		<td><input type="text" name="nickname" value="${user.nickname}" readonly="readonly"/></td>
  	</tr>
  	<tr>
  		<td>身份证号</td>
  		<td><input type="text" name="cardID" value="${user.cardID}" readonly="readonly"/></td>
  	</tr>
  	<tr>
  		<td>充值金额</td>
  		<td><input type="text" name="money"/></td>
  	</tr>
 	
 	<tr>
 		<td colspan="2" align="center"><input type="button" id="btn1" value="点击充值"></td>
    </tr>
    </tbody>
    
    </table>

    
    
 
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="${app}/static/images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="${app}/static/images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
</body>
</html>