imglist.jsp<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${app}/static/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    	
    <div class="formbody">
    	
    <div class="formtitle"><span>基本信息</span></div>
   <div align="center">
   <form id="userInfo">
   	<table >
   		<tr>
   			<td><label>用户名:</label></td>
   			<td><input name="username" type="text" class="dfinput" /></td>

   		</tr>
   		<tr>
   		    <td><label>密码:</label></td>
   			<td><input name="password" type="text" class="dfinput" value="123"/></td>
   		</tr>
   		<tr>
   			<td><label>手机:</label></td>
   			<td><input name="phone" type="text" class="dfinput" /></td>
   		</tr>
   		<tr>
   			<td><label>生日:</label></td>
   			<td><input name="birthday" type="date" class="dfinput" /></td>
   		</tr>
   		<tr>
   			<td><label>年龄:</label></td>
   			<td><input name="age" type="text" class="dfinput" /></td>
   		</tr>
   		<tr>
   			<td><label>昵称:</label></td>
   			<td><input name="nickname" type="text" class="dfinput" /></td>
   		</tr>
   		<tr>
   			<td><label>余额:</label></td>
   			<td><input name="balance" type="text" class="dfinput" /></td>
   		</tr>
   	</table>
   		<div>
   			<input type="button" id="okBtn" value="注册" width="100px" height="50px"/>
   			<input type="reset" value="重置" width="100px" height="50px"/>
   		</div>
   	</form>
   </div>	
    
    </div>
</body>
<script src="/static/js/jquery.js"></script>
<script>
	$(function(){
		$('#okBtn').click(function(){
			var userInfo=$("#userInfo").serialize();
			alert(JSON.stringify(userInfo));
			$.ajax({
				url:'/user/register',
				type:'post',
				data:userInfo,
				success:function(result){
					alert(123);
					alert(JSON.stringify(result));
					if(result.code==200){
						alert('注册成功');
					}else{
						alert('注册失败');
					}
				}
			});
		});
	
	})
</script>
</html>