<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <base href="<%=basePath %>" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin index Examples</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet" href="assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="assets/css/app.css">
    <script src="assets/js/jquery.min.js"></script>
    <script src="js/login.js"></script>
</head>
<body data-type="login">
    <script src="assets/js/theme.js"></script>
    <div class="am-g tpl-g">
        <!-- 风格切换 -->
        <div class="tpl-skiner">
            <div class="tpl-skiner-toggle am-icon-cog">
            </div>
            <div class="tpl-skiner-content">
                <div align="center" class="tpl-skiner-content-title">
                    <h1>用户登录</h1>
                </div>
                <div align="center" class="tpl-skiner-content-title">
                    <h3>
                    <c:if test="${fail==0}"><font color="red">用户名或密码为空</font></c:if>
                    <c:if test="${fail==1}"><font color="red">用户名不存在</font></c:if>
                    <c:if test="${fail==2}"><font color="red">用户密码错误</font></c:if>
                    </h3>
                </div>
                <div class="tpl-skiner-content-bar">
                    <span class="skiner-color skiner-white" data-color="theme-white"></span>
                    <span class="skiner-color skiner-black" data-color="theme-black"></span>
                </div>
            </div>
        </div>
        <div class="tpl-login">
            <div class="tpl-login-content">
                <div class="tpl-login-logo">
                </div>
                <form name="loginFrm" class="am-form tpl-form-line-form" action="LoginServlet" onsubmit="return loginCheck()" >
                    <div class="am-form-group">
                    	<input type="hidden" value="login" name="method" />
                        <input type="text" class="tpl-form-input" id="uname" name="uname" onblur="loginCheckUname()" onfocus="loginSpanUname()" placeholder="请输入账号">
						<span id="unameSpan"></span>
                    </div>

                    <div class="am-form-group">
                        <input type="password" class="tpl-form-input" id="upwd" name="upwd" onblur="loginCheckUpwd()" onfocus="loginSpanUpwd()" placeholder="请输入密码">
						<span id="upwdSpan"></span>
                    </div>
                    <div class="am-form-group tpl-login-remember-me">
                        <input id="remember-me" type="checkbox">
                        <label for="remember-me">
                        记住密码
                         </label>
                    </div>
                    <div class="am-form-group">
                        <input type="submit"  class="am-btn am-btn-primary  am-btn-block tpl-btn-bg-color-success  tpl-login-btn" value="提交"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script src="assets/js/amazeui.min.js"></script>
    <script src="assets/js/app.js"></script>
</body>
</html>