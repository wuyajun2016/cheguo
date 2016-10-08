<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<script>
//请求key/value，输出是json
function responseJson(){

	var name = $('input[name=items_name]').val();
	        
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/items/searchItems.html',
		//请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
		//contentType:'application/json;charset=utf-8',
		//数据格式是json串，商品信息
		data: {
                'name': name
            },
		success:function(data){//返回json结果
			alert(data.name);
		}
		
	});
	
}
</script>

</head>
<body> 
<form action="${pageContext.request.contextPath }/items/searchItems.html" method="post">
<p></p>
<p></p>
<p></p>
&nbsp;&nbsp;商品名称：
<input type="text" value="" name="items_name"/>
<input type="button" value="查询" onclick="requestJson()" class="btn btn-primary"/>
<input type="submit" value="新增" class="btn btn-primary"/>
<table class="table table-striped">
<thead>
	<tr>
		<th>商品名称</th>
		<th>商品价格</th>
		<th>生产日期</th>
		<th>商品描述</th>
		<th>操作</th>
	</tr>
</thead>
<c:forEach items="${itemsList }" var="item">
<tr>
	<td>${item.name }</td>
	<td>${item.price }</td>
	<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td>${item.detail }</td>
	
	<td><a href="${pageContext.request.contextPath }/items/editItems.html?id=${item.id}"><button type="button" class="btn btn-primary">修改</button></a></td>


</tr>
</c:forEach>

</table>
</form>
</body>
</html>