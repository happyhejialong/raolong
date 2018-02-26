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
   <form id="productInfo">
   	<table >
   		<tr>
   			<td><label>货品名称:</label></td>
   			<td><input name=name type="text" class="dfinput" /></td>

   		</tr>
   		<tr>
   		    <td><label>货品分类:</label></td>
   			<td><input name="category" type="text" class="dfinput" value="123"/></td>
   		</tr>
   		<tr>
   			<td><label>货品图片:</label></td>
   			<td><input name="image" type="text" class="dfinput" /></td>
   		</tr>
   		<tr>
   			<td><label>货品价格:</label></td>
   			<td><input name="price" type="text" class="dfinput" /></td>
   		</tr>
   	</table>
   		<div>
   			<input type="button" id="okBtn" value="添加" width="100px" height="50px"/>
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
			var productInfo=$("#productInfo").serialize();
			$.ajax({
				url:'/product/add',
				type:'post',
				data:productInfo,
				success:function(result){
					if(result.code==200){
						alert('添加成功');
					}else{
						alert('添加失败');
					}
				}
			});
		});
	
	})
</script>
</html>