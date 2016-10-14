<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>系统登陆</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.7.1.min.js"></script>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
function requestJson(){
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/login.action',
		dataType: 'text', 
		//数据格式是json串，商品信息
		data:{ "username":$("input[name=username]").val(),
			   "password":$("input[name=password]").val()
			  },
		success:function(data){//返回json结果
			var json = JSON.parse(data); 
			if (json && json.success == true) {  
				window.location.href = '${pageContext.request.contextPath }'+json.success_redict;  
            } else {  
               document.getElementById('messagewarming').innerHTML=json.error
           }  
		},
		
	});
}
//    $("input[messagewarming]").val(json.error);  如果是input可以这么写入
</script>
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,p,blockquote,th,td
	{
	margin: 0;
	padding: 0;
}

.form-signin {
	max-width: 500px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 15px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}

h1 {
	color: #fff;
	background: #06b;
	padding: 10px;
	font-size: 200%;
	text-align: center;
}
.labelError{line-height: 9px; font-size: 10pt; color: #f40000; border: 1px #ffb8b8 solid; padding: 8px 8px 8px 35px; background: no-repeat; background-color: #fef2f2;}
</style>
</head>
<body>


<!--<form>用户账号：<input type="text" name="username" /><br/>
用户密码 ：<input type="password" name="password" /><br/>
<input type="button" value="登陆" onclick="requestJson()"/><br/><br/>
<span id="messagewarming" style="font-size:12px;color:red"></span></form> -->

<div>
		<form class="form-signin">
			<h2 class="form-signin-heading">登录</h2>
			<hr>
		    <table>

		    
		            <tr>
	                     <td align="right">用户名：</td>	            
		                 <td><input type="text" name="username" id="username" class="input" value=""></td>	  
		            </tr>
		            
		             <tr>
	                     <td align="right">密码：</td>	            
		                 <td><input type="password" name="password" id="password" class="input" value=""></td> 	  
		            </tr>

		             <tr>
	                     <td ></td>	            
		                 <td><button type="button"  class="btn btn-primary" onclick="requestJson()">登陆</button></td>
		                 <td></td>	  	  
		            </tr>
		            
		            <tr>
	                     <td ></td>	            
		                 <td><font id="messagewarming" style="font-size:12px;color:red"></font></td>
		                 <td></td>	  	  
		            </tr>
		    </table>
		</form>
	</div>

</body>
</html>