<%-- 
    Document   : Login
    Created on : 12 Apr, 2017, 8:31:39 PM
    Author     : Administrator
--%>
<%@page import="net.tanesha.recaptcha.ReCaptchaFactory"%>
<%@page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="icon" href="Network-Security.png" type="image/x-icon">
<!DOCTYPE html>
<html>

<head>
<style>
@import url(http://fonts.googleapis.com/css?family=Roboto:400,100);

body {

  background-image: url("grey.jpg");
  background-repeat: repeat-y;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
  font-family: 'Roboto', sans-serif;
}

.login-card {
  
  top: 30%;
  padding: 40px;
  width: 500px;
   background-color: white;
  margin: 0 auto 10px;
  border-radius: 20px;
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  overflow: hidden;
}

.login-card h1 {
  font-weight: 100;
  text-align: center;
  font-size: 2.3em;
}

.login-card input[type=submit] {
  width: 100%;
  display: block;
  margin-bottom: 10px;
  position: relative;
}

.login-card input[type=text], input[type=password] {
  height: 44px;
  font-size: 16px;
  width: 100%;
  margin-bottom: 10px;
  -webkit-appearance: none;
  background: #fff;
  border: 1px solid #d9d9d9;
  border-top: 1px solid #c0c0c0;
  /* border-radius: 2px; */
  padding: 0 8px;
  box-sizing: border-box;
  -moz-box-sizing: border-box;
}

.login-card input[type=text]:hover, input[type=password]:hover {
  border: 1px solid #b9b9b9;
  border-top: 1px solid #a0a0a0;
  -moz-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
  -webkit-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
  box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
}

.login {
  text-align: center;
  font-size: 14px;
  font-family: 'Arial', sans-serif;
  font-weight: 700;
  height: 36px;
  padding: 0 8px;
/* border-radius: 3px; */
/* -webkit-user-select: none;
  user-select: none; */
}

.login-submit {
  /* border: 1px solid #3079ed; */
  width: 150px;
  border: 0px;
  color: #fff;
  text-shadow: 0 1px rgba(0,0,0,0.1); 
  background-color: #a6a6a6;
  /* background-image: -webkit-gradient(linear, 0 0, 0 100%,   from(#4d90fe), to(#4787ed)); */
}

.login-submit:hover {
  /* border: 1px solid #2f5bb7; */
  border: 0px;
  text-shadow: 0 1px rgba(0,0,0,0.3);
  background-color: #ff0000;
  /* background-image: -webkit-gradient(linear, 0 0, 0 100%,   from(#4d90fe), to(#357ae8)); */
}

.login-card a {
  text-decoration: none;
  color: #666;
  font-weight: 400;
  text-align: center;
  display: inline-block;
  opacity: 0.6;
  transition: opacity ease 0.5s;
}

.login-card a:hover {
  opacity: 1;
}

.login-help {
  width: 100%;
  text-align: center;
  font-size: 12px;
}



</style>



  <meta charset="UTF-8">

  <title>Forgot Password</title>

  <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'>

    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
<title>Forgot Password</title>
</head>
<br><br><br><br><br>
  <div class="login-card">
  <div align="center">
    <img src="PaladionLogo.png"/>
    </div>
    <center><h4 style="color: #ff0000">${Message}</h4></center>
    <h1>Forgot Password</h1><br>
    
    <!-- UI goes here-->
    <form:form action="ForgotPassword.do" method="post"> 
        Email ID: <input type="email" name="emailId"/>
        <%
          ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LdILiQUAAAAADnLG0a6cHtsTag3ey10y652yvGK", "6LdILiQUAAAAAPJwovQaU6ezxtcIoa2FEFS70KgO", false);
          out.print(c.createRecaptchaHtml(null, null));
        %>
        <br>
        <button type="submit" class="login login-submit">Reset</button><br><br>
           
        </form:form>
    
       <form action="Login.do" method="GET">
            <div align="left"><button type="submit" class="login login-submit">Go to Login</button></a></div>
            </form>
        <!-- UI goes here-->
        <script src='http://codepen.io/assets/libs/fullpage/jquery_and_jqueryui.js'></script>
  </div>
  
 
</body>  
</html>



