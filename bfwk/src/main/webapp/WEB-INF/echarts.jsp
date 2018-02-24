 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <script type="text/javascript" src="${app}/static/js/echarts.min.js"></script>
 <script src="${app}/static/js/jquery.js"></script>
 <script>
 	$(function(){
 		var myChart=echarts.init($("#main"));
 		myChart.showLoading();
 		var options={
 			title={
 				text:"年龄段";
 			},
 			tooltip:{
 				trigger:'axis'
 			},
 			legend:{
 				data:[]
 			}
 				
 		}
 	})
 </script>

  	
  <h3 class="page-title">
      Echarts 展示 <small>可视化图表</small>
 </h3>
 <body>
 	<div id="main"/>
 </body>
 