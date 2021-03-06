<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${app}/static/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${app}/static/js/jquery.js"></script>

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

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">数据表</a></li>
    <li><a href="#">基本内容</a></li>
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
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>编号<i class="sort"><img src="${app}/static/images/px.gif" /></i></th>
        <th>昵称</th>
        <th>性别</th>
        <th>余额</th>
        <th>上次登录时间</th>
        <th>等级</th>
        </tr>
        </thead>
        <tbody>
     <c:forEach items="${userList }" var="user"> 
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>${user.id }</td>
        <td>${user.nickname }</td>
        <td>
        	<c:if test="${fn:trim(user.gender) eq 'M'}"><font style='color:green'>男</font></c:if>
        	<c:if test="${fn:trim(user.gender) eq 'W'}"><font style='color:pink'>女</font></c:if>
        </td>
        <td><fmt:formatNumber type="NUMBER" value="${user.balance }"/></td>
        <td>1234</td>
        <td>${user.level }</td>
        <td><a href="#" class="tablelink">查看</a>     <a href="#" class="tablelink"> 删除</a></td>
        </tr> 
      </c:forEach>    
      
        </tbody>
    </table>
    
   
    <div class="pagin">
    	<div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem"><a href="/user/toRight?number=1">1</a></li>
        <li class="paginItem current"><a href="/user/toRight?number=2">2</a></li>
        <li class="paginItem"><a href="/user/toRight?number=3">3</a></li>
        <li class="paginItem"><a href="/user/toRight?number=4">4</a></li>
        <li class="paginItem"><a href="/user/toRight?number=5">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
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
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>