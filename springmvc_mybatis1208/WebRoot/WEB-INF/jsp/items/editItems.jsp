<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
		<style type="text/css">
span {
	color: black;
	font-size:15px;
	margin-left:200px;
	margin-bottom:200px;
}


body {
	margin: 0;
	padding: 0;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 550px;
	padding: 19px 29px 29px;
	margin: 0 auto;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

table { /* max-width: 100%; */
	background-color: transparent;
	border-collapse: collapse;
	border-spacing: 0;
}

.table {
	width: 40%;
	margin-bottom: 20px;
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}

.labelError {
	line-height: 9px;
	font-size: 10pt;
	color: #f40000;
	border: 1px #ffb8b8 solid;
	padding: 8px 8px 8px 35px;
	background: url(/Shopping/image/error.png) no-repeat;
	background-color: #fef2f2;
}
</style>
</head>
<body> 

<form class="form-signin" id="itemForm" action="${pageContext.request.contextPath }/items/editItemsSubmit.html" method="post" >
<input type="hidden" name="id" value="${itemsCustom.id }"/>
<span>修改商品信息</span>
<p></p>
<table >
<tr>
	<td>商品名称</td>
	<td><input class="input" type="text" name="name" value="${itemsCustom.name }"/></td>
</tr>
<tr>
	<td>商品价格</td>
	<td><input class="input" type="text" name="price" value="${itemsCustom.price }"/></td>
</tr>
<tr>
	<td>商品生产日期</td>
	<td><input class="input" type="text" name="createtime" value="<fmt:formatDate value="${itemsCustom.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
</tr>
<%-- <tr>
	<td>商品图片</td>
	<td>
		<c:if test="${item.pic !=null}">
			<img src="/pic/${item.pic}" width=100 height=100/>
			<br/>
		</c:if>
		<input type="file"  name="pictureFile"/> 
	</td>
</tr> --%>
<tr>
	<td>商品简介</td>
	<td>
	<textarea rows="3" cols="30" name="detail">${itemsCustom.detail }</textarea>
	</td>
</tr>
<tr>
<td colspan="2" align="center"><input class="btn btn-primary" type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>