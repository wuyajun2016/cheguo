<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/nav/css/style.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath }/nav/js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/nav/js/SuperSlide.2.1.js"></script>
<script src="${pageContext.request.contextPath }/nav/js/zzsc.js" type="text/javascript"></script>
</head>
<body style="text-align:center">
<div style="margin-top:10px;margin-right:850px;">
<span style="color:#3C8DC4">当前用户：${username }，</span>
<c:if test="${username!=null }">
 <a href="${pageContext.request.contextPath }/logout.action" onclick="quit()">退出</a>
</c:if>
</div>

<br>
	<div class="navBar">
		<ul class="nav clearfix">
			<li class="m">
			<h3><a target="" href="">网站首页</a>欢迎页！</h3>
			</li>
			<li class="s">|</li>
			<li class="m">
			<h3><a target="iframe1" href="${pageContext.request.contextPath }/items/queryItems.action">产品管理</a></h3>
			</li>
			<li class="s">|</li>
			<li class="m">
			<h3><a target="_blank" href="">XXXX</a></h3>
			<ul class="sub">
				<li><a href="" title="XXXX">XXXX</a></li>
				<li><a href="" title="XXXX">XXXX</a></li>
				<li><a href="" title="XXXX">XXXX</a></li>
				<li><a href="" title="XXXX">XXXX</a></li>
			</ul>
			</li>
			<li class="s">|</li>
			<li class="m">
			<h3><a target="_blank" href="">XXXX</a></h3>
			<ul class="sub" style="display: none;">
				<li><a href="" title="XXXX">XXXX</a></li>
				<li><a href="" title="XXXX">XXXX</a></li>
				<li><a href="" title="XXXX">XXXX</a></li>
				<li><a href="" title="XXXX">XXXX</a></li>
			</ul>
			</li>
			<li class="s">|</li>
			<li class="m">
			<h3><a target="_blank" href="" title="XXXX">XXXX</a></h3>
			<ul class="sub" style="display: none;">
				<li><a href="" title="XXXX">XXXX</a></li>
				<li><a href="" title="XXXX">XXXX</a></li>
				<li><a href="" title="XXXX">XXXX</a></li>
				<li><a href="" title="XXXX">XXXX</a></li>
			</ul>
			</li>
			<li class="s">|</li>
			<li class="m">
			<h3><a target="_blank" href="" title="XXXX">XXXX</a></h3>
			<ul class="sub" style="display: none;">
				<li><a href="" title="XXXX">XXXX</a></li>
				<li><a href="" title="XXXX">XXXX</a></li>
				<li><a href="" title="XXXX">XXXX</a></li>
				<li><a href="" title="XXXX">XXXX</a></li>
			</ul>
			</li>
			<li class="s">|</li>
			<li class="m">
			<h3><a target="_blank" href="Job.aspx" title="XXXX">XXXX</a></h3>
			</li>
			<li class="s">|</li>
			<li class="m">
			<h3><a target="_blank" href="Contact.aspx" title="XXXX">XXXX</a></h3>
			</li>
			<li class="block" style="left: 251px;"></li>
		</ul>
	</div>
	
	<div>
	
	<iframe id="iframe1" name="iframe1" frameborder="0" scrolling="auto" width=980 height=800></iframe>
	
	</div>
</body>
</html>